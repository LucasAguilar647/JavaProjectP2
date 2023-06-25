package paqueteTp;

public class ServicioDePintura extends Servicio {

	protected double superficieApintar;
	private double costoPorMetroCuadrado;

	public ServicioDePintura(String tipoDeServicio, String domicilioDeServicio, int codigoServicio,
			int superficieApintar, double costoPorMetroCuadrado, Especialista especialista) {

		super(tipoDeServicio, domicilioDeServicio, codigoServicio, especialista);
		this.superficieApintar = superficieApintar;
		this.costoPorMetroCuadrado = costoPorMetroCuadrado;
		
		if (superficieApintar <= 0 || costoPorMetroCuadrado <= 0)
			throw new RuntimeException("Los valores son invalidos");
	}

	@Override
	public double calcularFacturacionDeServicio() {
		seRealizoServicio();
		return this.superficieApintar * this.costoPorMetroCuadrado;

	}
	
	@Override
	public double finalizarServicio(double costosMateriales) {
		
		return this.calcularFacturacionDeServicio() + costosMateriales;
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
	public String verDatos() {
		return toString();
	}
	
	@Override
	public String toString() {
		
		return super.toString()+" superficie a pintar: "+superficieApintar+"costo por metro cuadrado: "+costoPorMetroCuadrado+" ";
	}

}