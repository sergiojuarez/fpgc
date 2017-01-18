package gob.mx.salud.fpgc.service;

import gob.mx.salud.fpgc.model.RequestConsultaDatosDTO;

/**
 * @author David Ruiz C
 *
 */
public interface ConsultaDatosService {

    String consultarDatos(RequestConsultaDatosDTO request);

}
