
public class Equipo {

	private String nombre;
	private String club;
	private String equipacion;
	private Entrenador entrenador;
	private Jugador[] jugadores;


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public void setClub(String club) {
		this.club = club;
	}
	public String getClub() {
		return club;
	}

	public void setEquipacion(String equipacion) {
		this.equipacion = equipacion;
	}
	public String getEquipacion() {
		return equipacion;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	public Jugador[] getJugadores() {
		return jugadores;
	}

	public String toStringListaJugadores() {
		String listaJugadores = "";
		for (Jugador j : jugadores) {
			listaJugadores += j;
		}
		return listaJugadores;

	}
	
	@Override
	public String toString() {
		return "    Nombre equipo: "+nombre+", Club: "+club+"\n" +
			   "    Entrenador: "+entrenador.getNombre()+" "+entrenador.getApellidos()+"\n"+
			   toStringListaJugadores();

	}

}