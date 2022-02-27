
public class Partido {

	private Equipo local;
	private Equipo visitante;
	private int gLocal;
	private int gVisitante;
	private Arbitro arbitro;


	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getLocal() {
		return local;
	}
	
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public Equipo getVisitante() {
		return visitante;
	}

	public void setgLocal(int gLocal) {
		this.gLocal = gLocal;
	}
	public int getgLocal() {
		return gLocal;
	}
	
	public void setgVisitante(int gVisitante) {
		this.gVisitante = gVisitante;
	}
	public int getgVisitante() {
		return gVisitante;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	public Arbitro getArbitro() {
		return arbitro;
	}
	
	@Override
	public String toString() {
		return this.local.getNombre()+" "+this.gLocal+":"
				+this.gVisitante+" " +this.visitante.getNombre()
				+", Arbitro: "+this.arbitro.getApellidos()+"\n";
	}
	

}