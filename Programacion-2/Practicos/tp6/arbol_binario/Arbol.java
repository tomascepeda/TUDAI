package tp7.arbol_binario;

import java.util.ArrayList;
import java.util.Collections;

public class Arbol extends Estructura{

	private Nodo raiz;
	
	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}
	
	@Override
	public void addNodo(Nodo n) {
		raiz.addNodo(n);
	}
	
	public ArrayList<Nodo> ejecutarNodo() {
		return raiz.ejecutarNodo();
	}
	
	public static void main(String[] args) {
		
		Arbol arbol = new Arbol(new Nodo(4));
		Nodo n1 = new Nodo(7);
		Nodo n2 = new Nodo(4);
		Nodo n3 = new Nodo(2);
		Nodo n4 = new Nodo(5);
		Nodo n5 = new Nodo(9);
		Nodo n6 = new Nodo(1);
		Nodo n7 = new Nodo(10);
		Nodo n8 = new Nodo(6);
		Nodo n9 = new Nodo(3);
		Nodo n10 = new Nodo(8);
		
		arbol.addNodo(n1);
		arbol.addNodo(n4);
		arbol.addNodo(n3);
		arbol.addNodo(n5);
		arbol.addNodo(n2);
		arbol.addNodo(n8);
		arbol.addNodo(n10);
		arbol.addNodo(n6);
		arbol.addNodo(n9);
		arbol.addNodo(n7);
		
		System.out.println(arbol.ejecutarNodo().toString());
		ArrayList<Nodo> aux = new ArrayList<Nodo>();
		aux.addAll(arbol.ejecutarNodo());
		Collections.reverse(aux);
		System.out.println(aux.toString());
		System.out.println("Cantidad de elementos en el arbol: " + aux.size());
	}


}
