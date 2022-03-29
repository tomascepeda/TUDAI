package tp7.arbol_binario;

import java.util.ArrayList;

public class Nodo extends Estructura implements Comparable<Nodo>{
	
	private int valor;
	private Nodo izq;
	private Nodo der;
	
	public Nodo(int valor) {
		super();
		this.valor = valor;
	}
	
	@Override
	public int compareTo(Nodo n) {
		return this.valor - n.getValor();
	}

	public int getValor() {
		return valor;
	}
	
	@Override
	protected void addNodo(Nodo n) {
		if (this.compareTo(n) > 0) {
			if (izq == null) {
				izq = n;
			}else
				izq.addNodo(n);
		}
		else if (this.compareTo(n) < 0) {
			if (der == null) {
				der = n;				
			}else
				der.addNodo(n);
		}
	}

	public ArrayList<Nodo> ejecutarNodo() {
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		if (izq != null)
			nodos.addAll(izq.ejecutarNodo());
		nodos.add(this);
		if (der != null) 
			nodos.addAll(der.ejecutarNodo());
		return nodos;
	}

	@Override
	public String toString() {
		return valor + " ";
	}
	
	

}
