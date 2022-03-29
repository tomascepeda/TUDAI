package practico6;

public class CriterioAño implements Criterio{

	private int año;
	
	public CriterioAño(int año) {
		this.año = año;
	}

	@Override
	public boolean cumple(Libro l) {
		return l.getAño() == año;
	}
}
