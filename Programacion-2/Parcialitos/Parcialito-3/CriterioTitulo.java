package Parcialito;

public class CriterioTitulo implements Criterio {

	private String palabra;
	
	public CriterioTitulo(String palabra_clave) {
		palabra = palabra_clave;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return p.getTitulo().contains(palabra);
	}

}
