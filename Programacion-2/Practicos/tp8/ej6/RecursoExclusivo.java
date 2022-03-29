package tp8.ej6;

import java.time.LocalDate;

public class RecursoExclusivo extends Recurso {
	
	private Tarea tarea;
	private LocalDate inicio, fin;

	public RecursoExclusivo(String nombre) {
		super(nombre);
	}

	public RecursoExclusivo(String nombre, LocalDate inicio, LocalDate fin) {
		super(nombre);
		this.inicio = inicio;
		this.fin = fin;
	}

	public Tarea getTarea() {
		return tarea;
	}

	@Override
	public void addTarea(Tarea t) {
		this.tarea = t;
	}
	
	public void setTiempoParaTarea(LocalDate inicio, LocalDate fin) {
		this.inicio = inicio;
		this.fin = fin;
	}

	@Override
	public boolean isDisponible() {
		if (this.inicio.compareTo(LocalDate.now()) > 0 && this.fin.compareTo(LocalDate.now()) < 0)
			return true;
		else
			return false;
	}

}
