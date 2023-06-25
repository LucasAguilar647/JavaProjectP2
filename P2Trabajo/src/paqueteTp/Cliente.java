package paqueteTp;

public class Cliente {
	
	private int DNI;
	private String nombre , telefono;
	
	
	public Cliente(int dni, String nombre, String telefono) {
		
		this.DNI = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}


	public int getDni() {
		return DNI;
	}
	
	
	public String verDatos() {
		return toString();
	}

	public String toString() {
		return "\nDNI: "+DNI+" Nombre: "+nombre+" telefono: "+telefono;
	}


}
