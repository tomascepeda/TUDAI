package tpe;

import java.util.ArrayList;
import java.util.List;

public class SistemaGanadero {
	
	private List<Clasificacion> clasificaciones;
	
	public SistemaGanadero() {
		clasificaciones = new ArrayList<Clasificacion>();
	}
	
	public void addClasificacion(Clasificacion c) {
		clasificaciones.add(c);
	}
		
	public List<String> getClasificacion(Animal animal) {
		List<String> aux = new ArrayList<String>();
		
		for (Clasificacion clasificacion : clasificaciones) {
			if ( clasificacion.cumple(animal) ) {
				aux.add(clasificacion.getClasificacion());
			}
		}
		
		return aux;
	}
	

}
