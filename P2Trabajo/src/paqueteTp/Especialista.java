package paqueteTp;

public class Especialista {

	private int nroEspecialista;
	private String nombre, telefono, especialidad;

	public Especialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		this.nroEspecialista = nroEspecialista;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}

	public void cambiarEspecialista(Especialista e) {

	}

	//public boolean esDeTipo(String especialidadDeServicio) {
	//	return especialidad.equals(especialidadDeServicio);
	//}

	public boolean esDeTipo(Object objeto) {
		if (objeto == null) {
			return false;
		}
		if (this == objeto) {
			return true;
		}
		if (objeto.getClass().equals(this.getClass())) {
			Especialista especialista = (Especialista) objeto;
			return (this.especialidad.equals(especialista.especialidad));
		}
		return false;
	}

	public String tipoDeEspecialidad() {
		String especialidad = "";
		return especialidad += especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNroEspecialista() {
		return nroEspecialista;
	}

	public String getEspecialidad() {
		return especialidad;
	}
	
	
	public String verDatos() {
		return toString();
	}
	
	public String toString() {
		return nroEspecialista + "\n Nombre del especialista: " + nombre + " telefono: " + telefono + " especialidad: "
				+ especialidad;
	}

}
