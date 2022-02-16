public class Principal {

	public static void main(String[] args) {

		final int NUMEROEQUIPOS = 20;
		final int EDAD = 12;
		final String NOMBRELIGA = "La SuperLiga";
		final int JORNADASJUGADAS = 15;
		
		Equipo[] misEquipos = crearListaEquipos(NUMEROEQUIPOS, EDAD);
		Arbitro[] arbitros = new Arbitro[NUMEROEQUIPOS / 2]; 
		for ( int i = 0; i < arbitros.length; i++) {
			arbitros[i] = crearArbitro();
		}
		
		Liga miLiga = new Liga(NOMBRELIGA, misEquipos, arbitros);
		System.out.println(miLiga.getCalendario());
		Calendario miCalendario = miLiga.getCalendario();
		generarPartidos(miCalendario, JORNADASJUGADAS);
		
		
		Clasificacion clasificacion = new Clasificacion(misEquipos, miCalendario);
		System.out.println(clasificacion);
	}

	private static Jugador[] crearListaJugadores(int numeroJugadores, int edad, Equipo equipo) {

		String[] nombres = {"Rojo", "Eco", "Cris", "Bruno", "Aura", "Hoja", "Leon", "Maya", "Lira", 
							"Lucho", "Liza", "Rizzo", "Nanci", "Kalm", "Serena", "Elio", "Selene", 
							"Chase", "Elaine", "Victor", "Gloria", "Luka", "Kira", "Misty", "Brock", 
							"Tracey", "Yasmina", "Anton", "Vito", "Leti", "Gardenia", "Roco", "Millo", 
							"Iris", "Corelia", "Lem"};
		String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
				  			  "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
				  			  "Siniestro", "Tierra", "Veneno", "Volador"};

		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};


		Jugador[] listaJugadores = new Jugador[numeroJugadores];

		for (int i = 0; i < numeroJugadores; i++) {
			Jugador jug = new Jugador();

			//Creamos los nombres de los jugadores
			int numero = (int) Math.floor((Math.random()) * nombres.length);
			jug.setNombre(nombres[numero]);

			//Creamos los apellidos de los jugadores
			numero = (int) Math.floor((Math.random()) * apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor((Math.random()) * apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1 + " " + apellido2);

			//Creamos la posicion de los jugadores
			numero = (int) Math.floor((Math.random()) * posiciones.length);
			jug.setPosicion(posiciones[numero]);

			//Ponemos la edad que hemos definido arriba
			jug.setEdad(edad);

			//Creamos el dorsal
			jug.setDorsal(i + 1);
			
			//Añadimos el equipo
			jug.setEquipo(equipo);

			listaJugadores[i] = jug;
		}
		return listaJugadores;
	}

	
	private static Equipo[] crearListaEquipos(int numeroEquipos, int edad) {

		String[]  barrios = {"Kanto", "Johto", "Hoenn", "Sinnoh", "Teselia", "Unova", "Kalos", 
							 "Alola", "Galar", "Hisui", "Almia", "Aura"};
		String[] mascotas = {"Los Dratinis", "Los Stantlers", "Los Absols", "Los Luxios", 
							 "Los Trubbishes", "Los Kricketots", "Los Panchams", "Los Oricorios", 
							 "Los Yampers", "Los Eevees", "Los Drifloons", "Los Emolgas"};
		
		
		Equipo[] equipos = new Equipo[numeroEquipos];

		//La edad ha de ser siempre la misma
		for (int i = 0; i < numeroEquipos; i++) {
			Equipo equipo = new Equipo();

			//Nombre del equipo y del club al que pertenece
			String nombreEquipo;
			int numero = (int) Math.floor((Math.random()) * mascotas.length);
			String mascota = mascotas[numero];
			numero = (int) Math.floor((Math.random()) * barrios.length);
			String barrio = barrios[numero];
			equipo.setClub(barrio + " F.C.");
			
			if(barrio.startsWith("El ")) {
				barrio = barrio.substring(3);
				nombreEquipo = mascota + " del " + barrio;
			}else {
				nombreEquipo = mascota + " de " + barrio;
			}
			equipo.setNombre(nombreEquipo);
			
			//Hacemos el entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);
			
			//Creamos e introducimos a los jugadores
			int numeroJugadores = (int) Math.floor((Math.random()) * 8) + 15;
			Jugador[] listaJugadores = crearListaJugadores(numeroJugadores, edad, equipo);
			equipo.setJugadores(listaJugadores);
		
			//Lo añadimos al array
			equipos[i] = equipo;
		
		
		}
		return equipos;
	}

	private static Entrenador crearEntrenador(Equipo equipo) {

		String[] nombres = {"Oak", "Elm", "Abedul", "Serbal", "Encina", "Cipres", "Kukui", 
							"Magnolia", "Cio", "Nereida", "Lulu", "Chris", "Kiawe"};
		String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
							  "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
							  "Siniestro", "Tierra", "Veneno", "Volador"};
		
		Entrenador entrenador = new Entrenador();

		//Nombre del entrenador
		int numero = (int) Math.floor((Math.random()) * nombres.length);
		String nombre = nombres[numero];
		numero = (int) Math.floor((Math.random()) * apellidos.length);
		String apellido = apellidos[numero];

		//Edad del entrenador
		int edad = (int) Math.floor((Math.random()) * 48) + 18;

		//Licencia del entrenador
		int licencia = (int) Math.floor((Math.random()) * 900000) + 100000;
		entrenador.setNombre(nombre);
		entrenador.setApellidos(apellido);
		entrenador.setEdad(edad);
		entrenador.setEquipo(equipo);
		entrenador.setNumeroLicencia(licencia);
		
		return entrenador;

	}

	private static Arbitro crearArbitro() {

		String[] nombres = {"Oak", "Elm", "Abedul", "Serbal", "Encina", "Cipres", "Kukui", 
							"Magnolia", "Cio", "Nereida", "Lulu", "Chris", "Kiawe"};
		String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
							  "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
							  "Siniestro", "Tierra", "Veneno", "Volador"};
		
		Arbitro arbitro = new Arbitro();

		//Nombre del arbitro
		int numero = (int) Math.floor((Math.random()) * nombres.length);
		String nombre = nombres[numero];
		numero = (int) Math.floor((Math.random()) * apellidos.length);
		String apellido = apellidos[numero];

		//Edad del arbitro
		int edad = (int) Math.floor((Math.random()) * 48) + 18;

		//Licencia del arbitro
		int licencia = (int) Math.floor((Math.random()) * 900000) + 100000;
		arbitro.setNombre(nombre);
		arbitro.setApellidos(apellido);
		arbitro.setEdad(edad);
		arbitro.setLicencia(licencia);
		
		return arbitro;

	}

	private static void generarPartidos(Calendario calendario, int numeroJornadas) {
		
		final int MAXGOLES = 7;
		Jornada[] jornadas = calendario.getJornadas();
		int totalJornadas = jornadas.length;
		
		for (int i = 0; i < numeroJornadas && i < totalJornadas; i++) {
			System.out.println("Jornada: " + (i + 1));
			Partido[] partidos = jornadas[i].getPartidos();
			for (Partido par : partidos) {
				int golesLocales = (int)Math.floor((Math.random()) * MAXGOLES);
				int golesVisitantes = (int)Math.floor((Math.random()) * MAXGOLES);
				par.setgLocal(golesLocales);
				par.setgVisitante(golesVisitantes);
				System.out.println(par);
			}
			jornadas[i].terminar();
		}
		
	}

}