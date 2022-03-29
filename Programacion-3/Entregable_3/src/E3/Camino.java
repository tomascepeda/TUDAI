package E3;

import java.util.LinkedList;

public class Camino {

	private LinkedList<String> ciudades;
	private int distancia;
	private int balanzas;

	public Camino() {
		this.ciudades = new LinkedList<String>();
		this.distancia = 0;
		this.balanzas = 0;
	}

	// ciudades

	public LinkedList<String> getCiudades() {
		return ciudades;
	}

	public void addCiudad(String ciudad) {
		this.ciudades.add(ciudad);
	}

	public void addCiudades(LinkedList<String> ciudades) {
		this.ciudades.addAll(ciudades);
	}

	// distancia

	public int getDistancia() {
		return distancia;
	}

	public void aumentarDistancia(int distancia) {
		this.distancia += distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	// balanza

	public void aumentarBalanzas(int cant) {
		this.balanzas += cant;
	}

	public int getCantBalanzas() {
		return balanzas;
	}

	@Override
	public String toString() {
		return "Camino optimo entre " + ciudades.getFirst() + " y " + ciudades.getLast() + ": recorrido: " + ciudades
				+ ", distancia total: " + distancia + "km, balanzas: " + balanzas;
	}

}
