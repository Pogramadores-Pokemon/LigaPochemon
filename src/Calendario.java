import java.util.Arrays;

public class Calendario {
	Jornada[] jornadas;
	
	
	public Calendario(Equipo[] equipos, Arbitro[] arbitros) {
		int numEquipos=equipos.length;
		int numJornadas=(numEquipos-1)*2;
		int numPartidos=numEquipos/2;
		
		jornadas=new Jornada[numJornadas];
		Equipo[][] emparejamientos = new Equipo[2][numPartidos];
		
		// Mitad izquierda del array doble
		for(int i=0; i<numPartidos; i++) { 
			emparejamientos[0][i]=equipos[i];	
		}
		
		// Mitad derecha del array doble
		for(int j=numPartidos-1; j>=0; j--) {
			emparejamientos[1][j]=equipos[numEquipos-1-j];
		}
		
		
		 for(int i=0; i<numJornadas/2; i++) {
			 Partido[] partidosIda = new Partido[numPartidos];
			 Partido[] partidosVuelta = new Partido[numPartidos];
			 
			 for(int j=0; j<numPartidos; j++) {
				 // Partidos de ida
				 partidosIda[j] = new Partido();
				 partidosIda[j].setLocal(emparejamientos[0][j]);
				 partidosIda[j].setVisitante(emparejamientos[1][j]);
				 partidosIda[j].setArbitro(arbitros[j]);
				 
				 // Partidos de vuelta
				 partidosVuelta[j] = new Partido();
				 partidosVuelta[j].setLocal(emparejamientos[1][j]);
				 partidosVuelta[j].setVisitante(emparejamientos[0][j]);
				 partidosVuelta[j].setArbitro(arbitros[j]);
			 }
			 // Actualizamos jornadas
			 jornadas[i] = new Jornada();
			 jornadas[i].setPartido(partidosIda);
			 jornadas[numJornadas-1-i] = new Jornada();
			 jornadas[numJornadas-1-i].setPartido(partidosVuelta);
			 
			 // Rotamos el array doble
			 Equipo[][] auxEmp = new Equipo[2][numPartidos];
			 // Actualizamos columna izquierda
			 for (int k=0; k<numPartidos; k++) {
				 if (k==0) {
					 auxEmp[0][k]=emparejamientos[0][k];
				 }else if(k>0 && k>numPartidos-1) {
					 auxEmp[0][k+1]=emparejamientos[0][k];
				 }else {
					 auxEmp[1][k]=emparejamientos[0][k];
				 }
			 }
			 // Actualizamos columna derecha
			 for (int k=0; k<numPartidos; k++) {
				 if(k>0 && k<numPartidos-1) {
					 auxEmp[1][k-1]=emparejamientos[1][k];
				 }else {
					 auxEmp[0][1]=emparejamientos[1][k];
				 }
			 }
			 emparejamientos=auxEmp;
		 }

	}
	
	public Jornada[] getJornadas() {
		return jornadas;
	}
	public void setJornadas(Jornada[] jornadas) {
		this.jornadas = jornadas;
	}

	@Override
	public String toString() {
		String cadena="Calendario de Liga: ";
		for (int i=0; i<this.jornadas.length; i++) {
			cadena+=(i+1)+"ª "+this.jornadas[i]+"\n";
		}
		
		return cadena;
	}
	
	
}

