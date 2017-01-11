package gob.mx.salud.fpgc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.mx.salud.fpgc.model.MensajeDTO;
import gob.mx.salud.fpgc.persistence.dao.MensajeDAO;
import gob.mx.salud.fpgc.service.MensajeService;

/**
 * @author David Ruiz C
 *
 */
@Service
public class MensajeServiceImpl implements MensajeService {

    @Autowired
    private MensajeDAO mensajeDAO;

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.MensajeService#guardarMensaje(gob.mx.salud.fpgc.model.MensajeDTO)
     */
    @Override
    public int guardarMensaje(MensajeDTO dto) {

        return mensajeDAO.guardarMensaje(dto);
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.MensajeService#actualizarMensaje(gob.mx.salud.fpgc.model.MensajeDTO)
     */
    @Override
    public int actualizarMensaje(MensajeDTO dto) {

        return mensajeDAO.actualizarMensaje(dto);
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.MensajeService#getMensaje(long)
     */
    @Override
    public MensajeDTO getMensaje(long idMensaje) {

        return mensajeDAO.getMensaje(idMensaje);
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.MensajeService#eliminarMensaje(long)
     */
    @Override
    public int eliminarMensaje(long idMensaje) {

        return mensajeDAO.eliminarMensaje(idMensaje);
    }

}
