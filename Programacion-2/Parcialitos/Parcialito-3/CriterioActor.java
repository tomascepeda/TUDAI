package Parcialito;

public class CriterioActor implements Criterio {

	private String actor;
	
	public CriterioActor(String actor) {
		this.actor = actor;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return p.getActores().contains(actor);
	}

}
