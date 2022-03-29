package P3;

import java.util.HashMap;
import java.util.Iterator;

public class Vertice<T> {

	private Integer id;
	private HashMap<Integer, Arco<T>> arcos;

	public Vertice(Integer id) {
		this.id = id;
		this.arcos = new HashMap<>();
	}

	public boolean addArco(Arco<T> arco) {
		if (arco.getVerticeOrigen() == this.id && !this.hasArco(arco.getVerticeDestino())) {
			this.arcos.put(arco.getVerticeDestino(), arco);
			return true;
		}
		return false;
	}

	public boolean removeArco(int verticeId) {
		if (this.hasArco(verticeId)) {
			arcos.remove(verticeId);
			return true;
		}
		return false;
	}

	public boolean borrarArcoConDestinoEliminado(int destino) {
		if (this.arcos.containsKey(destino)) {
			arcos.remove(destino);
			return true;
		}
		return false;
	}

	public boolean hasArco(int verticeId) {
		return arcos.containsKey(verticeId);
	}

	public Arco<T> getArco(int verticeId) {
		if (this.hasArco(verticeId))
			return arcos.get(verticeId);
		return null;
	}

	public Iterator<Arco<T>> getArcos() {
		return arcos.values().iterator();
	}

	public int getCantArcos() {
		return arcos.size();
	}

	public Integer getID() {
		return this.id;
	}

}
