package gob.mx.salud.fpgc.persistence.dao;

import gob.mx.salud.fpgc.model.MensajeDTO;

/**
 * @author David Ruiz C
 *
 */
public interface MensajeDAO {

    int guardarMensaje(MensajeDTO dto);

    int actualizarMensaje(MensajeDTO dto);

    MensajeDTO getMensaje(long idMensaje);

    int eliminarMensaje(long idMensaje);

}
