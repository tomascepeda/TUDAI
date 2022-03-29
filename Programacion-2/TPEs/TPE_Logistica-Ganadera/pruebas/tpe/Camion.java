package tpe;

import java.util.ArrayList;
import java.util.List;

public class Camion {
	private int capacidad;
	private CriterioAnimal c;
	private List<Animal> animales;
	
	public Camion (int capacidad, CriterioAnimal criterio) {
		animales = new ArrayList<Animal>();
		this.capacidad = capacidad;
		c = criterio;
	}
	

	public void addAnimal(Animal a) {
		if (c.cumple(a) && (capacidad>animales.size() || animales.contains(null))) {	//contains null?		
			animales.add(a);
		} 
	}
	
	public void addAnimales(ArrayList<Animal> list) {
		animales.addAll(list);
	}
	
	public void setCriterio(CriterioAnimal c1) {
		c = c1;
	}
	
	public CriterioAnimal getCriterio() {
		return c;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public ArrayList<Animal> getAnimales() {
		ArrayList<Animal> retorno = new ArrayList<Animal>();
		retorno.addAll(animales);
		return retorno;
	}
	

}
