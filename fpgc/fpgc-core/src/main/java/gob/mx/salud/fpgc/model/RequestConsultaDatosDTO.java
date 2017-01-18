package gob.mx.salud.fpgc.model;

/**
 * @author David Ruiz C
 *
 */
public class RequestConsultaDatosDTO {

    private ConsultaDatosDTO datosDTO;

    public RequestConsultaDatosDTO(){
        datosDTO = new ConsultaDatosDTO();
    }

    public ConsultaDatosDTO getDatosDTO() {
        return datosDTO;
    }

    public void setDatosDTO(ConsultaDatosDTO datosDTO) {
        this.datosDTO = datosDTO;
    }



}
