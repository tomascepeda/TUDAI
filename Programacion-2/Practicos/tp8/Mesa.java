package tp8;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mesa extends SistemaElectoral{

	private ArrayList<Voto> votos;
	private ArrayList<Persona> padron;
	
	public Mesa() {
		this.padron = new ArrayList<Persona>();
		this.votos = new ArrayList<Voto>();
	}

	public void addVoto(Persona p, Voto v) {
		if(padron.contains(p))
			this.votos.add(v);
	}
	
	public void addVotante(Persona p) {
		this.padron.add(p);
	}
	
	@Override
	public double getPorcentajeVotos(Criterio c) {
		double cuenta = getVotos(c);
		return cuenta / votos.size() * 100;
	}
	
	@Override
	protected int getVotos(Criterio c) {
		int cuenta = 0;
		for (Voto i : votos) {
			if(c.cumple(i))			
				cuenta++;
		}
		return cuenta;
	}
	
	@Override
	public int getTotalVotos() {
		return votos.size();
	}
	
	public ArrayList<Persona> getPadron() {
		return (ArrayList<Persona>) padron.clone();
	}

	public ArrayList<Voto> getVotos() {
		return (ArrayList<Voto>) votos.clone();
	}

}
