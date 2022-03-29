package tp6;

import java.util.ArrayList;

public class Consultora {

	private ArrayList<Candidato> candidatos;
	
	
	public Consultora() {
		candidatos = new ArrayList<Candidato>();
	}
	
	public void addCandidato(Candidato c) {
		candidatos.add(c);
	}
	
	public ArrayList<String> listarCandidatos(Contrato contrato){
		
		ArrayList<String> seleccionados = new ArrayList<String>();
		
		for (Candidato i : candidatos) {
			if(i.esContratable(contrato))
				seleccionados.add(i.getNombre());
		}
	
		return seleccionados;
	}
	
}
