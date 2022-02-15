
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
			Partido[] partidos = jor.getPartido();
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
		
		// Ordenarla
	}
	
	@Override
	public String toString() {
		String cadena = "Equipo\t\t\t\t\t"+"J\t"+"G\t"+"E\t"+"P\t"+
				"GF\t"+"GC\t"+"DG\t"+"Pts\n";
		for (EquipoClasificacion eq: this.tabla) {
			cadena+=eq;
		}
		return cadena;
	}
}

