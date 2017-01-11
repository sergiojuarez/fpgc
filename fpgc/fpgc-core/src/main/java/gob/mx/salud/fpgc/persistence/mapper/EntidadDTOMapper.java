package gob.mx.salud.fpgc.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gob.mx.salud.fpgc.model.EntidadDTO;

/**
 * @author David Ruiz C
 *
 */
public class EntidadDTOMapper implements RowMapper<EntidadDTO> {

    /* (non-Javadoc)
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public EntidadDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        final EntidadDTO dto = new EntidadDTO();
        dto.setClave(rs.getString("clave"));
        dto.setNombre(rs.getString("nombre"));
        dto.setId(rs.getLong("id"));
        return dto;
    }

}
