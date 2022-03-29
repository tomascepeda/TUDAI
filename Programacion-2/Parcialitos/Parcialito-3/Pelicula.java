package Parcialito;

import java.util.ArrayList;

public class Pelicula {
	
	private String titulo, sinopsis, director;
	private int estreno, edad_minima, duracion;
	private ArrayList<String> generos, actores;
	
	public Pelicula(String titulo, String sinopsis, String director, int estreno, int edad_minima, int duracion) {
		super();
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.director = director;
		this.estreno = estreno;
		this.edad_minima = edad_minima;
		this.duracion = duracion;
		actores = new ArrayList<String>();
		generos = new ArrayList<String>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public String getDirector() {
		return director;
	}

	public int getEstreno() {
		return estreno;
	}

	public int getEdad_minima() {
		return edad_minima;
	}

	public int getDuracion() {
		return duracion;
	}

	public ArrayList<String> getGeneros() {
		return (ArrayList<String>) generos.clone();
	}

	public ArrayList<String> getActores() {
		return (ArrayList<String>) actores.clone();
	}
	
	public void addActor(String a) {
		actores.add(a);
	}
	
	public void addGenero(String a) {
		generos.add(a);
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", sinopsis=" + sinopsis + ", director=" + director + ", estreno="
				+ estreno + ", edad_minima=" + edad_minima + ", duracion=" + duracion + ", generos=" + generos.toString()
				+ ", actores=" + actores.toString() + "]";
	}	
	
}
