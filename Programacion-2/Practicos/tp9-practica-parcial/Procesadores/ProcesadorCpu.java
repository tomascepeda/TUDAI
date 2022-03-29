package procesadores;

public class ProcesadorCpu extends Procesador {

	@Override
	public boolean esMenor(Tarea t1, Tarea t2) {
	     return  t1.getCpu()<t2.getCpu();
		} 

}
