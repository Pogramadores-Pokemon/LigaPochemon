
public class Arbitro extends Persona {

	int licencia;

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	public int getLicencia() {
		return licencia;
	}

	@Override
	public String toString() {
		return "Arbitro [licencia=" + licencia + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getEdad()=" + getEdad() + "]";
	}

}