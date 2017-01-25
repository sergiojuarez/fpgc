package gob.mx.salud.fpgc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.mx.salud.fpgc.model.DiagnosticoDTO;
import gob.mx.salud.fpgc.persistence.dao.DiagnosticoDAO;
import gob.mx.salud.fpgc.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoDAO diagnosticoDAO;


    @Override
    public Long guardar(DiagnosticoDTO dto) {
        return diagnosticoDAO.guardar(dto);
    }
    
    @Override
    public List<DiagnosticoDTO> getDiagnosticos(Long id) {
    	return diagnosticoDAO.getDiagnosticos(id);
    }
    
}
