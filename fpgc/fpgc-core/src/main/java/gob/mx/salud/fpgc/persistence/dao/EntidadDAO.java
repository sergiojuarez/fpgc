package gob.mx.salud.fpgc.persistence.dao;

import java.util.List;

import gob.mx.salud.fpgc.model.EntidadDTO;

/**
 * @author David Ruiz C
 *
 */
public interface EntidadDAO {

    List<EntidadDTO> getEntidades();

    EntidadDTO getEntidad(long idEntidad);



}
