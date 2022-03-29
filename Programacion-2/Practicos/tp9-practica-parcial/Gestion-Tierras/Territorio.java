package parcial;

import java.util.List;

public abstract class Territorio {

	protected String nombre;
	
	public abstract int getHabitantes();
	public abstract double getSuperficie();
	public abstract double getIngresos();
	public double getIngresosPerCapita() {
		return getIngresos() / getHabitantes();
	}
	public double getDensidad() {
		return getHabitantes() / getSuperficie();
	}
	public String getNombre() {
		return nombre;
	}
	public abstract List<Comarca> getListaComarcas(Criterio c);	
}
