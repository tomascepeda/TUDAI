package Pocimas;

import Juego.Atributo;

public class PocimaSelectiva extends PocimaPorcentaje {

	private String atributo;
	
	public PocimaSelectiva(String nombre, String atributo, int valor) {
		super(nombre, valor);
		this.atributo = atributo;
	}

	@Override
	public int getValorResultante(Atributo a) {
		if(a.getNombre().equals(this.atributo))
			return super.getValorResultante(a);
		else return a.getValor();
	}

}
