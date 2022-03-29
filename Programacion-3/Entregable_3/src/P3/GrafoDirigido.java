package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {

	protected HashMap<Integer, Vertice<T>> vertices;
	protected int cantArcos;

	public GrafoDirigido() {
		vertices = new HashMap<>();
		cantArcos = 0;
	}

	// complejidad O(1)
	@Override
	public void agregarVertice(int verticeId) {
		if (!this.contieneVertice(verticeId))
			vertices.put(verticeId, new Vertice<T>(verticeId));
	}

	// complejidad O(v) siendo v la cantidad de vertices del grafo
	@Override
	public void borrarVertice(int verticeId) {
		if (this.contieneVertice(verticeId)) {
			for (Entry<Integer, Vertice<T>> vertice : vertices.entrySet()) { // O(v)
				if (vertice.getValue().borrarArcoConDestinoEliminado(verticeId)) // O(1)
					this.cantArcos--;
			}
			this.cantArcos -= vertices.get(verticeId).getCantArcos(); // O(1)
			vertices.remove(verticeId);
		}
	}

	// complejidad O(1)
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			if(vertices.get(verticeId1).addArco(new Arco<T>(verticeId1, verticeId2, etiqueta))); // O(1)
				cantArcos++;
		}
	}

	// complejidad O(1)
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
			if (vertices.get(verticeId1).removeArco(verticeId2)) // O(1)
				cantArcos--;
		}
	}

	// complejidad O(1)
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	// complejidad O(1)
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2))
			return vertices.get(verticeId1).hasArco(verticeId2); // O(1)
		return false;
	}

	// complejidad O(1)
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2))
			return vertices.get(verticeId1).getArco(verticeId2); // O(1)
		return null;
	}

	// complejidad O(1)
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	// complejidad O(1)
	@Override
	public int cantidadArcos() {
		return cantArcos;
	}

	// complejidad O(1)
	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	// complejidad O(1)
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if (vertices.containsKey(verticeId))
			return new IteradorArcos<T>(vertices.get(verticeId).getArcos()); // O(1)
		return new ArrayList<Integer>().iterator();
	}

	// complejidad O(1)
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		return new IteradorIteradores<T>(vertices); // O(1)
	}

	// complejidad O(1)
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if (vertices.containsKey(verticeId))
			return vertices.get(verticeId).getArcos(); // O(1)
		return new ArrayList<Arco<T>>().iterator();
	}

}
