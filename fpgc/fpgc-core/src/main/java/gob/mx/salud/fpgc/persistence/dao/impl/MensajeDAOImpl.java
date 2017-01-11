package gob.mx.salud.fpgc.persistence.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import gob.mx.salud.fpgc.model.MensajeDTO;
import gob.mx.salud.fpgc.persistence.dao.MensajeDAO;
import gob.mx.salud.fpgc.persistence.mapper.MensajeDTOMapper;

/**
 * @author David Ruiz C
 *
 */
@Repository
public class MensajeDAOImpl implements MensajeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(MensajeDAOImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.persistence.dao.MensajeDAO#guardarMensaje(gob.mx.salud.fpgc.model.MensajeDTO)
     */
    @Override
    public int guardarMensaje(MensajeDTO dto) {
        int update = 0;
        try {
            final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("INSERT INTO c_mensaje ");
            sqlBuilder.append("( ");
            sqlBuilder.append("  CL_MENSAJE, ");
            sqlBuilder.append("  DS_MENSAJE, ");
            sqlBuilder.append("  FG_SEVERIDAD, ");
            sqlBuilder.append("  FG_TIPO, ");
            sqlBuilder.append("  FG_ADMIN, ");
            sqlBuilder.append("  DS_TITULO, ");
            sqlBuilder.append("  TR_TITULO, ");
            sqlBuilder.append("  TR_MENSAJE ");
            sqlBuilder.append(" ) VALUES ( ");
            sqlBuilder.append("  :CL_MENSAJE, ");
            sqlBuilder.append("  :DS_MENSAJE, ");
            sqlBuilder.append("  :FG_SEVERIDAD, ");
            sqlBuilder.append("  :FG_TIPO, ");
            sqlBuilder.append("  :FG_ADMIN, ");
            sqlBuilder.append("  :DS_TITULO, ");
            sqlBuilder.append("  :TR_TITULO, ");
            sqlBuilder.append("  :TR_MENSAJE ");
            sqlBuilder.append(") ");

            final SqlParameterSource source = new MapSqlParameterSource()
                    .addValue("CL_MENSAJE", dto.getClave())
                    .addValue("DS_MENSAJE", dto.getDescripcion())
                    .addValue("FG_SEVERIDAD", dto.getSeveridad())
                    .addValue("FG_TIPO", dto.getTipo())
                    .addValue("FG_ADMIN", dto.getAdmin())
                    .addValue("DS_TITULO", dto.getDescripcionTitulo())
                    .addValue("TR_TITULO", dto.getTraduccionTitulo())
                    .addValue("TR_MENSAJE", dto.getTraduccionMensaje());

            update = namedTemplate.update(sqlBuilder.toString(), source);

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return update;
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.persistence.dao.MensajeDAO#actualizarMensaje(gob.mx.salud.fpgc.model.MensajeDTO)
     */
    @Override
    public int actualizarMensaje(MensajeDTO dto) {
        int update = 0;

        try {
            final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("UPDATE c_mensaje ");
            sqlBuilder.append("   SET DS_MENSAJE = :DS_MENSAJE, ");
            sqlBuilder.append("       DS_TITULO = :DS_TITULO, ");
            sqlBuilder.append("       TR_MENSAJE = :TR_MENSAJE, ");
            sqlBuilder.append("       TR_TITULO = :TR_TITULO ");
            sqlBuilder.append(" WHERE CL_MENSAJE = :CL_MENSAJE ");
            final SqlParameterSource source = new MapSqlParameterSource()
                    .addValue("DS_MENSAJE", dto.getDescripcion())
                    .addValue("DS_TITULO", dto.getDescripcionTitulo())
                    .addValue("TR_MENSAJE", dto.getTraduccionMensaje())
                    .addValue("TR_TITULO", dto.getTraduccionTitulo())
                    .addValue("CL_MENSAJE", dto.getClave());

            update = namedTemplate.update(sqlBuilder.toString(), source);
        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return update;
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.persistence.dao.MensajeDAO#getMensaje(long)
     */
    @Override
    public MensajeDTO getMensaje(long idMensaje) {
        MensajeDTO dto = null;
        try {
            final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT ");
            sqlBuilder.append("    CL_MENSAJE, ");
            sqlBuilder.append("    DS_MENSAJE, ");
            sqlBuilder.append("    FG_SEVERIDAD, ");
            sqlBuilder.append("    FG_TIPO, ");
            sqlBuilder.append("    FG_ADMIN, ");
            sqlBuilder.append("    DS_TITULO, ");
            sqlBuilder.append("    TR_TITULO, ");
            sqlBuilder.append("    TR_MENSAJE ");
            sqlBuilder.append("  FROM c_mensaje ");
            sqlBuilder.append(" WHERE CL_MENSAJE = :CL_MENSAJE ");
            final SqlParameterSource source = new MapSqlParameterSource("CL_MENSAJE", idMensaje);
            dto = namedTemplate.queryForObject(sqlBuilder.toString(), source, new MensajeDTOMapper());
        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
            dto = new MensajeDTO();
        }
        return dto;
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.persistence.dao.MensajeDAO#eliminarMensaje(long)
     */
    @Override
    public int eliminarMensaje(long idMensaje) {
        int update = 0;
        try {
            final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("DELETE FROM c_mensaje ");
            sqlBuilder.append(" WHERE CL_MENSAJE = :CL_MENSAJE ");
            final SqlParameterSource source = new MapSqlParameterSource("CL_MENSAJE", idMensaje);
            update = namedTemplate.update(sqlBuilder.toString(), source);
        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return update;
    }

}
