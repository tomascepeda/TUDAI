package Parcialito;

public class CriterioEstrenoMayor implements Criterio {

	private int estreno;
	
	public CriterioEstrenoMayor(int anio_estreno) {
		estreno = anio_estreno;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return estreno < p.getEstreno();
	}

}
