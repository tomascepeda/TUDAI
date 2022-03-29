package P3;

import java.util.Iterator;

public class IteradorArcos<T> implements Iterator<Integer> {
	
	Iterator<Arco<T>> it;
	
	public IteradorArcos(Iterator<Arco<T>> iterador) {
		this.it = iterador;
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Integer next() {
		return it.next().getVerticeDestino();
	}

}
