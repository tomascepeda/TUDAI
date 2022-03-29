package practica;

import java.util.ArrayList;

public class Serie implements GrupoContenido{

	private String titulo, descripcion, creador, genero;
	private ArrayList<Temporada> temporadas;
	
	public Serie(String titulo, String descripcion, String creador, String genero) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.creador = creador;
		this.genero = genero;
		temporadas = new ArrayList<Temporada>();
	}
	
	public void addTemporada(Temporada t) {
		temporadas.add(t);
	}
		
	@Override
	public int getTotalEpisodiosVistos() {
		int total = 0;
		for(Temporada i: temporadas) {
			total += i.getTotalEpisodiosVistos();
		}
		return total;
	}
	
	@Override
	public double getPromedioCalificaciones() {
		double cantidad = 0;
		double suma = 0;
		for(Temporada i: temporadas) {
			suma += i.getPromedioCalificaciones();
			cantidad++;
		}	
		return suma / cantidad;
	}
	
	@Override
	public boolean isTodosEpisodiosVistos() {
		boolean vistos = true;
		for(Temporada i: temporadas) {
			if(!i.isTodosEpisodiosVistos()) {
				return false;
			}
		}
		return vistos;
	}
	
}
