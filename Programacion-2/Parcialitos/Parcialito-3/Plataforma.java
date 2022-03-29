package Parcialito;

import java.util.ArrayList;

public class Plataforma {
	
	private ArrayList<Pelicula> peliculas;
	
	public Plataforma() {
		peliculas = new ArrayList<Pelicula>();
	}
	
	public ArrayList<Pelicula>buscarPeliculas(Criterio c){
		ArrayList<Pelicula> aux = new ArrayList<Pelicula>();
		for (Pelicula i : peliculas) {
			if(c.cumple(i))
				aux.add(i);		
		}
		return aux;
	}
	public void addPelicula(Pelicula p) {
		peliculas.add(p);
	}
	
	public boolean isRentable(Pelicula p, Criterio c) {
		return c.cumple(p);
	}

}
