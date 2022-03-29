package parcial;

import java.util.ArrayList;
import java.util.List;

public class Comarca extends Territorio implements Comparable<Comarca>{
	
	private double superficie;
	private int habitantes;
	private double ingresos;
	
	public Comarca(String n, int h, double s, double i) {
		nombre=n;
		habitantes=h;
		superficie=s;
		ingresos=i;
	}

	@Override
	public int getHabitantes() {
		return habitantes;
	}

	@Override
	public double getSuperficie() {
		return superficie;
	}

	@Override
	public double getIngresos() {
		return ingresos;
	}

	@Override
	public int compareTo(Comarca o) {
		return this.getNombre().compareTo(o.getNombre());
	}

	@Override
	public List<Comarca> getListaComarcas(Criterio c) {
		List comarcas = new ArrayList<Comarca>();
		if(c.cumple(this))
			comarcas.add(this);
		return comarcas;
	}

	

}
