
public class Partido {

	private Arbitro [] arbitro;
	private int Favor;
	private int Contra;
	private Equipo Local;
	private Equipo Visitante;
	
	public Arbitro[] getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro[] arbitro) {
		this.arbitro = arbitro;
	}

	public Equipo getLocal() {
		return Local;
	}
	public void setLocal(Equipo local) {
		Local = local;
	}
	public Equipo getVisitante() {
		return Visitante;
	}
	public void setVisitante(Equipo visitante) {
		Visitante = visitante;
	}
	public int getFavor() {
		return Favor;
	}
	public void setFavor(int favor) {
		Favor = favor;
	}
	public int getContra() {
		return Contra;
	}
	public void setContra(int contra) {
		Contra = contra;
	}

	

}
