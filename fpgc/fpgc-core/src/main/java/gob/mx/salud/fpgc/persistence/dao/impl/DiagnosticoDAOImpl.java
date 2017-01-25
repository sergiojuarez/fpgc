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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import gob.mx.salud.fpgc.model.DiagnosticoDTO;
import gob.mx.salud.fpgc.persistence.dao.DiagnosticoDAO;
import gob.mx.salud.fpgc.persistence.mapper.DiagnosticoDTOMapper;

@Repository
public class DiagnosticoDAOImpl implements DiagnosticoDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosticoDAOImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public Long guardar(DiagnosticoDTO dto) {
        int update = 0;
        
        Long id =  0L;
        
        try {
                    	
        	final StringBuilder sqlBuilder = new StringBuilder();
        	sqlBuilder.append("INSERT INTO K_DIAGNOSTICO ( ");
        	sqlBuilder.append("FL_EXPEDIENTE, FL_ETAPA, FE_DIAGNOSTICO, DS_DOC_DIAGNOSTICO, ");
        	sqlBuilder.append("ATRIBUTO1, ATRIBUTO2, ATRIBUTO3, ATRIBUTO4, ATRIBUTO5, ");
        	sqlBuilder.append("ATRIBUTO6, ATRIBUTO7, ATRIBUTO8, ATRIBUTO9, ATRIBUTO10) ");
        	sqlBuilder.append("VALUES ( ");
        	sqlBuilder.append(":FL_EXPEDIENTE, :FL_ETAPA, TO_DATE(:FE_DIAGNOSTICO,'DD-MM-YYYY'), :DS_DOC_DIAGNOSTICO, ");
        	sqlBuilder.append(":ATRIBUTO1, :ATRIBUTO2,	:ATRIBUTO3, :ATRIBUTO4, :ATRIBUTO5, ");
        	sqlBuilder.append(":ATRIBUTO6, :ATRIBUTO7, :ATRIBUTO8, :ATRIBUTO9, :ATRIBUTO10) ");
            
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
                    .addValue("FL_EXPEDIENTE", dto.getFlExpediente())
                    .addValue("FL_ETAPA", dto.getFlEtapa())
                    .addValue("FE_DIAGNOSTICO", dto.getFeDiagnostico())
                    .addValue("DS_DOC_DIAGNOSTICO", dto.getDsDocDiagnostico())
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
            update = namedTemplate.update(sqlBuilder.toString(), source, keyHolder, new String[]{"FL_DIAGNOSTICO"});
            id = keyHolder.getKey().longValue();
                 
            LOGGER.debug("Nuevo registro: " + id);
                                           

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
        
        return id;
    }
    
    
    @Override
    public List<DiagnosticoDTO> getDiagnosticos(Long id) { 
    	
        List<DiagnosticoDTO> lista = null;

        try {

            final StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("SELECT ");
            sqlBuilder.append("	FL_DIAGNOSTICO, FL_EXPEDIENTE, FL_ETAPA,  TO_CHAR(FE_DIAGNOSTICO,'DD-MM-YYYY') AS FE_DIAGNOSTICO, DS_DOC_DIAGNOSTICO, ");
            sqlBuilder.append("	ATRIBUTO1, ATRIBUTO2, ATRIBUTO3, ATRIBUTO4, ATRIBUTO5, ");
            sqlBuilder.append("	ATRIBUTO6, ATRIBUTO7, ATRIBUTO8, ATRIBUTO9, ATRIBUTO10 ");
            sqlBuilder.append("FROM k_diagnostico ");
            sqlBuilder.append("WHERE FL_EXPEDIENTE = :FL_EXPEDIENTE ");
            
            final SqlParameterSource source = new MapSqlParameterSource()
                    .addValue("FL_EXPEDIENTE", id);            

            lista = namedTemplate.query(sqlBuilder.toString(), source, new DiagnosticoDTOMapper());

        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage(), e);
            lista = new ArrayList<>();
        }
        return lista;
    }
    


}
