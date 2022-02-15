public class Clasificacion {
	private EquipoClasificacion[] tabla;
	
	public Clasificacion(Equipo[] equipos, Calendario calendario) {
		// Crear la tabla
		int numEquipos=equipos.length;
		
		this.tabla = new EquipoClasificacion[numEquipos];
		
		for (int i=0;i<numEquipos;i++) {
			this.tabla[i] = new EquipoClasificacion();
			this.tabla[i].setEquipo(equipos[i]);
		}
		
		// Rellenarla
		Jornada[] jornadas = calendario.getJornadas();
		for (Jornada jor : jornadas) {
			if (jor.isTerminada()) {
				Partido[] partidos = jor.getPartidos();
				for (Partido par : partidos) {
					Equipo local=par.getLocal();
					Equipo visitante=par.getVisitante();
					
					// Buscar a los equipos en la tabla de clasificacion
					int contador=0;
					EquipoClasificacion localClas = this.tabla[contador];
					// Busco al local
					while (localClas.getEquipo()!=local) {
						contador++;
						localClas=this.tabla[contador];
					}
					
					contador=0;
					EquipoClasificacion visitClas = this.tabla[contador];
					// Busco al visitante
					while (visitClas.getEquipo()!=visitante) {
						contador++;
						visitClas=this.tabla[contador];
					}
					
					// Asignamos los valores
					int golesLocales=par.getgLocal();
					int golesVisitantes=par.getgVisitante();
					
					localClas.addGolesFavor(golesLocales);
					localClas.addGolesContra(golesVisitantes);
					
					visitClas.addGolesFavor(golesVisitantes);
					visitClas.addGolesContra(golesLocales);
					
					if (golesLocales>golesVisitantes) { // Gana local
						localClas.addVictoria();
						visitClas.addDerrotas();
					}else if (golesVisitantes<golesVisitantes) { // Gana visitante
						localClas.addDerrotas();
						visitClas.addVictoria();
					}else {									// Empate
						localClas.addEmpate();
						visitClas.addEmpate();
						
					}
				}
			}
		}

		// Ordenarla
		ordenar();
	}

	private void ordenar() {
		//Ordenacion por bubbleSort
		int n=this.tabla.length;
		EquipoClasificacion temp=null;

		for(int i=0;i<n;i++) {
			for (int j=1;j<(n-i);j++) {
				if(vaDespues(tabla[j-1],tabla[j])) {
					temp=tabla[j-1];
					tabla[j-1]=tabla[j];
					tabla[j]=temp;
				}
			}
		}
	}

	private boolean vaDespues(EquipoClasificacion equipo1, EquipoClasificacion equipo2) {
		// Primer Critero: Puntos
		if(equipo1.getPuntos()<equipo2.getPuntos()) {
			return true;
		}else if(equipo1.getPuntos()>equipo2.getPuntos()) {
			return false;
		}else { // Segundo criterio: Igualdad de puntos, diferencia de goles
			if(equipo1.getdGoles()<equipo2.getdGoles()) {
				return true;
			}else if(equipo1.getdGoles()>equipo2.getdGoles()) {
				return false;
			}else { // Tercer critero: Goles a favor
				if(equipo1.getgFavor()<equipo2.getgFavor()) {
					return true;
				}else if(equipo1.getgFavor()>equipo2.getgFavor()) {
					return false;
				}
			}
		}
		// Ultimo critero: el primero baja y punto
		return true;
	}
	

	@Override
	public String toString() {
		String cadena = "Equipo\t\t\t\t\t\t"+"J\t"+"G\t"+"E\t"+"P\t"+
				"GF\t"+"GC\t"+"DG\t"+"Pts\n";
		for (int i=0; i<tabla.length; i++) {
			cadena+=(i+1)+" "+tabla[i];
		}
		return cadena;
	}

}

