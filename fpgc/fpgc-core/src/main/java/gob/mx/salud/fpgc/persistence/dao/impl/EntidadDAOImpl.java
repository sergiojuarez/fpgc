package gob.mx.salud.fpgc.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import gob.mx.salud.fpgc.model.EntidadDTO;
import gob.mx.salud.fpgc.persistence.dao.EntidadDAO;
import gob.mx.salud.fpgc.persistence.mapper.EntidadDTOMapper;

/**
 * @author David Ruiz C
 *
 */
@Repository
public class EntidadDAOImpl implements EntidadDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntidadDAOImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.persistence.dao.EntidadDAO#getEntidades()
     */
    @Override
    public List<EntidadDTO> getEntidades() {
        List<EntidadDTO> entidadDTOs = null;

        try {

            final StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("SELECT CL_ENTIDAD as id, CL_CLAVE as clave, NB_ENTIDAD as nombre ");
            sqlBuilder.append("  FROM C_ENTIDAD ");

            entidadDTOs = namedTemplate.query(sqlBuilder.toString(), new EntidadDTOMapper());

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
            entidadDTOs = new ArrayList<>();
        }
        return entidadDTOs;
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.persistence.dao.EntidadDAO#getEntidad(long)
     */
    @Override
    public EntidadDTO getEntidad(long idEntidad) {

        EntidadDTO dto = null;

        try {
            final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT CL_ENTIDAD as id, CL_CLAVE as clave, NB_ENTIDAD as nombre ");
            sqlBuilder.append("  FROM C_ENTIDAD ");
            sqlBuilder.append(" WHERE cl_entidad = :id ");

            final SqlParameterSource source = new MapSqlParameterSource()
                    .addValue("id", idEntidad);


            dto = namedTemplate.queryForObject(sqlBuilder.toString(), source, new EntidadDTOMapper());

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
            dto = new EntidadDTO();
        }

        return dto;
    }

}
