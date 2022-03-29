package tpe;

import java.util.ArrayList;
import java.util.List;

public class Grupo extends GrupoAbs {
	private List <GrupoAbs> eslabones;
	private String nombre;
	
	public Grupo(String n) {
		eslabones = new ArrayList<GrupoAbs>();
		nombre = n;
	}
	
	public void addEslabon(GrupoAbs e) {
		eslabones.add(e);
	}
	
	@Override
	public int getCantidad() {	
		int cantidadTotal = 0;
		for ( GrupoAbs i : eslabones ) {
			cantidadTotal += i.getCantidad();
		}
		
		return cantidadTotal;
	}
	
	@Override
	public int getEdad() {
		int total = 0;
		for (GrupoAbs s : eslabones)
			total += s.getEdad();
		return total;
	}
	
	@Override
	public double getPeso() {
		double peso = 0;
		
		for( GrupoAbs elem : eslabones )
			peso += elem.getPeso();
		
		return peso;
	}
	/*
	@Override
	public boolean puedeVender(Criterio c) {
		boolean retorno = true;
		for (SistemaGanadero i : eslabones) {
			if (!(i.puedeVender(c))) {
				retorno = false;
				break;
			}
		}
		return retorno;
	}*/
	
	
	public List<Animal> llenarCamion(int capacidad, CriterioAnimal criterio) {
		List<Animal> animales = new ArrayList<Animal>();
		List<Animal> aux = new ArrayList<Animal>();
		int i = 0; 
		while ( i < eslabones.size() && capacidad > 0 ) {
			GrupoAbs eslabon = eslabones.get(i);
			
			aux = eslabon.llenarCamion(capacidad,criterio);
			animales.addAll(aux);

			capacidad = capacidad - aux.size();
			i++;
		}
		
		for (Animal animal : animales)
			eliminarAnimal(animal);;

		return animales;
	}
	
	public boolean eliminarAnimal(Animal a) {
		if (eslabones.contains(a)) {
			eslabones.remove(a);
			return true;
		} else {
			for (GrupoAbs s : eslabones) {
				if (s.eliminarAnimal(a)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public void mostrarIDS() {
		for (GrupoAbs s : eslabones) {
			s.mostrarIDS();
		}
	}


}
