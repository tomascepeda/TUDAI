package ej7;

public class CriterioTituloPalabra implements Criterio{

	private String palabra;
	
	public CriterioTituloPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	@Override
	public boolean cumple(Documento d) {
		return d.getTitulo().contains(palabra);
	}
}
