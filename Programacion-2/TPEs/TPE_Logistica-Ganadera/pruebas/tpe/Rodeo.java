package tpe;

import java.util.ArrayList;
import java.util.List;

public class Rodeo extends GrupoAbs {
	
	public void mostrarIDS() {
		for (Animal a : animales ) {
			System.out.println(a.getId());
		}
	}
	
	private List<Animal> animales;

	public Rodeo() {
		animales = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a) {
		animales.add(a);
	}

	@Override
	public int getCantidad() {
		return animales.size();
	}
	
	@Override
	public int getEdad() {
		int sum = 0;
		for (Animal a : animales )
			sum += a.getEdad();
		return sum;
	}
	
	@Override
	public double getPeso() {
		int suma = 0;
		for (Animal animal : animales)
			suma += animal.getPeso();
		return suma;
	}
	
	public List<Animal> llenarCamion(int capacidad, CriterioAnimal criterio) {
		List<Animal> animalesDisponibles = new ArrayList<Animal>();
		List<Animal> aux = new ArrayList<Animal>();
		int i = 0;
		while ( i < animales.size() && capacidad > 0 ) {
			Animal animal = animales.get(i);
			aux = animal.llenarCamion(capacidad, criterio);
			animalesDisponibles.addAll(aux);
			capacidad = capacidad - aux.size();
			i++;
		}
		
		for (Animal animal : animalesDisponibles)
			eliminarAnimal(animal);;
		
		return animalesDisponibles;
	}

	@Override
	public boolean eliminarAnimal(Animal a) {
		if (animales.contains(a)) {
			animales.remove(a);
			return true;
		} else {
			return false;
		}
	}
	

	
	
}
