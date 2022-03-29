package practico6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteradorConcreto implements Iterator<Integer>{
	private List<Integer> elementos;
	private int inicio,fin,multiplo;
	
	
	private int posicion;
	
	public IteradorConcreto(int inic ,int f, int m) {
		elementos = new ArrayList<Integer>();
		posicion = 0;
		multiplo = m;
		inicio = inic;
		fin = f;
		
		for(int i = inicio; i < fin; i++) {
			if(esMultiplo(i, multiplo)) {
				elementos.add(i);
			}
		}
	}
	
	public boolean esMultiplo(int x, int y) {
		if(x % y == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean hasNext() {
		return posicion < elementos.size();
	}
	@Override
	public Integer next() {
		posicion++;
		return elementos.get(posicion -1);
	}

}