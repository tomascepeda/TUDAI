package procesadores;

public class ProcesadorMemoria extends Procesador {

	@Override
	public boolean esMenor(Tarea t1, Tarea t2) {
	      if( t1.getMemoria()<t2.getMemoria())
	    	  return true;
	      else
	    	  return false;
	} 


}
