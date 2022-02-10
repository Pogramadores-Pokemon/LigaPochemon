public class Calendario {
	Equipo[] equipos;
	Equipo[][] enfrentamientos = new Equipo[2][equipos.length/2];
	Jornada[] jornadas;
	
	
	//mitad izquierda
	//Recordemos: 0 Local y 1 Visitante
	public void generarCalendario() {
		for (int i=0; i<equipos.length/2;i++) {
			enfrentamientos[0][i]=equipos[i];
		}

		//mitad derecha
		for (int j=equipos.length/2-1; j>=0;j--) {
			enfrentamientos[1][j]=equipos[equipos.length-1-j];
		}

		//Generamos la jornada
		for (int k=0;k<jornadas.length/2;k++){

			//Generamos dos arrays de partidos
			Partido[] partidosIda = new Partido[enfrentamientos.length];
			Partido[] partidosVuelta = new Partido[enfrentamientos.length];

			for (int l=0; k<enfrentamientos[0].length;l++) {
				partidosIda[k].setLocal(enfrentamientos[0][l]);
				partidosIda[k].setVisitante(enfrentamientos[1][l]);

				partidosVuelta[k].setLocal(enfrentamientos[1][l]);
				partidosVuelta[k].setVisitante(enfrentamientos[0][l]);
			}
			//Asignamos los partidos de la ida
			jornadas[k].setPartido(partidosIda);
			//Asignamos los partidos de la vuelta
			jornadas[k+jornadas.length-1].setPartido(partidosVuelta);

			//Redesplazar los equipos
			
		}
	}
	
}

