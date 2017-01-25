package gob.mx.salud.fpgc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gob.mx.salud.fpgc.model.ExpedienteDTO;
import gob.mx.salud.fpgc.persistence.dao.ExpedienteDAO;
import gob.mx.salud.fpgc.service.ExpedienteService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ExpedienteServiceImpl implements ExpedienteService {

    @Autowired
    private ExpedienteDAO expedienteDAO;

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public Long guardar(ExpedienteDTO dto) {
        return expedienteDAO.guardar(dto);
    }

    @Override
    public ExpedienteDTO getRegistro(ExpedienteDTO dto) {
        return expedienteDAO.getRegistro(dto);
    }
}
