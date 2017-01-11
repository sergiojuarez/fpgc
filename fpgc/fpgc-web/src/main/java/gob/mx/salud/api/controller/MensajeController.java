package gob.mx.salud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.salud.api.util.ResponseWrapper;
import gob.mx.salud.fpgc.model.MensajeDTO;
import gob.mx.salud.fpgc.model.RequestMensajeDTO;
import gob.mx.salud.fpgc.service.MensajeService;

/**
 * @author David Ruiz C
 *
 */
@RestController
@RequestMapping("/mensaje")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<Integer> guardarMensaje(@RequestBody MensajeDTO dto){
        ResponseWrapper<Integer> wrapper = new ResponseWrapper<>();
        wrapper.successPOST(mensajeService.guardarMensaje(dto));
        return wrapper;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<Integer> actualizarMensaje(@RequestBody MensajeDTO dto){
        ResponseWrapper<Integer> wrapper = new ResponseWrapper<>();
        wrapper.successPOST( mensajeService.actualizarMensaje(dto));
        return wrapper;
    }

    @RequestMapping(value = "/consultar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<MensajeDTO> getMensaje(@RequestBody RequestMensajeDTO request){
        ResponseWrapper<MensajeDTO> wrapper = new ResponseWrapper<>();
        wrapper.successPOST( mensajeService.getMensaje(request.getIdMensaje()));
        return wrapper;
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody ResponseWrapper<Integer> eliminarMensaje(@RequestBody RequestMensajeDTO request){
        ResponseWrapper<Integer> wrapper = new ResponseWrapper<>();
        wrapper.successPOST( mensajeService.eliminarMensaje(request.getIdMensaje()));
        return wrapper;
    }


}
