package practico6;

public class CriterioAutor implements Criterio{
	
	private String autor;
	
	public CriterioAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public boolean cumple(Libro l) {
		return l.getAutor() == autor;
	}

}
