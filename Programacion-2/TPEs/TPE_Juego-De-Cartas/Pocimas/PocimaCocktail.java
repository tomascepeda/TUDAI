package Pocimas;

import java.util.ArrayList;

import Juego.Atributo;

public class PocimaCocktail extends Pocima {
	
	private ArrayList<Pocima> pocimas;	

	public PocimaCocktail(String nombre, ArrayList<Pocima> pocimas) {
		super(nombre);
		this.pocimas = pocimas;
	}

	@Override
	public int getValorResultante(Atributo a) {
		Atributo aux = new Atributo(a.getNombre(), a.getValor());
		for (Pocima i : pocimas) {
			aux.setValor(i.getValorResultante(aux));
		}
		return aux.getValor();
	}

}
