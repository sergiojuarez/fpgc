package gob.mx.salud.fpgc.service;

import java.util.List;

import gob.mx.salud.fpgc.model.DiagnosticoDTO;

public interface DiagnosticoService {

    Long guardar(DiagnosticoDTO dto);
    List<DiagnosticoDTO> getDiagnosticos(Long id);

}
