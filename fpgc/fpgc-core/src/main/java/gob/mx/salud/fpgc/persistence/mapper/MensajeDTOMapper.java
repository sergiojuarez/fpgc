package gob.mx.salud.fpgc.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gob.mx.salud.fpgc.model.MensajeDTO;

/**
 * @author David Ruiz C
 *
 */
public class MensajeDTOMapper implements RowMapper<MensajeDTO> {

    /* (non-Javadoc)
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public MensajeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final MensajeDTO dto = new MensajeDTO();
        dto.setAdmin( rs.getString("FG_ADMIN"));
        dto.setClave(rs.getLong("CL_MENSAJE"));
        dto.setDescripcion(rs.getString("DS_MENSAJE"));
        dto.setDescripcionTitulo(rs.getString("DS_TITULO"));
        dto.setSeveridad( rs.getString("FG_SEVERIDAD"));
        dto.setTipo(rs.getString("FG_TIPO"));
        dto.setTraduccionMensaje(rs.getString("TR_MENSAJE"));
        dto.setTraduccionTitulo(rs.getString("TR_TITULO"));

        return dto;
    }

}
