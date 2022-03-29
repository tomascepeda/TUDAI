package Parcialito;

public class CriterioGenero implements Criterio {

	private String genero;
	
	public CriterioGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return p.getGeneros().contains(genero);
	}

}
