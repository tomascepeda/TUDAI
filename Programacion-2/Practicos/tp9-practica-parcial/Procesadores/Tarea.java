package procesadores;

public class Tarea {
	
	private double prioridad;
	private double memoria;
	private double cpu;
	
	public Tarea(double p, double m, double c) {
		prioridad=p;
		memoria = m;
		cpu = c;
	}

	public double getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(double prioridad) {
		this.prioridad = prioridad;
	}

	public double getMemoria() {
		return memoria;
	}

	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}
	
	public void ejecutar() {
		
		System.out.println("SE ejecuto: "+ cpu + "-" + prioridad +"-" +memoria);
	}

}
