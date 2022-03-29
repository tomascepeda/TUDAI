package practico6;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Comparable<Libro>{

	private static int id = -1;
	
	private int isbn;
	private int año;
	private String autor;
	private String genero;
	
	public Libro(int año, String autor, String genero) {
		isbn=id++;
		this.año=año;
		this.autor=autor;
		this.genero=genero;
		id++;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getAño() {
		return año;
	}
	
	public String getGenero(){
		return genero;
	}
	
	public List<Libro> getLista(Criterio c){
		List<Libro> lista = new ArrayList<Libro>();
		if(c.cumple(this))
			lista.add(this);
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int compareTo(Libro o) {
		if (this.getIsbn() == o.getIsbn())
			return 0;
		else
			if(this.getIsbn() > o.getIsbn())
				return 1;
			else
				return -1;
	}

}
