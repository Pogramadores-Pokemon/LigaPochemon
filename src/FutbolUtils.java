import java.io.BufferedReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public  class FutbolUtils {

	public void guardarEquipo (String nombreArchivo, Equipo equipo) {

		//Recorre un equipo, un nombre de archivo y guarda el equipo.
		
		FileOutputStream fichero = null;
		
		try {
			
		    fichero = new FileOutputStream(nombreArchivo);
			ObjectOutputStream enlace = new ObjectOutputStream(fichero);
			enlace.writeObject(equipo);
			fichero.close();
			
		}catch(FileNotFoundException ex) {
			
			ex.printStackTrace();
		
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}



	public Equipo cargarEquipo (String nombreArchivo) {
		
		Equipo equipo = new Equipo();
		
		//Recibe un nombre de archivo y devuelve un equipo.
		
		try {
			
			FileInputStream fichero = new FileInputStream(nombreArchivo);
			ObjectInputStream enlace = new ObjectInputStream(fichero);
			equipo = (Equipo) enlace.readObject();
			fichero.close();
			
		}catch(FileNotFoundException ex) {
			
			ex.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return equipo;
		
	}


	public Equipo ordenarEquipo (Equipo equipo) {
		
		//Recibe un equipo y ordena a sus jugadores por apellidos,no por longitud.
		
		//En caso de igualdad por nombre.

		Jugador jugadorTemporal = null;
		Jugador[] listaElementos = equipo.getJugadores();
		int longitudLista=listaElementos.length;

		for(int i=0;i<longitudLista;i++) {
			
			for (int j = 1; j < (longitudLista-i); j++) {
				
				if(listaElementos[j-1].getApellidos().compareTo(listaElementos[j].getApellidos())> 0) {
					
					//Cuando el de arriba es mas grande se cambian
					
					jugadorTemporal = listaElementos[j-1];
					listaElementos[j-1] = listaElementos[j];
					listaElementos[j] = jugadorTemporal;

				}
			}
			
			equipo.setJugadores(null);
			equipo.setJugadores(listaElementos);

		}
		
		return equipo;
	
	}


	//Añade las clases que consideres necesarias

	public Jugador[] leerJugador(String archivo,Equipo equipo) {
		
		Jugador[] jugadores = new Jugador[22];
		
		try {
			
			FileReader lector2 = new FileReader(archivo);
			BufferedReader buffLector = new BufferedReader(lector2);
			String cadenaVacia;
			
			while((cadenaVacia = buffLector.readLine()) != null) {
				
				for(int i = 0; i < 22; i++) {
				
					Jugador jugador = new Jugador();
					jugador.setNombre(buffLector.readLine());
					jugador.setApellidos(buffLector.readLine());
					jugador.setEdad(buffLector.read());
					jugador.setPosicion(buffLector.readLine());
					jugador.setDorsal(buffLector.read());
					jugador.setEquipo(equipo);
					jugadores[i] = jugador;
				
				}
			
			}

		}catch(IOException e) {

			System.out.println("Esto ha petado al leer");
			e.printStackTrace();
	
		}finally {
	
			System.out.println();
			System.out.println("Fin de la zona de lectura 2");
			System.out.println();
	
		}
		
		return jugadores;
	
	}

	
	public Jugador[] EscribirJugador(String archivo,Equipo equipo) {
		Jugador[] jugadores = new Jugador[equipo.getJugadores().length];
	
		try {
		
			for(int i = 0; i < jugadores.length;i++) {
				Jugador jugador = new Jugador();
				FileWriter jugEscritor = new FileWriter(archivo);
				BufferedWriter bufJugador = new BufferedWriter(jugEscritor);
				bufJugador.write(jugador.getNombre());
				bufJugador.newLine();
				bufJugador.write(jugador.getApellidos());
				bufJugador.newLine();
				bufJugador.write(Integer.toString(jugador.getEdad()));
				bufJugador.newLine();
				bufJugador.write(jugador.getPosicion());
				bufJugador.close();
			
			}
		
		}catch(IOException e) {
		
			System.out.println("Esto ha petado al leer");
			e.printStackTrace();

		}finally {
		
			System.out.println();
			System.out.println("Fin de la zona de lectura 2");
			System.out.println();
		
		}
		
		return jugadores;
	
	}

}