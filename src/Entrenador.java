
public class Entrenador extends Persona {

	private int numeroLicencia;
	private Equipo equipo;
	
	
	public void setNumeroLicencia(int numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}
	public int getNumeroLicencia() {
		return numeroLicencia;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	
}