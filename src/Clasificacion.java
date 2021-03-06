public class Clasificacion {

	private EquipoClasificacion [] tabla;

	public Clasificacion (Equipo[] equipos, Calendario calendario) {

		//Creamos la tabla
		int numeroEquipos = equipos.length;

		this.tabla = new EquipoClasificacion[numeroEquipos];
		for (int i = 0 ;i < numeroEquipos; i++) {
			this.tabla[i] = new EquipoClasificacion();
			this.tabla[i].setEquipo(equipos[i]);
		}

		//Rellenamos la tabla
		Jornada[] jornadas = calendario.getJornadas();
		for (Jornada jor : jornadas) {
			if (jor.isTerminada()) {
				Partido[] partidos = jor.getPartidos(); 
				for (Partido par : partidos) {
					Equipo local = par.getLocal();
					Equipo visitante = par.getVisitante();

					//Buscamos a los equipos en la tabla de clasificacion
					int contador = 0;
					EquipoClasificacion localClas = this.tabla[contador];

					//Buscamos al equipo local
					while (localClas.getEquipo() != local) {
						contador++;
						localClas = this.tabla[contador];
					}
					contador = 0;
					EquipoClasificacion visitClas = this.tabla[contador];

					//Buscamos al equipo visitante
					while (visitClas.getEquipo() != visitante) {
						contador++;
						visitClas = this.tabla[contador];
					}

					//Asignamos los valores
					int golesLocales = par.getgLocal();
					int golesVisitantes = par.getgVisitante();

					localClas.addGolesFavor(golesLocales);
					localClas.addGolesContra(golesVisitantes);

					visitClas.addGolesFavor(golesVisitantes);
					visitClas.addGolesContra(golesLocales);

					if (golesLocales > golesVisitantes) {//Gana el equipo local
						localClas.addVictoria();
						visitClas.addDerrota();
					} else if (golesLocales < golesVisitantes) {//Gana el equipo visitante
						localClas.addDerrota();
						visitClas.addVictoria();
					} else {//Empatan
						localClas.addEmpate();
						visitClas.addEmpate();
					}
				}
			}
		}
		ordenar();

	}

	private void ordenar() {

		//Ordenacion por BubbleSort
		int n = this.tabla.length;  
		EquipoClasificacion temp = null;  
		for (int i = 0; i < n; i++){  
			for (int j = 1; j < (n - i); j++){  
				if (vaDespues(tabla[j - 1], tabla[j])){

					//Intercambiamos los elementos 
					temp = tabla[j - 1];  
					tabla[j - 1] = tabla[j];  
					tabla[j] = temp;  
				}  
			}  
		}

	}

	private boolean vaDespues(EquipoClasificacion equipo1, EquipoClasificacion equipo2) {
		
		//Primer Criterio. Puntos totales
		if (equipo1.getPuntos() < equipo2.getPuntos()) {
			return true;
		} else if (equipo1.getPuntos() > equipo2.getPuntos()) {
			return false;
		} else { //Segundo Criterio. A igualdad de puntos, diferencia de goles
			if (equipo1.getdGoles() < equipo2.getdGoles()) {
				return true;
			} else if (equipo1.getdGoles() > equipo2.getdGoles()) {
				return false;
			} else {//Tercer Criterio. A igualdad de DG, goles a favor
				if (equipo1.getgFavor() < equipo2.getgFavor()) {
					return true;
				} else if (equipo1.getgFavor() > equipo2.getgFavor()) {
					return false;
				}
			}
			//Ultimo criterio. El primero baja, sin mas.
			return true;
		}

	}

	@Override
	public String toString() {
		String cadena="Pos\tEquipo\t\t\t\t\t\t" + "J\t" + "G\t" + "P\t" + "E\t" + "GF\t" + "GC\t" + "DG\t" + "Pts\n";
		for (int i=0;i<tabla.length; i++) {
			cadena+=(i+1)+"\t"+tabla[i];
		}
		return cadena;
	}

}