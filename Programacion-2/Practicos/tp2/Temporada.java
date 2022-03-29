package practica;

import java.util.ArrayList;

public class Temporada implements GrupoContenido{

	private String titulo, descripcion, creador, genero;
	private ArrayList<Episodio> episodios;
	
	public Temporada(String titulo, String descripcion, String creador, String genero) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.creador = creador;
		this.genero = genero;
		episodios = new ArrayList<Episodio>();
	}

	public void addEpisodio(Episodio episodio) {
		episodios.add(episodio);
	}
	
	@Override
	public int getTotalEpisodiosVistos() {
		int total = 0;
		for(Episodio i: episodios) {
			if(i.isVisto()) {
				total++;
			}
		}
		return total;
	}

	@Override
	public double getPromedioCalificaciones() {
		double cantidad = 0;
		double suma = 0;
		for(Episodio i: episodios) {
			int calificacion = i.getCalifcacion();
			if(calificacion != -1) {
				suma += calificacion;
				cantidad++;
			}
		}	
		return suma / cantidad;
	}

	@Override
	public boolean isTodosEpisodiosVistos() {
		boolean vistos = true;
		for(Episodio i: episodios) {
			if(!i.isVisto()) {
				return false;
			}
		}
		return vistos;
	}
	
}
