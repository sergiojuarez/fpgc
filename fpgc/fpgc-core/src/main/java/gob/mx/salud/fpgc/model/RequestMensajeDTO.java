package gob.mx.salud.fpgc.model;

/**
 * @author David Ruiz C
 *
 */
public class RequestMensajeDTO {

    private long idMensaje;

    public long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

    @Override
    public String toString() {
        return "RequestMensajeDTO [idMensaje=" + idMensaje + "]";
    }



}
