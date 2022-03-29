package Parcialito;

public class CriterioDuracionMayor implements Criterio {

	private int duracion;
	
	public CriterioDuracionMayor(int duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public boolean cumple(Pelicula p) {
		return duracion < p.getDuracion();
	}
}
