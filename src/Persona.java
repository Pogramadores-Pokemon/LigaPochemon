
public abstract class Persona {

	private String nombre;
	private String apellidos;
	private int edad;
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApellidos() {
		return apellidos;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getEdad() {
		return edad;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " " + apellidos + "\n" +
			   "Edad: " + edad + "\n";
	}

}