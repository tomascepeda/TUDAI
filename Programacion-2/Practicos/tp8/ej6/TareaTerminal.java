package tp8.ej6;

import java.time.LocalDate;
import java.util.ArrayList;

public class TareaTerminal extends Tarea {

	protected ArrayList<Recurso> recursos;
	
	public TareaTerminal(String nombre) {
		super(nombre);
		recursos = new ArrayList<Recurso>();
	}

	public void addRecurso(Recurso r) {
		if(r.isDisponible()) {
			this.recursos.add(r);
			r.addTarea(this);
		}
	}
	
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;	
	}

	@Override
	public LocalDate getInicio() {
		return this.inicio;
	}

	@Override
	public LocalDate getFin() {
		return this.fin;
	}

	@Override
	public ArrayList<Recurso> getRecursos() {
		ArrayList<Recurso> recursosInvolucrados = new ArrayList<Recurso>(); 
		for (Recurso i : recursos) {
			if(!recursosInvolucrados.contains(i))
				recursosInvolucrados.add(i);
		}
		return recursosInvolucrados;
	}

}
