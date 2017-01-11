package gob.mx.salud.fpgc.model;

/**
 * @author David Ruiz C
 *
 */
public class RequestEntidadDTO {

    private long idEntidad;

    public long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(long idEntidad) {
        this.idEntidad = idEntidad;
    }

    @Override
    public String toString() {
        return "RequestEntidadDTO [idEntidad=" + idEntidad + "]";
    }



}
