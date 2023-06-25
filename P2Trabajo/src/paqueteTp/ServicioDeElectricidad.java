package paqueteTp;

public class ServicioDeElectricidad extends Servicio {

	private double horasTrabajadas;
	private double montoPorHora;

	public ServicioDeElectricidad(String tipoDeServicio, String domicilioDeServicio, int codigoServicio,
			double horasTrabajadas, double montoPorHora, Especialista especialista) {

		super(tipoDeServicio, domicilioDeServicio, codigoServicio, especialista);
		this.horasTrabajadas = horasTrabajadas;
		this.montoPorHora = montoPorHora;
		//validacion
		if (horasTrabajadas <= 0 || horasTrabajadas <= 0)
			throw new RuntimeException("Los valores son invalidos");
	}

	@Override
	public void cambiarResponsable(Especialista nuevoResponsable) {
		super.cambiarResponsable(nuevoResponsable);
	}
	
	@Override
	public String crearHistorial() {
		return super.crearHistorial();

	}

	@Override
	public double calcularFacturacionDeServicio() {
		seRealizoServicio();
		return this.horasTrabajadas * this.montoPorHora;
	}

	@Override
	public double finalizarServicio(double costosMateriales) {
		return this.calcularFacturacionDeServicio() + costosMateriales;
	}
	
	@Override
	public String verDatos() {
		return toString();
	}
	@Override
	public String toString() {
		
		return super.toString()+" horas trabajadas: "+horasTrabajadas+" monto por hora: "+montoPorHora;
	}
	

}