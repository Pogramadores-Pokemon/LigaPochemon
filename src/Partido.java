
public class Partido {

	private Arbitro [] arbitro;
	private int favor;
	private int contra;
	private Equipo local;
	private Equipo visitante;
	
	
	public Arbitro[] getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro[] arbitro) {
		this.arbitro = arbitro;
	}
	
	public int getFavor() {
		return favor;
	}
	public void setFavor(int favor) {
		this.favor = favor;
	}

	public int getContra() {
		return contra;
	}
	public void setContra(int contra) {
		this.contra = contra;
	}

	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	

}
