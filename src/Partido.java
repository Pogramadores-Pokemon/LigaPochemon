
public class Partido {

	private Arbitro [] arbitro;
	private int golfavor;
	private int golcontra;
	private Equipo equipolocal;
	private Equipo equipovisit;
	
	public Arbitro[] getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro[] arbitro) {
		this.arbitro = arbitro;
	}
	public int getGolfavor() {
		return golfavor;
	}
	public void setGolfavor(int golfavor) {
		this.golfavor = golfavor;
	}
	public int getGolcontra() {
		return golcontra;
	}
	public void setGolcontra(int golcontra) {
		this.golcontra = golcontra;
	}
	public Equipo getEquipolocal() {
		return equipolocal;
	}
	public void setEquipolocal(Equipo equipolocal) {
		this.equipolocal = equipolocal;
	}
	public Equipo getEquipovisit() {
		return equipovisit;
	}
	public void setEquipovisit(Equipo equipovisit) {
		this.equipovisit = equipovisit;
	}

}
