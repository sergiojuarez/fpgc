package gob.mx.salud.fpgc.model.request;

import java.util.ArrayList;
import java.util.Map;

public class RequestExpedienteCompleto {

	private RequestExpediente expediente;
	private Map<String, RequestDiagnostico> diagnostico;
	
	public RequestExpediente getExpediente() {
		return expediente;
	}
	public void setExpediente(RequestExpediente expediente) {
		this.expediente = expediente;
	}
	public Map<String, RequestDiagnostico> getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Map<String, RequestDiagnostico> diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public String toString() {
		return "RequestExpedienteCompleto [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
