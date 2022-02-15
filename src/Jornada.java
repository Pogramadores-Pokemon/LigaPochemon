import java.util.Arrays;

public class Jornada {
	private Partido [] partidos;
	private Arbitro [] arbitro;
	private int horario;
	private boolean isTerminada=false;

	
	public Partido[] getPartidos() {
		return partidos;
	}
	public void setPartidos(Partido[] partidos) {
		this.partidos= partidos;
	}
	
	public Arbitro[] getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro[] arbitro) {
		this.arbitro = arbitro;
	}
	
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	
	public boolean isTerminada() {
		return isTerminada;
	}
	public void setTerminada(boolean terminada) {
		this.isTerminada=isTerminada;
	}
	public void terminar() {
		this.isTerminada=true;
	}
	
	@Override
	public String toString() {
		String cadena="Jornada: \n";
		for (int i=0; i<this.partidos.length; i++) {
			cadena+=(i+1)+"ª Partido \n"+this.partidos[i]+"\n";
		}
		return cadena;
	}

	
}