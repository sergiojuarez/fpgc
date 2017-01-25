package gob.mx.salud.fpgc.service;

import gob.mx.salud.fpgc.model.ExpedienteDTO;

public interface ExpedienteService {

    Long guardar(ExpedienteDTO dto);
    ExpedienteDTO getRegistro(ExpedienteDTO dto);

}
