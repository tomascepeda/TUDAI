package Pocimas;

import Juego.Atributo;

public class PocimaValorFijo extends Pocima{
	
	private int valor;
	
	public PocimaValorFijo(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public int getValorResultante(Atributo a) {
		return this.valor;
	}
}
