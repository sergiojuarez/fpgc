package gob.mx.salud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.salud.api.util.ResponseWrapper;
import gob.mx.salud.fpgc.model.EntidadDTO;
import gob.mx.salud.fpgc.model.RequestEntidadDTO;
import gob.mx.salud.fpgc.service.EntidadService;

/**
 * @author David Ruiz C
 *
 */
@RestController
@RequestMapping("/entidad")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @RequestMapping(value = "/catalogo", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<List<EntidadDTO>> getEntidades(){
        final ResponseWrapper<List<EntidadDTO>> wrapper = new ResponseWrapper<>();
        wrapper.successPOST(entidadService.getEntidades());
        return wrapper;
    }

    @RequestMapping(value = "/consultar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<EntidadDTO> getEntidad(@RequestBody RequestEntidadDTO request){
        final ResponseWrapper<EntidadDTO> wrapper = new ResponseWrapper<>();
        wrapper.successPOST(entidadService.getEntidad(request.getIdEntidad()));
        return wrapper;
    }

}
