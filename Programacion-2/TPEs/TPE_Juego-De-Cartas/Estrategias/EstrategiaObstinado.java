package Estrategias;

import java.util.ArrayList;

import Juego.Atributo;
import Juego.Carta;

public class EstrategiaObstinado extends Estrategia {
	private String nombreAtributo;

	public EstrategiaObstinado(String nombre, String nombreAtributo) {
		super(nombre);
		this.nombreAtributo = nombreAtributo.toLowerCase();
	}

	@Override
	public String obtenerEstrategia(Carta ca) {
		String atributoSelecionado = this.nombreAtributo;
		return atributoSelecionado;
	}

}
