package Pocimas;

import Juego.Atributo;

public class PocimaPorcentaje extends Pocima {

	private int valor;
	
	public PocimaPorcentaje(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public int getValorResultante(Atributo a) {
		int valor_aux = a.getValor();
		return valor_aux + (this.valor * valor_aux / 100);
	}

}
