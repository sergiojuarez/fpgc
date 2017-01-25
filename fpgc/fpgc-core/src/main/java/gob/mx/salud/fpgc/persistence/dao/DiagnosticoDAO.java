package gob.mx.salud.fpgc.persistence.dao;

import java.util.List;

import gob.mx.salud.fpgc.model.DiagnosticoDTO;

public interface DiagnosticoDAO {

    Long guardar(DiagnosticoDTO dto);
    List<DiagnosticoDTO> getDiagnosticos(Long id);

}
