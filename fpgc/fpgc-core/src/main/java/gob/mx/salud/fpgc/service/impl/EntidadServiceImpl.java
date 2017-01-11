package gob.mx.salud.fpgc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.mx.salud.fpgc.model.EntidadDTO;
import gob.mx.salud.fpgc.persistence.dao.EntidadDAO;
import gob.mx.salud.fpgc.service.EntidadService;

/**
 * @author David Ruiz C
 *
 */
@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    private EntidadDAO entidadDAO;

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.EntidadService#getEntidades()
     */
    @Override
    public List<EntidadDTO> getEntidades() {

        return entidadDAO.getEntidades();
    }

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.EntidadService#getEntidad(long)
     */
    @Override
    public EntidadDTO getEntidad(long idEntidad) {

        return entidadDAO.getEntidad(idEntidad);
    }

}
