package gob.mx.salud.fpgc.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gob.mx.salud.fpgc.model.ExpedienteDTO;

public class ExpedienteDTOMapper implements RowMapper<ExpedienteDTO> {

    @Override
    public ExpedienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final ExpedienteDTO dto = new ExpedienteDTO();
        dto.setFlExpediente( (Long) rs.getLong("FL_EXPEDIENTE"));        
        dto.setFlPoliza( (Long) rs.getLong("FL_POLIZA"));
        dto.setFlPatologia( (Long) rs.getLong("FL_PATOLOGIA"));
        dto.setFlSubgrupoDiagnostico( (Long) rs.getLong("FL_SUBGRUPO_DIAGNOSTICO"));
        dto.setFlSubDiagnostico( (Long) rs.getLong("FL_SUBDIAGNOSTICO"));      
        dto.setFlGenotipo( (Long) rs.getLong("FL_GENOTIPO"));
        dto.setFlClasificacionAna( (Long) rs.getLong("FL_CLASIFICACION_ANA"));
        dto.setFlCie( (Long) rs.getLong("FL_CIE"));
        dto.setFlClasificacionMorfologica( (Long) rs.getLong("FL_CLASIFICACION_MORFOLOGICA"));
        dto.setFeCaptacion(rs.getString("FE_CAPTACION"));
        dto.setDsComentarios(rs.getString("DS_COMENTARIOS"));
        dto.setDsPrimeraValoracion(rs.getString("DS_PRIMERA_VALORACION"));
        dto.setDsPrimeraAtencion(rs.getString("DS_PRIMERA_ATENCION"));
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
