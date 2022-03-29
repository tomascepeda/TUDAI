package procesadores;

import java.util.Vector;

public abstract class Procesador {

	protected Vector<Tarea> tareas;
	
	

	public Procesador() {
		tareas = new Vector<Tarea>();
	}
	
	public void agregarTarea(Tarea tDada) {
		boolean encontro = false;
		int i = 0;
		while(i<tareas.size() && !encontro) {
			
			Tarea subi = tareas.elementAt(i);
			if (this.esMenor(subi,tDada)) { // DISTINTO POR HIJO
				tareas.insertElementAt(tDada, i);
				encontro = true;
			}
				
		}
		
		if (!encontro) {
			tareas.add(tDada);
		}
	};
	
	public abstract boolean esMenor(Tarea t1,Tarea t2);
	
	public void ejecutarTarea() {
		
		if(tareas.size()>0) {
			Tarea primera = tareas.elementAt(0);
			primera.ejecutar();
			/// tareas.elementAt(0).ejecutar(); ES LO MISMO
			
	    	tareas.removeElementAt(0);
		
		}
		
	}
	
	
}
