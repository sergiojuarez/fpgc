package gob.mx.salud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.salud.api.util.ResponseWrapper;
import gob.mx.salud.fpgc.model.RequestConsultaDatosDTO;
import gob.mx.salud.fpgc.service.ConsultaDatosService;

/**
 * @author David Ruiz C
 *
 */
@RestController
@RequestMapping("/datos")
public class ConsultaDatosController {

    @Autowired
    private ConsultaDatosService consultaDatosService;

    @RequestMapping(value = "/consulta", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<String> getEntidades(@RequestBody RequestConsultaDatosDTO request){
        final ResponseWrapper<String> wrapper = new ResponseWrapper<>();
        wrapper.successPOST(consultaDatosService.consultarDatos(request));
        return wrapper;
    }

}
