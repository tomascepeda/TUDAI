package practica;

public class Episodio {

	private String titulo, descripcion;
	private boolean visto;
	private int califcacion;
	
	public Episodio(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.visto = false;
		this.califcacion = -1;
	}
	
	public void setCalificacion(int calificacion) {
		if(calificacion>=1 && calificacion<=5) {
			this.califcacion = calificacion;
		}else {
			System.out.println("la calificacion debe ser entre 1 y 5");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVisto() {
		return visto;
	}

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

	public int getCalifcacion() {
		return califcacion;
	}
	
}
