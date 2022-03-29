package tpe;

public class EdadPromMayor implements CriterioGrupo {
	private int edad;

	public EdadPromMayor(int e) {
		edad = e;
	}

	@Override
	public boolean cumple(GrupoAbs eslabon) {
		return eslabon.getEdadProm() > edad;
	}

}
