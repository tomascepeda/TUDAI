package tp8.ej6;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Tarea {
	
	protected String nombre, estado;
	protected LocalDate inicio, fin, ETinicio, ETfin;
	
	public Tarea(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public abstract LocalDate getInicio(); 
	public abstract LocalDate getFin();
	public abstract ArrayList<Recurso> getRecursos();
	
	public String getEstado() {
		if(this.getInicio().compareTo(LocalDate.now()) > 0)
			return "en espera";
		else if(this.getInicio().compareTo(LocalDate.now()) < 0 && this.getFin().compareTo(LocalDate.now()) > 0)
			return "en proceso";
		else return "completa";
	}
	
	public void setETinicio(LocalDate eTinicio) {
		ETinicio = eTinicio;
	}
	
	public void setETfin(LocalDate eTfin) {
		ETfin = eTfin;
	}
	
	public LocalDate getETinicio() {
		return ETinicio;
	}

	public LocalDate getETfin() {
		return ETfin;
	}
	
	public Period getDuracion() {
		Period period = Period.between(this.getETinicio(), this.getETfin());
		return period;
	}

}
