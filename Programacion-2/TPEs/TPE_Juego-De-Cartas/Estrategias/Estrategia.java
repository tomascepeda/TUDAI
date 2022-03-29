package Estrategias;

import Juego.Carta;

public abstract class Estrategia {
	
	private String nombre;
	
	public Estrategia(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public abstract String obtenerEstrategia(Carta ca);
	
}
