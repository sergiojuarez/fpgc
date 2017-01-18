package gob.mx.salud.fpgc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.mx.salud.fpgc.model.ConsultaDatosDTO;
import gob.mx.salud.fpgc.model.RequestConsultaDatosDTO;
import gob.mx.salud.fpgc.service.ConsultaDatosService;
import mx.gob.cnpss_dgao.WspSoap;

/**
 * @author David Ruiz C
 *
 */
@Service
public class ConsultaDatosServiceImpl implements ConsultaDatosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaDatosServiceImpl.class);

    @Autowired
    private WspSoap wspSoap;

    /* (non-Javadoc)
     * @see gob.mx.salud.fpgc.service.ConsultaDatosService#consultarDatos()
     */
    @Override
    public String consultarDatos(RequestConsultaDatosDTO request) {


        final ConsultaDatosDTO dto = request.getDatosDTO();

        LOGGER.debug("request : {}", dto);

        String consultaDatos = wspSoap.consultaDatos(
                dto.getFolio(),
                dto.getCurp(),
                dto.getNombre(),
                dto.getaPaterno(),
                dto.getaMaterno(),
                dto.getFechaNacimiento(),
                dto.getLugarNacimiento(),
                dto.getUsuario());

        LOGGER.debug("response : {}", consultaDatos);

        return consultaDatos;

    }

}
