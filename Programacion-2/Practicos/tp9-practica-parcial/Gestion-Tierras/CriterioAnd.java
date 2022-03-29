package parcial;

public class CriterioAnd implements Criterio{

	private Criterio c1;
	private Criterio c2;
	
	public CriterioAnd(Criterio cc1, Criterio cc2) {
		c1 = cc1;
		c2 = cc2;
	}
	
	@Override
	public boolean cumple(Territorio region) {
		return c1.cumple(region) && c2.cumple(region);
	}
}
