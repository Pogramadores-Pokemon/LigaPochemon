
public class Pruebas {

	public static void main(String[] args) {
		int numJugadores=19;
		int edad=9;
			Equipo prueba1= new Equipo();
			Jugador[] listaJugadores = crearJugadores(numJugadores, edad, prueba1);
		
		for (Jugador e: listaJugadores) {
			System.out.println(e.getPosicion());
		}
	}


		private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {

			String[] nombres = {"Rojo", "Eco", "Cris", "Bruno", "Aura", "Hoja", "Leon", "Maya", "Lira", "Lucho",
					"Liza", "Rizzo", "Nanci", "Kalm", "Serena", "Elio", "Selene", "Chase",
					"Elaine", "Victor", "Gloria", "Luka", "Kira", "Misty", "Brock", "Tracey",
					"Yasmina", "Anton", "Vito", "Leti", "Gardenia", "Roco", "Millo", "Iris",
					"Corelia", "Lem"};

			String[] apellidos = {"Acero", "Agua", "Bicho", "Dragon", "Electrico","Fuego","Fantasma",
					"Hada", "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca",
					"Siniestro", "Tierra", "Veneno", "Volador"};

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

				// Posicion
				numero = (int) Math.floor(Math.random()*3);
				switch (numero) {
					case 1:
						String[] posiciones = {"Defensa", "Defensa", "Defensa", "Defensa", 
											   "Centrocampista", "Centrocampista", "Centrocampista", 
											   "Delantero/a", "Delantero/a", "Delantero/a", "Portero/a"};
						jug.setPosicion(posiciones[1]);
				}

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
		
		
		
		public void posiciones() {
			
		}
		
	}



