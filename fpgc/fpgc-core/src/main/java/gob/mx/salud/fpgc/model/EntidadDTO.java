package gob.mx.salud.fpgc.model;

/**
 * @author David Ruiz C
 *
 */
public class EntidadDTO {

    private long id;
    private String clave;
    private String nombre;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "EntidadDTO [id=" + id + ", clave=" + clave + ", nombre=" + nombre + "]";
    }

}
