package parcial;

public class CriterioNombre implements Criterio {
	
	private String nombre;
	
	public CriterioNombre(String n) {
		nombre = n;
	}

	@Override
	public boolean cumple(Territorio region) {
		return region.getNombre() == nombre;
	}
}
