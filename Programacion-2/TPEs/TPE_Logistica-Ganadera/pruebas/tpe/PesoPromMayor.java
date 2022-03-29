package tpe;

public class PesoPromMayor implements CriterioGrupo {
	private double prom;
	

	public PesoPromMayor(double p) {
		prom = p;
	}


	@Override
	public boolean cumple(GrupoAbs eslabon) {
		return eslabon.getPesoProm() > prom;
	}


}
