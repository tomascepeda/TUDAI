package Parcialito;

public class CriterioEstrenoMenor implements Criterio {

	private int estreno;
	
	public CriterioEstrenoMenor(int anio_estreno) {
		estreno = anio_estreno;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return estreno > p.getEstreno();
	}

}
