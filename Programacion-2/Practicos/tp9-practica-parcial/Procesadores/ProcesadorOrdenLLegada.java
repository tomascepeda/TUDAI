package procesadores;

public class ProcesadorOrdenLLegada extends Procesador {

	
	public void agregarTarea(Tarea t1) {
		tareas.add(t1);
	}
	
	@Override
	public boolean esMenor(Tarea t1, Tarea t2) {
		
		return false;
	}

	
	public static void main(String[] args) {
		
		ProcesadorOrdenLLegada procesador = new ProcesadorOrdenLLegada();
		
		procesador.agregarTarea(new Tarea(10,10,10));
		
		
		ProcesadorMemoria procesador2 = new ProcesadorMemoria();
		
		procesador2.agregarTarea(new Tarea(220,220,220));
		
	}
	
}
