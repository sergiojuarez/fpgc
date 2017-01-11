package gob.mx.salud.fpgc.service;

import java.util.List;

import gob.mx.salud.fpgc.model.EntidadDTO;

/**
 * @author David Ruiz C
 *
 */
public interface EntidadService {

    List<EntidadDTO> getEntidades();

    EntidadDTO getEntidad(long idEntidad);

}
