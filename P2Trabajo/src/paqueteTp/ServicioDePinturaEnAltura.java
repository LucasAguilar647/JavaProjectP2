package paqueteTp;

public class ServicioDePinturaEnAltura extends ServicioDePintura {

	private double costoSeguro;
	private double costoPorAndamios;

	public ServicioDePinturaEnAltura(String tipoDeServicio, String domicilioDeServicio, int codigoServicio,
			int superficieApintar, double costoPorMetroCuadrado, double costoSeguro, double costoPorAndamios,
			Especialista especialista) {

		super(tipoDeServicio, domicilioDeServicio, codigoServicio, superficieApintar, costoPorMetroCuadrado,
				especialista);
		this.costoSeguro = costoSeguro;
		this.costoPorAndamios = costoPorAndamios;
		
		if ( costoSeguro <= 0 || costoPorAndamios <= 0) {
			throw new RuntimeException("Los precios son menores a 1");
		}

	}

	@Override
	public double calcularFacturacionDeServicio() {
		seRealizoServicio();
		if (this.superficieApintar > 5) {

			return super.calcularFacturacionDeServicio() + costoSeguro + costoPorAndamios + (costoPorAndamios * 0.2);
		}

		return super.calcularFacturacionDeServicio() + costoSeguro + costoPorAndamios;
	}
	@Override
	public double finalizarServicio(double costosMateriales) {
		
		return this.calcularFacturacionDeServicio();
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
		return super.toString()+" costo por andamion: "+costoPorAndamios+" costo seguro: "+costoSeguro;
		
	}
}