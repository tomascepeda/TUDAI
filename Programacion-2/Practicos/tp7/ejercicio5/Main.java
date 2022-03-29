package practico6;

import java.util.Iterator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		Arbol a = new Arbol(5);
		
		Nodo n1 = new Nodo(4);
		Nodo n2 = new Nodo(6);
		Nodo n3 = new Nodo(2);
		Nodo n4 = new Nodo(7);
		Nodo n5 = new Nodo(8);
		Nodo n6 = new Nodo(1);
		
		a.addNodo(n1);
		a.addNodo(n2);
		a.addNodo(n3);
		a.addNodo(n4);
		a.addNodo(n5);
		a.addNodo(n6);
		
		a.imprimir();

	}

}
