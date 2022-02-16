
public class Liga {

	private String nombre;
	private Equipo[] equipos;
	private Arbitro[] arbitros;
	private Calendario calendario;
	private Clasificacion clasificacion;
	
	public Liga(String nombre, Equipo[] equipos, Arbitro[] arbitros) {

		this.nombre = nombre;
		this.equipos = equipos;
		this.arbitros = arbitros;
		
		//Generamos el calendario
		calendario = new Calendario(this.equipos,this.arbitros);
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre + " infantil.";
	}
	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros = arbitros;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getNombre() {
		return nombre;
	}
	public Equipo[] getEquipos() {
		return equipos;
	}
	public Arbitro[] getArbitros() {
		return arbitros;
	}
	public Calendario getCalendario() {
		return calendario;
	}
	public Clasificacion getClasificacion() {
		return clasificacion;
	}

}