package P3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class IteradorIteradores<T> implements Iterator<Arco<T>> {

	Iterator<Entry<Integer, Vertice<T>>> it;
	Iterator<Arco<T>> itActual;

	public IteradorIteradores(HashMap<Integer, Vertice<T>> map) {
		it = map.entrySet().iterator();
		if (it.hasNext())
			itActual = it.next().getValue().getArcos();
	}

	@Override
	public boolean hasNext() {
		if (itActual.hasNext())
			return true;
		else {
			if (it.hasNext()) {
				itActual = it.next().getValue().getArcos();
				return hasNext();
			} else
				return false;
		}
	}

	@Override
	public Arco<T> next() {
		return itActual.next();
	}

}
