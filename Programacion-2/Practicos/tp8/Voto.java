package tp8;

import java.time.LocalDate;

public class Voto{
	
	private Candidato candidato;
	private LocalDate hora;
	
	public Voto() {
		candidato = null;
		hora = LocalDate.now();
	}

	public Voto(Candidato candidato) {
		this();
		this.candidato = candidato;
	}

	public Candidato getCandidato() {
		return candidato;
	}

}
