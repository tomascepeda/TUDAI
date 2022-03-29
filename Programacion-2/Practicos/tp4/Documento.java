package ej7;

import java.util.ArrayList;

public class Documento {
	
	private String titulo, contendido;
	private ArrayList<String> autores, palabras_clave;
	
	public Documento(String titulo, String contendido) {
		this.titulo = titulo;
		this.contendido = contendido;
		autores = new ArrayList<String>(); 
		palabras_clave = new ArrayList<String>();
	}
	
	public void addAutor(String autor) {
		autores.add(autor);
	}
	
	public void addPalabraClave(String palabra) {
		palabras_clave.add(palabra);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getContendido() {
		return contendido;
	}

	public ArrayList<String> getAutores() {
		ArrayList<String> copia = new ArrayList<String>();
		copia = (ArrayList<String>) autores.clone();
		return copia;
	}

	public ArrayList<String> getPalabras_clave() {
		ArrayList<String> copia = new ArrayList<String>();
		copia = (ArrayList<String>) palabras_clave.clone();
		return copia;
	}
	
}
