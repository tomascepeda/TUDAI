package ej7;

import java.util.StringTokenizer;

public class CriterioContenidoCantPalabras implements Criterio {

	private int cant;
	
	public CriterioContenidoCantPalabras(int cant) {
		this.cant = cant;
	}

	@Override
	public boolean cumple(Documento d) {
		StringTokenizer stringTokenizer = new StringTokenizer(d.getContendido(), " ");
		return stringTokenizer.countTokens() >= cant;
	}

}
