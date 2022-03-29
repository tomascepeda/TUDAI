package tp8;

import java.util.ArrayList;

public class Candidato extends Persona {

	private String patrido_politico, agrupacion;
	private static ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
	
	public Candidato(String nombre, int dni, String patrido_politico, String agrupacion) {
		super(nombre, dni);
		this.patrido_politico = patrido_politico;
		this.agrupacion = agrupacion;
		candidatos.add(this);
	}

	@Override
	public boolean equals(Object o) {
		try {
			return ((Candidato) o).getNombre().equals(this.getNombre()) 
					&& ((Candidato) o).getPatrido_politico().equals(this.getPatrido_politico())
					&& ((Candidato) o).getAgrupacion().equals(this.getAgrupacion());		
		} catch (Exception e) {
			return false;
		}
	}

	public String getPatrido_politico() {
		return patrido_politico;
	}

	public String getAgrupacion() {
		return agrupacion;
	}
	
	public static ArrayList<Candidato> getCandidatos(){
		return (ArrayList<Candidato>) candidatos.clone();
	}

	@Override
	public String toString() {
		return "Candidato [nombre=" + this.nombre + "]";
	}

}
