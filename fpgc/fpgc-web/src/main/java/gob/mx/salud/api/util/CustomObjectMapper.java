package gob.mx.salud.api.util;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * ObjectMapper para el formato de fechas global {@code java.uti.Date}
 *
 * @author Luis Daniel García Vieyra
 * @since 20/05/2015
 * @version 1.0.0
 */
@Component
public class CustomObjectMapper extends ObjectMapper{

    /**
     *
     */
    private static final long serialVersionUID = -4493783057741102474L;
    private static final String PATRON_FECHAS_GLOBAL = "MMM dd, yyyy hh:mm:ss a";

    public CustomObjectMapper() {
        super();
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
//        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); 
//        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        setSerializationInclusion(Include.NON_NULL);
        setDateFormat(new SimpleDateFormat(PATRON_FECHAS_GLOBAL));
    }
}
