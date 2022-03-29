package parcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Region extends Territorio{

	List<Territorio> regiones;
	
	public Region(String n) {
		nombre=n;
		regiones = new ArrayList<Territorio>();
	}
	
	public void addRegion(Territorio region) {
		regiones.add(region);
	}

	@Override
	public int getHabitantes() {
		int suma = 0;
		for(Territorio i : regiones) {
			suma += i.getHabitantes();
		}
		return suma;
	}

	@Override
	public double getSuperficie() {
		double suma = 0;
		for(Territorio i : regiones) {
			suma += i.getSuperficie();
		}
		return suma;
	}

	@Override
	public double getIngresos() {
		double suma = 0;
		for(Territorio i : regiones) {
			suma += i.getIngresos();
		}
		return suma;
	}

	public List<Comarca> getListaComarcas(Criterio c){
		List comarcas = new ArrayList<Comarca>();
		for(Territorio i : regiones) {
				comarcas.addAll(i.getListaComarcas(c));
		}
		Collections.sort(comarcas);
		return comarcas;
	}

}
