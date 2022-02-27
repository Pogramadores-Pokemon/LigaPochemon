import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		final int NUMEROEQUIPOS=20;
		final int EDAD=(int) Math.floor((Math.random())*15)+4;
		final String NOMBRELIGA="Liga Pochemon";
		final int JORNADASJUGADAS=38;
		final int ALINEACION=(int) Math.floor((Math.random())*3);
		
		Equipo[] equipos = crearListaEquipos(NUMEROEQUIPOS, EDAD, ALINEACION);
		Arbitro[] arbitros = new Arbitro[NUMEROEQUIPOS / 2]; 
		for ( int i = 0; i < arbitros.length; i++) {
			arbitros[i] = crearArbitro();
		}
		Liga liga = new Liga(NOMBRELIGA, equipos, arbitros);
		Calendario calendario = liga.getCalendario();
		
		generarPartidos(calendario, JORNADASJUGADAS);
		
		Clasificacion clasificacion = new Clasificacion(equipos, calendario);	

		
		
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		while(opcion!=4) {
			limpiarPantalla();
			imprimirMenu();
			opcion=leerEntrada();
			
		switch(opcion) {
		case 1:
			System.out.println();
			for (Equipo e : equipos) {
				System.out.println(e.toString());
			}
			break;
		case 2:
			System.out.println();
			System.out.println(calendario.toString());
			break;
		case 3:
			System.out.println();
			System.out.println();
			System.out.println(clasificacion.toString());
			break;
		case 4:
			System.out.println("   ==============================");
			System.out.println("   |       ¡Hasta pronto!       |");
			System.out.println("   ==============================");
			break;
		default:
			System.out.println("   ==============================");
			System.out.println("   |  Esta opción no es válida.  |");
			System.out.println("   ==============================");
		}
		
		if (opcion!=4) {
			System.out.println();
			System.out.println();
			System.out.println("Presiona Enter para continuar.");
			pressEnter();
		}	
	}
}
		

	private static Jugador[] crearListaJugadores(int numeroJugadores, int edad, Equipo equipo, int alineacion) {

		String[] nombres = {"Rojo", "Eco", "Cris", "Bruno", "Aura", "Hoja", "Leon", "Maya", "Lira", 
				"Lucho", "Liza", "Rizzo", "Nanci", "Kalm", "Serena", "Elio", "Selene", 
				"Chase", "Elaine", "Victor", "Gloria", "Luka", "Kira", "Misty", "Brock", 
				"Tracey", "Yasmina", "Anton", "Vito", "Leti", "Gardenia", "Roco", "Millo", 
				"Iris", "Corelia", "Lem"};
		String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
				"Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
				"Siniestro", "Tierra", "Veneno", "Volador"};

		Jugador[] listaJugadores = new Jugador[numeroJugadores];

		for (int i=0;i<numeroJugadores;i++) {
			Jugador jug = new Jugador();

			//Creamos los nombres de los jugadores
			int numero=(int) Math.floor((Math.random())*nombres.length);
			jug.setNombre(nombres[numero]);

			//Creamos los apellidos de los jugadores
			numero=(int) Math.floor((Math.random())*apellidos.length);
			String apellido1=apellidos[numero];
			numero=(int) Math.floor((Math.random())*apellidos.length);
			String apellido2=apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//Ponemos la edad que hemos definido arriba
			jug.setEdad(edad);

			//Creamos el dorsal
			jug.setDorsal(i+1);

			//Anadimos el equipo
			jug.setEquipo(equipo);

			// Posicion
			switch (alineacion) {
			case 0:
				String[] alineacion0 = {"Portero/a", "Defensa", "Defensa", "Defensa", "Defensa",
						"Centrocampista", "Centrocampista", "Centrocampista",
						"Delantero/a", "Delantero/a", "Delantero/a"};
				jug.setPosicion(alineacion0[i]);
				break;
			case 1:
				String[] alineacion1 = {"Portero/a", "Defensa", "Defensa", "Defensa", "Defensa",
						"Centrocampista", "Centrocampista", "Centrocampista", "Centrocampista",
						"Delantero/a", "Delantero/a"};
				jug.setPosicion(alineacion1[i]);
				break;
			case 2:
				String[] alineacion2 = {"Portero/a", "Defensa", "Defensa", "Defensa",
						"Centrocampista", "Centrocampista", "Centrocampista", "Centrocampista",
						"Delantero/a", "Delantero/a", "Delantero/a"};
				jug.setPosicion(alineacion2[i]);
				break;
			case 3:
				String[] alineacion3 = {"Portero/a", "Defensa", "Defensa", "Defensa",
						"Centrocampista", "Centrocampista", "Centrocampista", "Centrocampista", "Centrocampista",
						"Delantero/a", "Delantero/a"};
				jug.setPosicion(alineacion3[i]);
				break;
			}
			listaJugadores[i]=jug;
		}
		return listaJugadores;
	}
	private static Equipo[] crearListaEquipos(int numeroEquipos, int edad, int alineacion) {

		String[]  regiones = {"Kanto", "Johto", "Hoenn", "Sinnoh", "Teselia", "Unova", "Kalos", 
				"Alola", "Galar", "Hisui", "Almia", "Aura"};
		
		String[] mascotas = {"Los Dratinis", "Los Stantlers", "Los Absols", "Los Luxios", 
				"Los Trubbishes", "Los Kricketots", "Los Panchams", "Los Oricorios", 
				"Los Yampers", "Los Eevees", "Los Drifloons", "Los Emolgas"};

		String [] clubs = {"Kanto Balón Pai", "Johto Futball Clup","Union de Hoenn","S de Sinnoh F.C","Teselia de Desta",
				"Unova Deportiva","Real Kalos furbo","Clú Dah Lola","Galar Galante Club",
				"Unión Pijos de Hisui ","Rial D'almia F.C.","Boreales Du Aura"};

		
		Equipo[] equipos = new Equipo[numeroEquipos];

		//La edad ha de ser siempre la misma
		for (int i=0;i<numeroEquipos;i++) {
			Equipo equipo = new Equipo();

			//Nombre del equipo
			String nombreEquipo;
			int numero=(int) Math.floor((Math.random())*mascotas.length);
			String mascota = mascotas[numero];
			numero=(int) Math.floor((Math.random())*regiones.length);
			String region=regiones[numero];
			
			nombreEquipo=mascota+" de "+region;
			equipo.setNombre(nombreEquipo);
			
			//Club del equipo
			numero=(int) Math.floor((Math.random())*clubs.length);
			String club = clubs[numero];
			equipo.setClub(club);

			//Hacemos el entrenador
			Entrenador entrenador=crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);

			//Creamos e introducimos a los jugadores
			int numeroJugadores=11;
			Jugador[] listaJugadores=crearListaJugadores(numeroJugadores, edad, equipo, alineacion);
			equipo.setJugadores(listaJugadores);

			//Lo anadimos al array
			equipos[i]=equipo;


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
		int numero=(int) Math.floor((Math.random())*nombres.length);
		String nombre=nombres[numero];
		numero=(int) Math.floor((Math.random())*apellidos.length);
		String apellido=apellidos[numero];

		//Edad del entrenador
		int edad=(int) Math.floor((Math.random())*48)+18;

		//Licencia del entrenador
		int licencia=(int) Math.floor((Math.random())*900000)+100000;
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
		int numero=(int) Math.floor((Math.random())*nombres.length);
		String nombre = nombres[numero];
		numero=(int) Math.floor((Math.random())*apellidos.length);
		String apellido = apellidos[numero];

		//Edad del arbitro
		int edad=(int) Math.floor((Math.random())*48)+18;

		//Licencia del arbitro
		int licencia=(int) Math.floor((Math.random())*900000)+100000;
		arbitro.setNombre(nombre);
		arbitro.setApellidos(apellido);
		arbitro.setEdad(edad);
		arbitro.setLicencia(licencia);

		return arbitro;

	}

	private static void generarPartidos(Calendario calendario, int numeroJornadas) {

		final int MAXGOLES=7;
		Jornada[] jornadas=calendario.getJornadas();
		int totalJornadas=jornadas.length;

		for (int i=0;i<numeroJornadas && i<totalJornadas;i++) {
			System.out.println("Jornada: "+(i + 1));
			Partido[] partidos=jornadas[i].getPartidos();
			for (Partido par : partidos) {
				int golesLocales=(int)Math.floor((Math.random())*MAXGOLES);
				int golesVisitantes=(int)Math.floor((Math.random())*MAXGOLES);
				par.setgLocal(golesLocales);
				par.setgVisitante(golesVisitantes);
				System.out.println(par);
			}
			jornadas[i].terminar();
		}
	}

	
	public static void imprimirMenu() {
		System.out.println();
		System.out.println("                               L I G A");
		System.out.println("                            P O C H E M O N ");
		System.out.println();
		System.out.println("   	         =======================================");
		System.out.println(" 	         |   Seleccione la opcion que desee:   |");
		System.out.println("  	         |=====================================|");
		System.out.println("  	         |     1. Ver equipos.                 |");
		System.out.println(" 	         |     2. Ver calendario.              |");
		System.out.println(" 	         |     3. Clasificación actual.        |");
		System.out.println(" 	         |     4. Salir.                       |");
		System.out.println("  	         =======================================");
		System.out.println();
		System.out.println("  	             ===============================");
		System.out.println("  	             |  Hecho por:                 |");
		System.out.println("  	             |   · Alvaro Gonzalez         |");
		System.out.println("  	             |   · Alejandro Pascual       |");
		System.out.println("  	             |   · Manuel Recio            |");
		System.out.println("  	             |   · Alejandro Cabrera       |");
		System.out.println("  	             |   · Alicia Ruiznavarro      |");
		System.out.println("  	             ===============================");
	}
	
	
	public static int leerEntrada() {
		Scanner sc=new Scanner(System.in);
		int num;
		return num=sc.nextInt();
	}
	public static void pressEnter() {
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
	}
	public static void limpiarPantalla() {
		for (int i=0;i<200;i++) {
			System.out.println();
		}
	}

}
