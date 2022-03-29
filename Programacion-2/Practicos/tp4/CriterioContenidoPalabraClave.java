package ej7;

public class CriterioContenidoPalabraClave implements Criterio {

	private String palabra;
	
	public CriterioContenidoPalabraClave(String palabra) {
		super();
		this.palabra = palabra;
	}

	@Override
	public boolean cumple(Documento d) {
		return d.getContendido().contains(palabra);
	}
}
