package practico6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContenedorConcreto implements Contenedor {
	private int multiplo,inicio,fin;
	
	public ContenedorConcreto(int i,int f,int m) {
		multiplo = m;
		inicio = i;
		fin = f;
	}

	public Iterator iterator() {
		IteradorConcreto it = new IteradorConcreto(inicio,fin,multiplo);
		return it;
	}

}
