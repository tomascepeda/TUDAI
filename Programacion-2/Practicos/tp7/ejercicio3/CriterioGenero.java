package practico6;

public class CriterioGenero implements Criterio{

	private String genero;
	
	public CriterioGenero(String genero) {
		this.genero=genero;
	}

	@Override
	public boolean cumple(Libro l) {
		return l.getGenero().equals(genero);
	}
	
}
