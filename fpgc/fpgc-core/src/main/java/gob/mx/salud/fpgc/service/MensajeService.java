package gob.mx.salud.fpgc.service;

import gob.mx.salud.fpgc.model.MensajeDTO;

/**
 * @author David Ruiz C
 *
 */
public interface MensajeService {


    int guardarMensaje(MensajeDTO dto);

    int actualizarMensaje(MensajeDTO dto);

    MensajeDTO getMensaje(long idMensaje);

    int eliminarMensaje(long idMensaje);
}
