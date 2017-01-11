package gob.mx.salud.fpgc.model;

/**
 * @author David Ruiz C
 *
 */
public class MensajeDTO {

    private long clave;
    private String descripcion;
    private String severidad;
    private String tipo;
    private String admin;
    private String descripcionTitulo;
    private String traduccionTitulo;
    private String traduccionMensaje;

    public long getClave() {
        return clave;
    }
    public void setClave(long clave) {
        this.clave = clave;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getSeveridad() {
        return severidad;
    }
    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getAdmin() {
        return admin;
    }
    public void setAdmin(String admin) {
        this.admin = admin;
    }
    public String getDescripcionTitulo() {
        return descripcionTitulo;
    }
    public void setDescripcionTitulo(String descripcionTitulo) {
        this.descripcionTitulo = descripcionTitulo;
    }
    public String getTraduccionTitulo() {
        return traduccionTitulo;
    }
    public void setTraduccionTitulo(String traduccionTitulo) {
        this.traduccionTitulo = traduccionTitulo;
    }
    public String getTraduccionMensaje() {
        return traduccionMensaje;
    }
    public void setTraduccionMensaje(String traduccionMensaje) {
        this.traduccionMensaje = traduccionMensaje;
    }
    @Override
    public String toString() {
        return "MensajeDTO [clave=" + clave + ", descripcion=" + descripcion + ", severidad=" + severidad + ", tipo="
                + tipo + ", admin=" + admin + ", descripcionTitulo=" + descripcionTitulo + ", traduccionTitulo="
                + traduccionTitulo + ", traduccionMensaje=" + traduccionMensaje + "]";
    }



}
