package Parcialito;

public class CriterioDuracionMenor implements Criterio {

	private int duracion;
	
	public CriterioDuracionMenor(int duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return duracion > p.getDuracion();
	}

}
