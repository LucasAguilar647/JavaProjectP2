package paqueteTp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmpresaDeServicios {

	private HashMap<Integer, Cliente> registroDeClientes;
	private HashMap<Integer, Especialista> registroDeEspecialistas;
	private HashMap<Integer, Servicio> registroDeServicios;
	private static int contadorCodigo = 0;
	private final String[] tipoDeServicios = { "Pintura", "PinturaEnAltura", "Electricidad", "GasistaInstalacion",
			"GasistaRevision" };

	private HashMap<String, Double> registrosDeMontosPorTipo;

	public EmpresaDeServicios() {
		registroDeClientes = new HashMap<Integer, Cliente>();
		registroDeEspecialistas = new HashMap<Integer, Especialista>();
		registroDeServicios = new HashMap<Integer, Servicio>();
		registrosDeMontosPorTipo = new HashMap<String, Double>();

		for (String tipoServicio : tipoDeServicios) {
			registrosDeMontosPorTipo.put(tipoServicio, 0.0);
		}
	}

	/**
	 * Registra un nuevo cliente en el sistema dado su: - dni, - nombre y - teléfono
	 * de contacto.
	 *
	 * Si el dni ya está en el sistema se debe generar una excepción.
	 **/

	public void registrarCliente(int dni, String nombre, String telefono) {
		registrarNuevoCliente(dni, nombre, telefono);
	}

	/**
	 * Registra un nuevo especialista en el sistema dados su: - nroEspecialista, -
	 * nombre, - teléfono y - tipo De servicio en el que se especializa.
	 *
	 * Si el nroEspecialista ya está registrado en el sistema se debe generar una
	 * excepción.
	 */
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		registrarNuevoEspecialista(nroEspecialista, nombre, telefono, especialidad);
	}

	/**
	 * Se registra la prestación de un servicio de tipo Electricidad en el sistema
	 * ingresando los datos necesarios para solicitar un servicio y además: - precio
	 * por hora de trabajo del especialista - cantidad de horas estimadas que
	 * llevará realizar el trabajo.
	 * 
	 * Se devuelve el código único del servicio a realizar.
	 *
	 * Si el dni o el nroEspecialista no están registrados en el sistema se debe
	 * generar una excepción. Si el especialista no se especializa en este tipo de
	 * servicio se debe generar una excepción. Si el precio por hora o las horas de
	 * trabajo estimado son menores o iguales a 0, se debe generar una excepción.
	 */

	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora,
			int horasTrabajadas) {

		return solicitarNuevoServicioDeElectricidad(dni, nroEspecialista, direccion, precioPorHora, horasTrabajadas);
	}

	/**
	 * Se registra la prestación de un servicio de tipo Pintura en el sistema
	 * ingresando los datos necesarios para solicitar un servicio y además: - precio
	 * por pintar un metro cuadrado - cantidad de metros cuadrados a pintar.
	 * 
	 * Se devuelve el código único del servicio a realizar.
	 *
	 * Si el dni o el nroEspecialista no están registrados en el sistema se debe
	 * generar una excepción. Si el especialista no se especializa en este tipo de
	 * servicio se debe generar una excepción. Si el precio por metro cuadrado o los
	 * metros cuadrados son menores o iguales a 0, se debe generar una excepción. 5
	 * de 7
	 */
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado) {
		return solicitarNuevoServicioDePintura(dni, nroEspecialista, direccion, metrosCuadrados,
				precioPorMetroCuadrado);
	}

	/**
	 * Se registra la prestación de un servicio de tipo PinturaEnAltura en el
	 * sistema ingresando los datos necesarios para solicitar un servicio y además:
	 * - precio por pintar un metro cuadrado - cantidad de metros cuadrados a pintar
	 * - nro de piso en el que se realizará el trabajo. - costo del seguro - costo
	 * del alquiler de los andamios.
	 * 
	 * Se devuelve el código único del servicio a realizar.
	 *
	 * Si el dni o el nroEspecialista no están registrados en el sistema se debe
	 * generar una excepción. Si el especialista no se especializa en este tipo de
	 * servicio se debe generar una excepción. Si el precio por metro cuadrado o los
	 * metros cuadrados o el piso o el costo del seguro o el costo del alquiler de
	 * los andamios son menores o iguales a 0, se debe generar una excepción.
	 */
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {

		return solicitarNuevoServicioPinturaEnAltura(dni, nroEspecialista, direccion, metrosCuadrados,
				precioPorMetroCuadrado, piso, seguro, alqAndamios);

	}

	/**
	 * Se registra la prestación de un servicio de tipo GasistaInstalacion en el
	 * sistema ingresando los datos necesarios para solicitar un servicio y además:
	 * - cantidad de artefactos a instalar - precio por la instalación de un
	 * artefacto.
	 * 
	 * Se devuelve el código único del servicio a realizar.
	 *
	 * Si el dni o el nroEspecialista no están registrados en el sistema se debe
	 * generar una excepción. Si el especialista no se especializa en este tipo de
	 * servicio se debe generar una excepción. Si el precio de instalación o la
	 * cantidad de artefactos a instalar son menores o iguales a 0, se debe generar
	 * una excepción.
	 */
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		return solicitarNuevoServicioDeGasInstalacion(dni, nroEspecialista, direccion, cantArtefactos,
				precioPorArtefacto);

	}

	/**
	 * Se registra la prestación de un servicio de tipo GasistaRevison en el sistema
	 * ingresando los datos necesarios para solicitar un servicio y además: -
	 * cantidad de artefactos a revisar - precio por la revisión de un artefacto.
	 * 
	 * Se devuelve el código único del servicio a realizar.
	 *
	 * Si el dni o el nroEspecialista no están registrados en el sistema se debe
	 * generar una excepción.
	 * 
	 * Si el especialista no se especializa en este tipo de servicio se debe generar
	 * una excepción.
	 * 
	 * Si el precio de instalación o la cantidad de artefactos a revisar son menores
	 * o iguales a 0, se debe generar una excepción. *
	 * 
	 */
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		return solicitarNuevoServicioDeGasRevision(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
	}

	/**
	 * Se registra que el servicio solicitado ya fué concluido. Para esto se debe
	 * ingresar el costo de los materiales utilizados para poder realizar el
	 * trabajo.
	 *
	 * Se devuelve el precio que se debe facturar al cliente. Este precio se obtiene
	 * sumando el costo de los materiales con el costo del servicio realizado. Cada
	 * tipo de servicio tiene su forma de calcular el costo del trabajo.
	 * 
	 * Si el código de servicio no está en el sistema o el mismo ya fué finalizado,
	 * se debe generar una excepción.
	 *
	 * Se debe realizar esta operación en O(1).
	 */
	public double finalizarServicio(int codServicio, double costoMateriales) {

		return seFinalizaServicio(codServicio, costoMateriales);
	}

	/**
	 * Devuelve un diccionario cuya clave es el tipo de servicio y el valor es la
	 * cantidad de servicios realizados de ese tipo. Si un tipo de servicio no tuvo
	 * ninguna demanda, el valor de esa entrada debe ser 0.
	 */
	public Map<String, Integer> cantidadDeServiciosRealizadosPorTipo() {
		return cantidadPorTipo();
	}

	/**
	 * Devuelve la suma del precio facturado de todos los servicios finalizados que
	 * son del tipo pasado por parámetro. Si el tipo de servicio es invalido, debe
	 * generar una excepción.
	 *
	 * Se debe realizar esta operación en O(1).
	 */
	public double facturacionTotalPorTipo(String tipoServicio) {
		return facturacionTotalDelServicio(tipoServicio);
	}

	/**
	 * Devuelve la suma del precio facturado de todos los servicios finalizados que
	 * realizó la empresa.
	 */
	public double facturacionTotal() {
		return calcularFacturacion();
	}

	/**
	 * Debe cambiar el especialista responsable del servicio.
	 * 
	 * Si código de Servicio o el nroEspecialista no están registrados en el sistema
	 * se debe generar una excepción.
	 * 
	 * Si el especialista no se especializa en este tipo de servicio se debe generar
	 * una excepción.
	 *
	 *
	 * Se debe realizar esta operación en O(1).
	 */
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		cambiarDeResponsable(codServicio, nroEspecialista);
	}

	/**
	 * Devuelve un String con forma de listado donde cada renglón representa un
	 * servicio realizado. Cada renglón debe respetar el siguiente formato: " + [
	 * codServicio - GasistaInstalacion ] Dirección" por ejemplo: " + [ 1492 -
	 * GasistaInstalacion ] uan María Gutiérrez 1150"
	 * 
	 * Si el nroEspecialista no está registrado en el sistema, se debe generar una
	 * excepción.
	 * 
	 * Si el especialista no ha realizado ningún servicio hasta el momento, se debe
	 * devolver un String vacío.
	 */
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		return listadoDeServiciosPorEspecialista(nroEspecialista);
	}

	public String verDatos() {
		return mostrarDatos();
	}

	private void registrarNuevoCliente(int dni, String nombre, String telefono) {
		clienteEstaRegistrado(dni);

		registroDeClientes.put(dni, new Cliente(dni, nombre, telefono));
	}

	private void registrarNuevoEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		especialidadInvalidaOespecialistaRegistrado(nroEspecialista, especialidad);

		registroDeEspecialistas.put(nroEspecialista, new Especialista(nroEspecialista, nombre, telefono, especialidad));

	}

	private int solicitarNuevoServicioDeElectricidad(int dni, int nroEspecialista, String direccion,
			double precioPorHora, int horasTrabajadas) {
		estanRegistradosOesSuEspecialidad(dni, nroEspecialista, "Electricidad");

		contadorCodigo++;

		registroDeServicios.put(contadorCodigo, new ServicioDeElectricidad("Electricidad", direccion, contadorCodigo,
				horasTrabajadas, precioPorHora, registroDeEspecialistas.get(nroEspecialista)));

		return contadorCodigo;
	}

	private int solicitarNuevoServicioDePintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado) {
		estanRegistradosOesSuEspecialidad(dni, nroEspecialista, "Pintura");

		contadorCodigo++;

		registroDeServicios.put(contadorCodigo, new ServicioDePintura("Pintura", direccion, contadorCodigo,
				metrosCuadrados, precioPorMetroCuadrado, registroDeEspecialistas.get(nroEspecialista)));

		return contadorCodigo;
	}

	private int solicitarNuevoServicioPinturaEnAltura(int dni, int nroEspecialista, String direccion,
			int metrosCuadrados, double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {
		estanRegistradosOesSuEspecialidad(dni, nroEspecialista, "PinturaEnAltura");

		contadorCodigo++;

		registroDeServicios.put(contadorCodigo,
				new ServicioDePinturaEnAltura("PinturaEnAltura", direccion, contadorCodigo, metrosCuadrados,
						precioPorMetroCuadrado, seguro, alqAndamios, registroDeEspecialistas.get(nroEspecialista)));

		return contadorCodigo;
	}

	private int solicitarNuevoServicioDeGasInstalacion(int dni, int nroEspecialista, String direccion,
			int cantArtefactos, double precioPorArtefacto) {
		estanRegistradosOesSuEspecialidad(dni, nroEspecialista, "GasistaInstalacion");

		contadorCodigo++;

		registroDeServicios.put(contadorCodigo, new ServicioDeGasInstalacion("GasistaInstalacion", direccion,
				contadorCodigo, cantArtefactos, precioPorArtefacto, registroDeEspecialistas.get(nroEspecialista)));

		return contadorCodigo;
	}

	private int solicitarNuevoServicioDeGasRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {
		estanRegistradosOesSuEspecialidad(dni, nroEspecialista, "GasistaRevision");

		contadorCodigo++;

		registroDeServicios.put(contadorCodigo, new ServicioDeGasRevision("GasistaRevision", direccion, contadorCodigo,
				cantArtefactos, precioPorArtefacto, registroDeEspecialistas.get(nroEspecialista)));

		return contadorCodigo;
	}

	private double seFinalizaServicio(int codServicio, double costoMateriales) {
		noEstaEnSistema(codServicio);

		Servicio servicioFinalizado = registroDeServicios.get(codServicio);

		double monto = servicioFinalizado.finalizarServicio(costoMateriales);

		double actualizarMonto = registrosDeMontosPorTipo.get(servicioFinalizado.getTipoDeServicio()) + monto;

		registrosDeMontosPorTipo.put(servicioFinalizado.getTipoDeServicio(), actualizarMonto);

		return monto;
	}

	private Map<String, Integer> cantidadPorTipo() {
		Map<String, Integer> cantidadRealizadaPorTipo = new HashMap<>();

		List<String> lista = Arrays.asList(tipoDeServicios);
		Iterator<String> iterator = lista.iterator();

		while (iterator.hasNext()) 
			cantidadRealizadaPorTipo.put(iterator.next(), 0);

		for (Servicio servicio : registroDeServicios.values()) {
			if (servicio.estaFinalizado())
				cantidadRealizadaPorTipo.put(servicio.getTipoDeServicio(),
						cantidadRealizadaPorTipo.getOrDefault(servicio.getTipoDeServicio(), 0) + 1);
		}
		return cantidadRealizadaPorTipo;
	}

	private String historialDeServiciosPorEspecialista(int nroEspecialista) {

		StringBuilder historial = new StringBuilder();
		for (Servicio servicio : registroDeServicios.values()) {
			if (servicio.esElMismoServicio(nroEspecialista)) {
				historial.append(servicio.crearHistorial());
			}
		}
		return historial.toString();
	}

	private double facturacionTotalDelServicio(String tipoServicio) {
		return registrosDeMontosPorTipo.get(tipoServicio);
	}

	private double calcularFacturacion() {
		return registrosDeMontosPorTipo.values().stream().mapToInt(Double::intValue).sum();
	}

	private void cambiarDeResponsable(int codServicio, int nroEspecialista) {
		noEstaEnSistema(codServicio);

		especialistaNoEstaRegistrado(nroEspecialista);

		esSuServicio(nroEspecialista, codServicio);

		if (registroDeEspecialistas.get(nroEspecialista)
				.esDeTipo(registroDeServicios.get(codServicio).getTipoDeServicio())) {
			throw new RuntimeException("El especialista no se especializa en este tipo de servicio.");
		}

		registroDeServicios.get(codServicio).cambiarResponsable(registroDeEspecialistas.get(nroEspecialista));
	}

	private String listadoDeServiciosPorEspecialista(int nroEspecialista) {
		especialistaNoEstaRegistrado(nroEspecialista);

		if (!haRealizadoServicio(nroEspecialista))
			return "";

		return historialDeServiciosPorEspecialista(nroEspecialista);
	}

	private String mostrarDatos() {
		StringBuilder mostrarDatos = new StringBuilder();

		for (Servicio servicio : registroDeServicios.values())
			mostrarDatos.append(servicio.verDatos());

		for (Especialista especialista : registroDeEspecialistas.values())
			mostrarDatos.append(especialista.verDatos());

		for (Cliente cliente : registroDeClientes.values())
			mostrarDatos.append(cliente.verDatos());

		return mostrarDatos.toString();
	}

	private boolean haRealizadoServicio(int nroEspecialista) {
		for (Servicio servicio : registroDeServicios.values()) {
			if (servicio.esElMismoServicio(nroEspecialista) && servicio.estaFinalizado())
				return true;
		}
		return false;
	}

	private void esSuServicio(int nroEspecialista, int codServicio) {
		String especialidad = registroDeEspecialistas.get(nroEspecialista).getEspecialidad();
		String servicio = registroDeServicios.get(codServicio).getTipoDeServicio();
		if (!especialidad.equals(servicio))
			throw new RuntimeException("El especialista no se especializa en este servicio");
	}

	private void clienteEstaRegistrado(int dni) {
		if (registroDeClientes.containsKey(dni))
			throw new RuntimeException("El cliente ya esta registrado");
	}

	private void especialistaNoEstaRegistrado(int nroEspecialista) {
		if (!registroDeEspecialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El Especialista no está registrado");
	}

	private void estanRegistradosOesSuEspecialidad(int dni, int nroEspecialista, String especialidad) {
		if (!this.registroDeClientes.containsKey(dni) || !this.registroDeEspecialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El DNI o el especialista no estan registrados");

		Especialista especialista = registroDeEspecialistas.get(nroEspecialista);
		if (!especialista.getEspecialidad().equals(especialidad))
			throw new RuntimeException("Este especialista no se especializa en este servicio");
	}

	private void especialidadInvalidaOespecialistaRegistrado(int nroEspecialista, String especialidad) {
		boolean pertenece = false;
		for (String e : this.tipoDeServicios)
			pertenece = pertenece || e.equals(especialidad);

		if (!pertenece)
			throw new RuntimeException("Especialista desconocido");

		if (registroDeEspecialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El Especialista ya está registrado");
	}

	private void noEstaEnSistema(int codServicio) {
		if (!registroDeServicios.containsKey(codServicio) || registroDeServicios.get(codServicio).estaFinalizado())
			throw new RuntimeException("El servicio no esta registrado");
	}

}
