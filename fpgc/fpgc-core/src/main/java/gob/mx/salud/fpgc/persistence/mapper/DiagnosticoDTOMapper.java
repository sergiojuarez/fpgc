package gob.mx.salud.fpgc.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gob.mx.salud.fpgc.model.DiagnosticoDTO;

public class DiagnosticoDTOMapper implements RowMapper<DiagnosticoDTO> {

    @Override
    public DiagnosticoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final DiagnosticoDTO dto = new DiagnosticoDTO();
    
        dto.setFlDiagnostico((Long) rs.getLong("FL_DIAGNOSTICO"));
        dto.setFlExpediente((Long) rs.getLong("FL_EXPEDIENTE"));
        dto.setFlEtapa((Long) rs.getLong("FL_ETAPA"));
        dto.setFeDiagnostico(rs.getString("FE_DIAGNOSTICO"));
        dto.setDsDocDiagnostico(rs.getString("DS_DOC_DIAGNOSTICO"));
        dto.setAtributo1(rs.getString("ATRIBUTO1"));
        dto.setAtributo2(rs.getString("ATRIBUTO2"));
        dto.setAtributo3(rs.getString("ATRIBUTO3"));
        dto.setAtributo4(rs.getString("ATRIBUTO4"));
        dto.setAtributo5(rs.getString("ATRIBUTO5"));
        dto.setAtributo6(rs.getString("ATRIBUTO6"));
        dto.setAtributo7(rs.getString("ATRIBUTO7"));
        dto.setAtributo8(rs.getString("ATRIBUTO8"));
        dto.setAtributo9(rs.getString("ATRIBUTO9"));
        dto.setAtributo10(rs.getString("ATRIBUTO10"));


        return dto;
    }

}
