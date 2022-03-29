package E3;

import java.util.HashMap;
import java.util.Iterator;

import P3.*;

public class Mapa {

	private Grafo<Integer> grafo;
	private HashMap<Integer, Ciudad> ciudades;
	private HashMap<Integer, String> colores;
	private Integer bestSolution;

	public Mapa() {
		this.grafo = new GrafoNoDirigido<Integer>();
		this.ciudades = new HashMap<>();
		this.colores = new HashMap<>();
	}

	public void addCiudad(Ciudad ciudad) {
		this.ciudades.put(ciudad.getId(), ciudad);
		this.grafo.agregarVertice(ciudad.getId());
	}

	public void borrarCiudad(Ciudad ciudad) {
		this.ciudades.remove(ciudad.getId());
		this.grafo.borrarVertice(ciudad.getId());
	}

	public void addRuta(Ciudad origen, Ciudad destino, int kilometros) {
		this.grafo.agregarArco(origen.getId(), destino.getId(), kilometros);
	}

	public void borrarRuta(Ciudad origen, Ciudad destino) {
		this.grafo.borrarArco(origen.getId(), destino.getId());
	}

	private void paintVertices() {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
	}

	public Camino encontrarCamino(Ciudad origen, Ciudad destino) {
		if (!this.grafo.contieneVertice(origen.getId()) || !this.grafo.contieneVertice(destino.getId()))
			return null;
		this.paintVertices();
		this.bestSolution = null;
		Camino camino = null;
		if (origen.isTieneBalanza())
			camino = this.encontrarCamino(origen, destino, 0, -1);
		else
			camino = this.encontrarCamino(origen, destino, 0, 0);
		if (bestSolution == null)
			return null;
		camino.setDistancia(bestSolution);
		return camino;
	}

	private Camino encontrarCamino(Ciudad origen, Ciudad destino, int km, int cantBalanzas) {

		Camino camino = new Camino();

		camino.addCiudad(origen.getNombre());
		camino.aumentarDistancia(km);
		camino.aumentarBalanzas(cantBalanzas);
		if (origen.isTieneBalanza())
			camino.aumentarBalanzas(1);
		colores.put(origen.getId(), "amarillo");

		if (origen.getId() == destino.getId()) {
			colores.put(origen.getId(), "blanco");
			bestSolution = km;
			return camino;
		}

		Iterator<Arco<Integer>> it = this.grafo.obtenerArcos(origen.getId());
		Camino solution = new Camino();

		while (it.hasNext()) {
			Arco<Integer> arco = it.next();
			Ciudad newOrigen = this.ciudades.get(arco.getVerticeDestino());
			int cantbal = camino.getCantBalanzas();
			if (newOrigen.isTieneBalanza())
				cantbal += 1;
			if (cantbal < 2) {
				if (colores.get(arco.getVerticeDestino()).equals("blanco")
						&& ((bestSolution == null) || (arco.getEtiqueta() + km <= bestSolution))) {
					Camino caux = encontrarCamino(newOrigen, destino, km + arco.getEtiqueta(), camino.getCantBalanzas());
					if (!caux.getCiudades().isEmpty()) {
						solution = new Camino();
						Ciudad c = this.ciudades.get(arco.getVerticeOrigen());
						solution.addCiudad(c.getNombre());
						solution.addCiudades(caux.getCiudades());
						solution.aumentarBalanzas(caux.getCantBalanzas());
					}
				}
			}
		}

		colores.put(origen.getId(), "blanco");
		return solution;
	}

}