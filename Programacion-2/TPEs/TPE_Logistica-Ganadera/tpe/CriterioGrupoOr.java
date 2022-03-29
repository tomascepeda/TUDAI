package tpe;


public class CriterioGrupoOr implements CriterioGrupo {
	
	private CriterioGrupo c1;
	private CriterioGrupo c2;
	
	public CriterioGrupoOr(CriterioGrupo cr1, CriterioGrupo cr2) {
		c1 = cr1;
		c2 = cr2;
	}
	
	@Override
	public boolean cumple(GrupoAbs eslabon) {
		return c1.cumple(eslabon) || c2.cumple(eslabon);
	}

}
