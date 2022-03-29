package practico6;

import java.util.Iterator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		Biblioteca b = new Biblioteca();
		
		Libro l1 = new Libro(2000, "juan", "terror");
		Libro l2 = new Libro(2010, "jose", "drama");
		Libro l3 = new Libro(2019, "jorge", "terror");
		Libro l4 = new Libro(2000, "juan", "terror");
		Libro l5 = new Libro(2000, "jorge", "aventura");
		Libro l6 = new Libro(2000, "jorge", "aventura");
		
		b.addLibro(l1);
		b.addLibro(l2);
		b.addLibro(l3);
		b.addLibro(l4);
		b.addLibro(l5);
		b.addLibro(l6);
		
		CriterioAutor autor = new CriterioAutor("jorge");
		CriterioAño año = new CriterioAño(2000);
		CriterioGenero genero = new CriterioGenero("terror");
		
		System.out.println(b.getLista(autor));
		System.out.println(b.getLista(año));
		System.out.println(b.getLista(genero));
		
	}

}
