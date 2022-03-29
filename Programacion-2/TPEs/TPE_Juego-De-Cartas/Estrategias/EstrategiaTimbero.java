package Estrategias;

import java.util.ArrayList;

import Juego.Atributo;
import Juego.Carta;

public class EstrategiaTimbero extends Estrategia {
	
	public EstrategiaTimbero(String nombre) {
		super(nombre);
	}

	@Override
	public String obtenerEstrategia(Carta ca) {
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.addAll(ca.getNombresAtributos()); 
		int max = atributos.size()-1; 
		int min = 0;
		int range = max - min + 1;
		int atributoRamdon = (int) (Math.random()* range)+min;
		return ca.getAtributoNombre(atributoRamdon);
	}

}
