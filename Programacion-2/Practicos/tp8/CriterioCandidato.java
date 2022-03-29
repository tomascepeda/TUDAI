package tp8;

public class CriterioCandidato implements Criterio{

	private Candidato c;
	
	public CriterioCandidato(Candidato c) {
		super();
		this.c = c;
	}

	@Override
	public boolean cumple(Voto v) {
		return v.getCandidato().equals(c);
	}
}
