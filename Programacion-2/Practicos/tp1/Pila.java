package tp5;

import java.util.*;

public class Pila {

	private ArrayList<Object> elementos;
	
	public Pila() {
		elementos = new ArrayList<Object>();
	}
	
	public void push(Object o) {
		elementos.add(o);
	}
	
	public Object pop() {
		Object aux = elementos.get(elementos.size() - 1);
		elementos.remove(elementos.size() - 1);
		return aux;
	}
	
	public Object top() {
		Object aux = elementos.get(elementos.size() - 1);
		return aux;
	}
	
	public int size() {
		return elementos.size();
	}
	
	public ArrayList<Object> copy()	{
		ArrayList<Object> copia = new ArrayList<Object>();
		copia = (ArrayList<Object>) elementos.clone();
		return copia;
	}
	
	public ArrayList<Object> reverse()	{
		ArrayList<Object> copia = new ArrayList<Object>();
		for(int i = elementos.size() - 1; i >= 0; i--) {
			copia.add(elementos.get(i));
		}
		return copia;
	}
	
}
