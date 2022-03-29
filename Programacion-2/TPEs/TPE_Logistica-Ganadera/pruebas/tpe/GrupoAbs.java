package tpe;

import java.util.ArrayList;
import java.util.List;

public abstract class GrupoAbs {
	
	public abstract int getCantidad();
	
	public abstract int getEdad();
	
	public abstract double getPeso();
	
	public double getPesoProm() {
		return getPeso() / getCantidad();
	}
	
	public double getEdadProm() {
		return getEdad() / getCantidad();
	}
	
	public boolean puedeVender(CriterioGrupo c) {
		return c.cumple(this);
	}
	
	public abstract List<Animal> llenarCamion(int capacidad, CriterioAnimal criterio);

	public abstract boolean eliminarAnimal(Animal a);
	
	public abstract void mostrarIDS(); //Borrar
	
}
