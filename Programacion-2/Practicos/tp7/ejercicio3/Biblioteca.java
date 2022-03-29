package practico6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
	
	private List<Libro> libros;

	public Biblioteca() {
		libros = new ArrayList<Libro>();
	}
	
	public void addLibro(Libro l) {
		libros.add(l);
	}
	
	public List<Libro> getLista(Criterio c){
		List<Libro> lista = new ArrayList<Libro>();
		for(Libro i : libros) 
			lista.addAll(i.getLista(c));
		Collections.sort(lista);
		return lista;
	}
	
}
