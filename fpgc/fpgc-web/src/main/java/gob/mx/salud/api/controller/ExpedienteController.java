package gob.mx.salud.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.salud.api.util.ResponseWrapper;
import gob.mx.salud.fpgc.model.DiagnosticoDTO;
import gob.mx.salud.fpgc.model.ExpedienteDTO;
import gob.mx.salud.fpgc.model.request.RequestDiagnostico;
import gob.mx.salud.fpgc.model.request.RequestExpediente;
import gob.mx.salud.fpgc.model.request.RequestExpedienteCompleto;
import gob.mx.salud.fpgc.service.DiagnosticoService;
import gob.mx.salud.fpgc.service.ExpedienteService;

@RestController
@RequestMapping("/expediente")
public class ExpedienteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpedienteController.class);
	
	@Autowired
	private Mapper mapper;
	
    @Autowired
    private ExpedienteService expedienteService;
    
    @Autowired
    private DiagnosticoService diagnosticoService;    

    /*
     * Al almacenar el expediente, es necesario guardar el diagnostico y las atenciones correspondientes.
     */
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<RequestExpedienteCompleto> guardar(@RequestBody RequestExpedienteCompleto dto) {
    	ResponseWrapper<RequestExpedienteCompleto> wrapper = new ResponseWrapper<>();
        
       LOGGER.debug("Entrada completa: " + dto.toString());        
        
        RequestExpediente reqExpediente = dto.getExpediente();
        
        LOGGER.debug("Entrada: " + reqExpediente.toString());   
       
        ExpedienteDTO expediente = mapper.map(reqExpediente, ExpedienteDTO.class);

        LOGGER.debug("Conversion: " + expediente.toString());
       
        Long idExpedienteInsert = expedienteService.guardar(expediente);
        LOGGER.debug("idExpedienteInsert: " + idExpedienteInsert);
        
        Long idInsert = null;        
        
        if (idExpedienteInsert > 0) {        	  
        	LOGGER.debug("Diagnosticos: " + dto.getDiagnostico().toString());
        	Map<String, RequestDiagnostico> diagnosticos = dto.getDiagnostico();
        	
        	 for (Entry<String, RequestDiagnostico> reqDiagnostico: diagnosticos.entrySet()) {
				LOGGER.debug("reqDiagnostico: " + reqDiagnostico.toString());
				DiagnosticoDTO diagnostico = mapper.map(reqDiagnostico.getValue(), DiagnosticoDTO.class);
			    diagnostico.setFlExpediente(idExpedienteInsert);
			    idInsert = diagnosticoService.guardar(diagnostico);
        	 }        	
        }
        
        
        wrapper.successPOST(getExpedientePorFolio(idExpedienteInsert));
        return wrapper;
    }    
    
    
    @RequestMapping(value = "/consultarPorFolio/{pr1}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody ResponseWrapper<RequestExpedienteCompleto> getPorFolio(@PathVariable Long pr1) {
        ResponseWrapper<RequestExpedienteCompleto> wrapper = new ResponseWrapper<>();
        
        RequestExpedienteCompleto expedienteCompleto = getExpedientePorFolio(pr1);
                  
        wrapper.successPOST(expedienteCompleto);
        
        return wrapper;
    }    
    

    private RequestExpedienteCompleto getExpedientePorFolio(Long pr1) {
    	
        ExpedienteDTO expediente = new ExpedienteDTO();
        expediente.setFlExpediente(pr1);
        
        ExpedienteDTO resultado = expedienteService.getRegistro(expediente);
        LOGGER.debug("Resultado: " + resultado.toString());
        
        RequestExpediente reqExpediente = mapper.map(resultado, RequestExpediente.class);

        LOGGER.debug("Conversion: " + reqExpediente.toString());
        
                        	  
        List<DiagnosticoDTO> diagnosticos = diagnosticoService.getDiagnosticos(pr1);
        
        Map<String, RequestDiagnostico> requestDiagnosticos = new HashMap<String, RequestDiagnostico>();
        
        for (DiagnosticoDTO diagnostico : diagnosticos) {        	  
			RequestDiagnostico reqDiagnostico = mapper.map(diagnostico, RequestDiagnostico.class);    		
			requestDiagnosticos.put(diagnostico.getAtributo1(), reqDiagnostico);			
    	}
        
        RequestExpedienteCompleto expedienteCompleto = new RequestExpedienteCompleto();
        expedienteCompleto.setExpediente(reqExpediente);
        expedienteCompleto.setDiagnostico(requestDiagnosticos);   
        
        return expedienteCompleto;    	
    }
    
    
    @RequestMapping(value = "/consultar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<ExpedienteDTO> consultar(@RequestBody Map<String, Object> dto) {
        ResponseWrapper<ExpedienteDTO> wrapper = new ResponseWrapper<>();
        
       LOGGER.debug("Entrada completa: " + dto.toString());        
        
        ExpedienteDTO reqExpediente = new ExpedienteDTO();
        reqExpediente.setFlExpediente((Long)dto.get("fl_expediente"));
       
        ExpedienteDTO expediente = expedienteService.getRegistro(reqExpediente);
        
        wrapper.successPOST(expediente);
        
        return wrapper;
    }        
    
    
    
    @RequestMapping(value = "/guardarRegistro", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<Long> guardarRegistro(@RequestBody ExpedienteDTO dto) {
        ResponseWrapper<Long> wrapper = new ResponseWrapper<>();
        LOGGER.debug("Controller: " + dto.toString());
        wrapper.successPOST(expedienteService.guardar(dto));
        return wrapper;
    }

    
}
