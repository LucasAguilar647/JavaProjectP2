package paqueteTp;

public class ServicioDeGasRevision extends ServicioDeGas {

	private double saldoFijo;
	public ServicioDeGasRevision(String tipoDeServicio, String domicilioDeServicio, int codigoServicio,
			double cantidadDeArtefactos, double precioPorArtefactos, Especialista especialista) {
		super(tipoDeServicio, domicilioDeServicio, codigoServicio, especialista, precioPorArtefactos,
				cantidadDeArtefactos);

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
		if (this.getCantidadDeArtefactos() > 5) {

			return saldoFijo - (saldoFijo * 0.1) + (this.getPrecioPorArtefactos());
		}
		if (this.getCantidadDeArtefactos() > 10) {

			return saldoFijo - (saldoFijo * 0.15) + (this.getPrecioPorArtefactos());

		}

		return saldoFijo + (this.getPrecioPorArtefactos());
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
		
		return super.toString()+" saldo fijo revision del gas: "+saldoFijo;
	}
	 
}