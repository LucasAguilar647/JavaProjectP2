package paqueteTp;

public abstract class ServicioDeGas extends Servicio {

	private double cantidadDeArtefactos;
	private double precioPorArtefactos;

	public ServicioDeGas(String tipoDeServicio, String domicilioDeServicio, int codigoDeServicio,
			Especialista responsable, double cantidadDeArtefactos, double precioPorArtefactos) {
		super(tipoDeServicio, domicilioDeServicio, codigoDeServicio, responsable);
		this.cantidadDeArtefactos = cantidadDeArtefactos;
		this.precioPorArtefactos = precioPorArtefactos;
		
		if (cantidadDeArtefactos <= 0 || precioPorArtefactos <= 0)
			throw new RuntimeException("Los valores son invalidos");
	
	}

	@Override
	public void cambiarResponsable(Especialista nuevoResponsable) {
		super.cambiarResponsable(nuevoResponsable);
	}
	
	@Override
	public abstract double calcularFacturacionDeServicio();

	@Override
	public abstract double finalizarServicio(double costosMateriales);

	@Override
	public String crearHistorial() {
		return super.crearHistorial();

	}
	
	@Override
	public String verDatos() {
		return toString();
	}
	@Override
	
	public String toString() {
		return super.toString()+" cantidad de artefactos: "+cantidadDeArtefactos+" precio por artefactos: "+precioPorArtefactos;
	}

	public double getCantidadDeArtefactos() {
		return cantidadDeArtefactos;
	}

	public double getPrecioPorArtefactos() {
		return precioPorArtefactos;
	}

}