package tp8.ej6;

import java.util.ArrayList;

public class RecursoCompartido extends Recurso {
	
	protected RecursoCompartido(String nombre) {
		super(nombre);
		tareas = new ArrayList<Tarea>();
	}

	private ArrayList<Tarea> tareas;

	@Override
	public void addTarea(Tarea t) {
		this.tareas.add(t);
	}

	@Override
	public boolean isDisponible() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
