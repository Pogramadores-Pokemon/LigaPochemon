public class Principal {

	public static void main(String[] args) {
		//Crear una Lista de Equipo
		int edad = (int) Math.floor(Math.random()*15)+4;
		int numEquipos=12;
		Equipo[] listaEquipos = crearEquipos(numEquipos, edad);

		//Imprimimos los equipos
		System.out.println("Numero de equipos: "+numEquipos);
		for (Equipo e: listaEquipos) {
			System.out.println(e.getNombre());
		}
	}


	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Rojo", "Eco", "Cris", "Bruno", "Aura", "Hoja", "Leon", "Maya", "Lira", "Lucho",
				"Liza", "Rizzo", "Nanci", "Kalm", "Serena", "Elio", "Selene", "Chase",
				"Elaine", "Victor", "Gloria", "Luka", "Kira", "Misty", "Brock", "Tracey",
				"Yasmina", "Anton", "Vito", "Leti", "Gardenia", "Roco", "Millo", "Iris",
				"Corelia", "Lem"};

		String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
				"Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
				"Siniestro", "Tierra", "Veneno", "Volador"};

		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};

		// Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];

		for (int i=0; i<numeroJugadores; i++) {
			// Crear un Jugador
			Jugador jug = new Jugador();

			// Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			jug.setNombre(nombre);

			// Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			// Posiciï¿½n
			numero = (int) Math.floor(Math.random()*posiciones.length);
			String posicion = posiciones[numero];
			jug.setPosicion(posicion);

			// Edad
			jug.setEdad(edad);

			// Dorsal
			jug.setDorsal(i+1);

			// Equipo
			jug.setEquipo(equipo);

			jugadores[i]=jug;

		}

		return jugadores;
	}

	private static Equipo[] crearEquipos(int numEquipos,int edad) {

		String [] barrios = {"Kanto", "Johto", "Hoenn", "Sinnoh", "Teselia", "Unova", "Kalos", "Alola", "Galar",
							 "Hisui", "Almia", "Aura"};

		String [] mascotas = {"Los Dratinis", "Los Stantlers", "Los Absols", "Los Luxios", "Los Trubbishes", "Los Kricketots",
							  "Los Panchams", "Los Oricorios", "Los Yampers", "Los Eevees", "Los Drifloons", "Los Emolgas"};

		String [] clubs = {"Kanto Balon Pai", "Johto Futball Clup","Union de Hoenn","S de Sinnoh F.C","Teselia de Desta",
						   "Unova Deportiva","Real Kalos furbo","Clu' Dah Lola","Galar Galante Club",
						   "Unión Pijos de Hisui ","Rial D'almia F.C.","Boreales Du Aura"};
		
		Equipo [] listaEquipos= new Equipo[numEquipos];

		for (int i=0; i<numEquipos; i++) {
			// Creamos Equipo
			Equipo equipo = new Equipo();
	
			// Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*barrios.length);
			String barrio= barrios[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];
	
			// Definimos el club en base al nombre del barrio
			numero = (int) Math.floor(Math.random()*clubs.length);
			String club= clubs[numero];
			equipo.setClub(club);
	
			// Las pegamos con un "de" en medio
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}
	
			equipo.setNombre(nombre);
			// Continuamos con entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);
	
			// Meter los jugadores
			int numeroJugadores=(int) Math.floor(Math.random()*7)+15;
			Jugador[] jugadores = crearJugadores(numeroJugadores,edad,equipo);
			equipo.setJugadores(jugadores);
	
			// Meter el equipo en el array de equipos
	
			listaEquipos[i]=equipo;
		}
		return listaEquipos;

}

	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Oak", "Elm", "Abedul", "Serbal", "Encina", "Cipres", "Kukui", "Magnolia",
				"Cio", "Nereida", "Lulu", "Chris", "Kiawe"};
	
		String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
				"Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
				"Siniestro", "Tierra", "Veneno", "Volador"};
	
		Entrenador entrenador = new Entrenador();
	
		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		entrenador.setNombre(nombre);
	
		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		entrenador.setApellidos(apellido1+" "+apellido2);
	
		//Equipo
		entrenador.setEquipo(equipo);
	
		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		entrenador.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		entrenador.setNumeroLicencia(licencia);
	
		return entrenador;
	}
}
