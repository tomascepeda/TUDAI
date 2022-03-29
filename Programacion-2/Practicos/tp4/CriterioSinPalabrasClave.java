package ej7;

public class CriterioSinPalabrasClave implements Criterio{
	
	@Override
	public boolean cumple(Documento d) {
		return d.getPalabras_clave().isEmpty();
	}
}
