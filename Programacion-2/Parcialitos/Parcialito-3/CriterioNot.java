package Parcialito;

public class CriterioNot implements Criterio {
	
	private Criterio c;
	
	public CriterioNot(Criterio criterio) {
		c = criterio;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return !c.cumple(p);
	}
}
