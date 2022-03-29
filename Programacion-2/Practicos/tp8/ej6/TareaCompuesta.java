package tp8.ej6;

import java.time.LocalDate;
import java.util.ArrayList;

public class TareaCompuesta extends Tarea {
	
	private ArrayList<Tarea> tareas;

	public TareaCompuesta(String nombre) {
		super(nombre);
		tareas = new ArrayList<Tarea>();
	}
	
	public void addTarea(Tarea t) {
		this.tareas.add(t);
	}

	@Override
	public LocalDate getInicio() {
		if(this.inicio == null)
			this.inicio = tareas.get(0).getInicio();	
		for (Tarea i : tareas) {
			if(i.getInicio().compareTo(inicio) < 0)
				this.inicio = i.getInicio();
		}
		return this.inicio;
	}

	@Override
	public LocalDate getFin() {
		if(this.fin == null)
			this.fin = tareas.get(0).getFin();	
		for (Tarea i : tareas) {
			if(i.getFin().compareTo(fin) > 0)
				this.fin = i.getFin();
		}
		return this.fin;
	}

	@Override
	public ArrayList<Recurso> getRecursos() {
		ArrayList<Recurso> recursosInvolucrados = new ArrayList<Recurso>(); 
		for (Tarea i : tareas) {
			for (Recurso r : i.getRecursos()) {
				if(!recursosInvolucrados.contains(r))
					recursosInvolucrados.add(r);
			}
		}
		return recursosInvolucrados;
	}
	
	public LocalDate getETinicio() {
		if(this.ETinicio == null)
			this.ETinicio = tareas.get(0).getETinicio();	
		for (Tarea i : tareas) {
			if(i.getETinicio().compareTo(ETinicio) < 0)
				this.ETinicio = i.getETinicio();
		}
		return this.ETinicio;
	}

	public LocalDate getETfin() {
		if(this.ETfin == null)
			this.ETfin = tareas.get(0).getETfin();	
		for (Tarea i : tareas) {
			if(i.getETfin().compareTo(ETfin) < 0)
				this.ETfin = i.getETfin();
		}
		return this.ETfin;
	}

}
