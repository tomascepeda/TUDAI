package Juego;

import java.util.ArrayList;
import Pocimas.Pocima;

public class Carta {
	
	private String nombre;
	private ArrayList<Atributo> atributos;
	private Pocima pocima;
	
	public Carta(String nombre) {
		super();
		this.nombre = nombre;
		atributos = new ArrayList<Atributo>();
		this.pocima = null;
	}
	
	public Carta(String nombre, ArrayList<Atributo> atributos, Pocima pocima) {
		this.nombre = nombre;
		this.atributos = atributos;
		this.pocima = pocima;
	}
	
	public void setPocima(Pocima p) {
		this.pocima = p;
	}
	
	public Pocima getPocima() {
		return this.pocima;
	}
	
	public int getValor(String nombreAtributo) {
		if(this.pocima == null)
			return this.getValorOriginal(nombreAtributo);
		else
			return this.getValorModificado(nombreAtributo);
	}
	
	private int getValorOriginal(String nombreAtributo) {
		int valor = 0;
		for (Atributo atributo : atributos) {
			if(atributo.getNombre().equals(nombreAtributo))
				valor = atributo.getValor();
		}
		return valor;
	}
	
	private int getValorModificado(String nombreAtributo) {
		int valor = 0;
		for (Atributo atributo : atributos) {
			if(atributo.getNombre().equals(nombreAtributo) && pocima != null)
				valor = pocima.getValorResultante(atributo);
		}
		return valor;
	}
	
	//dado el nombre retorna el objeto
	public Atributo getAtributoObj(String nombreAtributo) {
		for (Atributo i : atributos) {
			if(i.getNombre().equals(nombreAtributo))
				return i;
		}
		return null;
	}

	public void addAtributo(Atributo a) {
		atributos.add(a);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getAtributoNombre(int index) {
		return this.atributos.get(index).getNombre();
	}

	public ArrayList<Atributo> getAtributos(){
		return (ArrayList<Atributo>) atributos.clone();
	}
	
	@Override
	public boolean equals(Object o) {
		ArrayList<Atributo> atributos_aux = ((Carta) o).getAtributos();
		if (this.getNombre().equals(((Carta) o).getNombre()) && this.atributos.containsAll(atributos_aux))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Carta nombre=" + nombre + ", atributos=" + atributos;
	}
	
	public boolean tieneAtributos(Carta c) {
		return this.getNombresAtributos().containsAll(c.getNombresAtributos());
	}
	
	public ArrayList<String> getNombresAtributos(){
		ArrayList<String> aux = new ArrayList<String>();
		for (Atributo i : atributos) {
			aux.add(i.getNombre());
		}
		return aux;
	}
	
	public String getLog(String nombreAtributo) {
		String log = "" + this.getValorOriginal(nombreAtributo);
		if(this.pocima != null) {
			log += ", se aplico pocima " + pocima.getNombre() +  " valor resultante " + this.getValorModificado(nombreAtributo);
		}
		return log;
	}
	
}//class
