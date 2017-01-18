package gob.mx.salud.fpgc.model;

/**
 * @author David Ruiz C
 *
 */
public class ConsultaDatosDTO {

    private String folio;
    private String curp;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String fechaNacimiento;
    private String lugarNacimiento;
    private String usuario;

    public String getFolio() {
        return folio;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getCurp() {
        return curp;
    }
    public void setCurp(String curp) {
        this.curp = curp;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getaPaterno() {
        return aPaterno;
    }
    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }
    public String getaMaterno() {
        return aMaterno;
    }
    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getLugarNacimiento() {
        return lugarNacimiento;
    }
    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @Override
    public String toString() {
        return "ConsultaDatosDTO [folio=" + folio + ", curp=" + curp + ", nombre=" + nombre + ", aPaterno=" + aPaterno
                + ", aMaterno=" + aMaterno + ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento="
                + lugarNacimiento + ", usuario=" + usuario + "]";
    }

}
