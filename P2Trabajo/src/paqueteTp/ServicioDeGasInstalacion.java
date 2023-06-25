package paqueteTp;

public class ServicioDeGasInstalacion extends ServicioDeGas {

	private double saldoFijo;
	public ServicioDeGasInstalacion(String tipoDeServicio, String domicilioDeServicio, int codigoServicio,
			double cantidadDeArtefactos, double precioPorArtefactos, Especialista especialista) {
		super(tipoDeServicio, domicilioDeServicio, codigoServicio, especialista, precioPorArtefactos,
				cantidadDeArtefactos);

	}

	@Override
	public double calcularFacturacionDeServicio() {
		seRealizoServicio();
		return saldoFijo + (this.getCantidadDeArtefactos() * this.getPrecioPorArtefactos());
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
	public String verDatos() {
		return toString();
	}
	@Override
	public String toString() {
		
		return super.toString()+"saldo fijo: "+saldoFijo+" ";
	}

	@Override
	public String crearHistorial() {
		return super.crearHistorial();

	}
	

}
