package tpe;

import java.util.ArrayList;

public class Animal extends GrupoAbs {

	private static int idGenerator = 0;
	private int id;
	private int edad;
	private double peso;
	private String raza;
	private boolean macho;
	private boolean capado;
	private int cantHijos;
	
	
	public Animal(int edad, double peso, String raza, boolean macho, boolean capado, int cantHijos) {
		idGenerator ++;
		id = idGenerator;
		this.edad = edad;
		this.peso = peso;
		this.raza = raza;
		this.macho = macho;
		this.capado = capado;
		this.cantHijos = cantHijos;
	}
	
	@Override
	public int getCantidad() {
		return 1;
	}
	
	@Override
	public int getEdad() {
		return edad;
	}
	
	public double getEdadProm() {
		return edad;
	}

	@Override
	public double getPeso() {
		return peso;
	}
	
	public double getPesoProm() {
		return peso;
	}
	
	public int getId() { 
		return id;
	}
	
	public boolean esMacho() {
		return macho;
	}
	
	public boolean esCapado() {
		return capado;
	}
	
	public int getCantidadHijos() {
		return cantHijos;
	}

	@Override
	public ArrayList<Animal> llenarCamion(int capacidad, CriterioAnimal criterio) {
		ArrayList<Animal> animal = new ArrayList<Animal>();
		
		if ( criterio.cumple(this) )
			animal.add(this);	
		
		return animal;
	}

	public String getRaza() {
		return raza;
	}

	@Override
	public boolean eliminarAnimal(Animal a) {
		return false;
	}

	public boolean equals(Animal animal){
		if (animal.id == this.id){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
}
