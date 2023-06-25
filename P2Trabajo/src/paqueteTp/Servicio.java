package paqueteTp;

import java.util.HashMap;

public abstract class Servicio {

	private String tipoDeServicio;

	private String domicilioDeServicio;
	
	private int codigoDeServicio;
	
	private Cliente clientes[];
	
	private Especialista responsable;
	
	private Especialista especialistas[];
	
	private boolean servicioFinalizado = false;

	public Servicio(String tipoDeServicio, String domicilioDeServicio, int codigoDeServicio, Especialista responsable) {
		
		this.tipoDeServicio = tipoDeServicio;
		this.domicilioDeServicio = domicilioDeServicio;
		this.codigoDeServicio = codigoDeServicio;
		this.responsable = responsable;	
	}
	
	
	public void seRealizoServicio() {
		this.servicioFinalizado = true;
		
	}
	
	public boolean estaFinalizado() {
		return this.servicioFinalizado == true;
	}
	
	public void cambiarResponsable(Especialista nuevoResponsable) {
		this.responsable = nuevoResponsable;
	}

	public boolean esElMismoServicio(int nroEspecialista) {

		return responsable.getNroEspecialista() == nroEspecialista;
	}

	public abstract double calcularFacturacionDeServicio();

	public abstract double finalizarServicio(double costosMateriales);
	
	public String crearHistorial() {
		
		StringBuilder sb = new StringBuilder();

		sb.append(" + [ ");
		sb.append(this.getCodigoDeServicio());
		sb.append(" - ");
		sb.append(this.getResponsable().getEspecialidad());
		sb.append(" ] ");
		sb.append(this.getDomicilioDeServicio());
		sb.append("\n");

		return sb.toString();
	}
	
	public String verDatos() {
		return toString();
	}

	public  String toString() {
		return "\ntipo de servicio: "+tipoDeServicio+" codigo de servicio: "+codigoDeServicio+
				" domicilio del servicio:"+domicilioDeServicio;
	}
	
	public Especialista getResponsable() {
		return responsable;
	}
	
	public String getDomicilioDeServicio() {
		return domicilioDeServicio;
	}

	public int getCodigoDeServicio() {
		return codigoDeServicio;
	}
	
	public String getTipoDeServicio() {
		return tipoDeServicio;
	}

}