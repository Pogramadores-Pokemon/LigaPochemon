import java.util.Arrays;

public class Jornada {
	private Partido [] partidos;
	private Arbitro [] arbitro;
	private int horario;
	
	
	public Partido[] getPartido() {
		return partidos;
	}
	public void setPartido(Partido[] partidos) {
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
	
	
	@Override
	public String toString() {
		String cadena="Jornada: \n";
		for (int i=0; i<this.partidos.length; i++) {
			cadena+=(i+1)+"ª Partido \n"+this.partidos[i]+"\n";
		}
		return cadena;
	}

	
}