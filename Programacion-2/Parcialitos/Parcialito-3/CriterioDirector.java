package Parcialito;

public class CriterioDirector implements Criterio {

	private String director;
	
	public CriterioDirector(String director) {
		this.director = director;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return p.getDirector().equals(director);
	}

}
