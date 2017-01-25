package gob.mx.salud.fpgc.persistence.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import gob.mx.salud.fpgc.model.ExpedienteDTO;
import gob.mx.salud.fpgc.persistence.dao.ExpedienteDAO;
import gob.mx.salud.fpgc.persistence.mapper.ExpedienteDTOMapper;

@Repository
public class ExpedienteDAOImpl implements ExpedienteDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpedienteDAOImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public long guardar(ExpedienteDTO dto) {
        int update = 0;
        
        long id =  0L;
        
        try {
            
        	final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("INSERT INTO K_EXPEDIENTE( ");
            sqlBuilder.append("	FL_POLIZA, FL_PATOLOGIA, FL_SUBGRUPO_DIAGNOSTICO, ");
            sqlBuilder.append("	FL_SUBDIAGNOSTICO, FL_GENOTIPO, FL_CLASIFICACION_ANA, FL_CIE, ");
            sqlBuilder.append("	FL_CLASIFICACION_MORFOLOGICA, FE_CAPTACION, DS_COMENTARIOS, ");
            sqlBuilder.append("	DS_PRIMERA_VALORACION, DS_PRIMERA_ATENCION, ");
            sqlBuilder.append("	ATRIBUTO1, ATRIBUTO2, ATRIBUTO3, ATRIBUTO4, ATRIBUTO5, ");
            sqlBuilder.append("	ATRIBUTO6, ATRIBUTO7, ATRIBUTO8, ATRIBUTO9, ATRIBUTO10) ");
            sqlBuilder.append("VALUES ( ");
            sqlBuilder.append(" :FL_POLIZA, :FL_PATOLOGIA, :FL_SUBGRUPO_DIAGNOSTICO, ");
            sqlBuilder.append("	:FL_SUBDIAGNOSTICO, :FL_GENOTIPO, :FL_CLASIFICACION_ANA, :FL_CIE, ");
            sqlBuilder.append("	:FL_CLASIFICACION_MORFOLOGICA, TO_DATE(:FE_CAPTACION,'DD-MM-YYYY'), :DS_COMENTARIOS, ");
            sqlBuilder.append("	:DS_PRIMERA_VALORACION, :DS_PRIMERA_ATENCION, ");
            sqlBuilder.append("	:ATRIBUTO1, :ATRIBUTO2, :ATRIBUTO3, :ATRIBUTO4, :ATRIBUTO5, ");
            sqlBuilder.append("	:ATRIBUTO6, :ATRIBUTO7, :ATRIBUTO8, :ATRIBUTO9, :ATRIBUTO10) ");
            
            LOGGER.debug(dto.toString());           
            
            String atr1, atr2, atr3, atr4, atr5, atr6, atr7, atr8, atr9, atr10;
                      
            atr1 = dto.getAtributo1();
            if (atr1.length() == 0)
            	atr1 = null;
            
            atr2 = dto.getAtributo2();
            if (atr2.length() == 0)
            	atr2 = null;
            
            atr3 = dto.getAtributo3();
            if (atr3.length() == 0)
            	atr3 = null;
            
            atr4 = dto.getAtributo4();
            if (atr4.length() == 0)
            	atr4 = null;
            
            atr5 = dto.getAtributo5();
            if (atr5.length() == 0)
            	atr5 = null;            
            
            atr6 = dto.getAtributo6();
            if (atr6.length() == 0)
            	atr6 = null;
            
            atr7 = dto.getAtributo7();
            if (atr7.length() == 0)
            	atr7 = null;
            
            atr8 = dto.getAtributo8();
            if (atr8.length() == 0)
            	atr8 = null;
            
            atr9 = dto.getAtributo9();
            if (atr9.length() == 0)
            	atr9 = null;
            
            atr10 = dto.getAtributo10();
            if (atr10.length() == 0)
            	atr10 = null;             
            
            final SqlParameterSource source = new MapSqlParameterSource()
                    .addValue("FL_POLIZA", dto.getFlPoliza())
                    .addValue("FL_PATOLOGIA", dto.getFlPatologia())
                    .addValue("FL_SUBGRUPO_DIAGNOSTICO", dto.getFlSubgrupoDiagnostico())
                    .addValue("FL_SUBDIAGNOSTICO", dto.getFlSubDiagnostico())
                    .addValue("FL_GENOTIPO", dto.getFlGenotipo())
                    .addValue("FL_CLASIFICACION_ANA", dto.getFlClasificacionAna())
                    .addValue("FL_CIE", dto.getFlCie())
                    .addValue("FL_CLASIFICACION_MORFOLOGICA", dto.getFlClasificacionMorfologica())
                    .addValue("FE_CAPTACION", dto.getFeCaptacion())
                    .addValue("DS_COMENTARIOS", dto.getDsComentarios())
                    .addValue("DS_PRIMERA_VALORACION", dto.getDsPrimeraValoracion())
                    .addValue("DS_PRIMERA_ATENCION", dto.getDsPrimeraAtencion())
                    .addValue("ATRIBUTO1", atr1)
                    .addValue("ATRIBUTO2", atr2)
                    .addValue("ATRIBUTO3", atr3)
                    .addValue("ATRIBUTO4", atr4)
                    .addValue("ATRIBUTO5", atr5)
                    .addValue("ATRIBUTO6", atr6)
                    .addValue("ATRIBUTO7", atr7)
                    .addValue("ATRIBUTO8", atr8)
                    .addValue("ATRIBUTO9", atr9)
                    .addValue("ATRIBUTO10", atr10);
            
            LOGGER.debug("El query: " + sqlBuilder.toString());

            KeyHolder keyHolder = new GeneratedKeyHolder();                
            update = namedTemplate.update(sqlBuilder.toString(), source, keyHolder, new String[]{"FL_EXPEDIENTE"});
            id = keyHolder.getKey().longValue();
                 
            LOGGER.debug("Nuevo registro: " + id);
                                           

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
        
        return id;
    }
    
    @Override
    public ExpedienteDTO getRegistro(ExpedienteDTO dto) { 
        	
    	ExpedienteDTO expediente = null;
        try {
            final StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("SELECT ");
            sqlBuilder.append("	FL_EXPEDIENTE, FL_POLIZA, FL_PATOLOGIA, FL_SUBGRUPO_DIAGNOSTICO, ");
            sqlBuilder.append("	FL_SUBDIAGNOSTICO, FL_GENOTIPO, FL_CLASIFICACION_ANA, ");
            sqlBuilder.append("	FL_CIE, FL_CLASIFICACION_MORFOLOGICA, TO_CHAR(FE_CAPTACION,'DD-MM-YYYY') AS FE_CAPTACION, ");
            sqlBuilder.append("	DS_COMENTARIOS, DS_PRIMERA_VALORACION, DS_PRIMERA_ATENCION, ");
            sqlBuilder.append("	ATRIBUTO1, ATRIBUTO2, ATRIBUTO3, ATRIBUTO4, ATRIBUTO5, ");
            sqlBuilder.append("	ATRIBUTO6, ATRIBUTO7, ATRIBUTO8, ATRIBUTO9, ATRIBUTO10 ");
            sqlBuilder.append("FROM k_expediente ");
            sqlBuilder.append("WHERE FL_EXPEDIENTE = :FL_EXPEDIENTE ");
            
            final SqlParameterSource source = new MapSqlParameterSource("FL_EXPEDIENTE", dto.getFlExpediente());
            expediente = namedTemplate.queryForObject(sqlBuilder.toString(), source, new ExpedienteDTOMapper());
            
            LOGGER.debug("Expediente: " + expediente.toString());
            
        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
            expediente = new ExpedienteDTO();
        }
        return expediente;    	
    }

}
