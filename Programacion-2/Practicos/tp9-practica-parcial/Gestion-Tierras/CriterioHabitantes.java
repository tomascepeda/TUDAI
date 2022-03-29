package parcial;

public class CriterioHabitantes implements Criterio{

	private int habitantes;
	
	public CriterioHabitantes(int h) {
		habitantes=h;
	}

	@Override
	public boolean cumple(Territorio region) {
		return region.getHabitantes() > habitantes;
	}
	
}
