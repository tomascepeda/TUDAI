package parcial;

public class CriterioNot implements Criterio{

	private Criterio c1;
	
	public CriterioNot(Criterio cc1) {
		c1 = cc1;
	}

	@Override
	public boolean cumple(Territorio region) {
		return !c1.cumple(region);
	}
}
