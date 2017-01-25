package gob.mx.salud.fpgc.persistence.dao;

import gob.mx.salud.fpgc.model.ExpedienteDTO;

public interface ExpedienteDAO {

    long guardar(ExpedienteDTO dto);
    ExpedienteDTO getRegistro(ExpedienteDTO dto);

}
