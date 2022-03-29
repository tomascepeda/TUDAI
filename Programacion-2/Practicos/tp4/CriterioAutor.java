package ej7;

import java.util.ArrayList;

public class CriterioAutor implements Criterio {

	private String autor;
	
	public CriterioAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public boolean cumple(Documento d) {
		ArrayList<String> copia = new ArrayList<String>();
		copia = (ArrayList<String>) d.getAutores().clone();
		for (String i : copia) {
			 if(this.autor.equals(i))
				 return true;
		}
		return false;
	}
}
