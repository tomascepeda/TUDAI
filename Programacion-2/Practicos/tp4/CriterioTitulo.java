package ej7;

public class CriterioTitulo implements Criterio {

	private String titulo;
	
	public CriterioTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public boolean cumple(Documento d) {
		return d.getTitulo().equals(titulo);
	}
}
