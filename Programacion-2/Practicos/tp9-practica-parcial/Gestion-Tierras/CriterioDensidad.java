package parcial;

public class CriterioDensidad implements Criterio{
	
	private double densidad;
	
	public CriterioDensidad(double d) {
		densidad = d;
	}

	@Override
	public boolean cumple(Territorio region) {
		return region.getDensidad() > densidad;
	}
}
