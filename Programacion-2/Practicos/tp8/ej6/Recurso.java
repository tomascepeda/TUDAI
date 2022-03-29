package tp8.ej6;

public abstract class Recurso {
	
	protected String nombre;
	
	protected Recurso(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public abstract void addTarea(Tarea t);
	
	public abstract boolean isDisponible();

	@Override
	public String toString() {
		return "Recurso [nombre=" + nombre + "]";
	}
	
}
