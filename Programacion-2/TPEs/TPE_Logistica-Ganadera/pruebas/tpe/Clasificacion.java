package tpe;


public class Clasificacion {
	
	private String clasificacion;
	private CriterioAnimal criterio;
	
	public Clasificacion(String tipo, CriterioAnimal c) {
		clasificacion = tipo;
		criterio = c;
	}
	
	public boolean cumple(Animal animal) {
		return criterio.cumple(animal);
	}
	
	public String getClasificacion() {
		return clasificacion;
	}

	public void cambiarClasificacion(String nuevaClasificacion) {
		// TODO Auto-generated method stub
		clasificacion = nuevaClasificacion;
		
	}

}
