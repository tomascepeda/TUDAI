package tpe;

public class CriterioGrupoNot implements CriterioGrupo {
	private CriterioGrupo c1;
	
	public CriterioGrupoNot(CriterioGrupo cr1) {
		c1 = cr1;
	}

	@Override
	public boolean cumple(GrupoAbs eslabon) {
		return !c1.cumple(eslabon);
	}
}
