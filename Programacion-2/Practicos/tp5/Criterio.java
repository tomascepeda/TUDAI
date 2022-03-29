package tp6;

public abstract class Criterio {

	protected Candidato candidato;
	protected Contrato contrato;
	
	public void setContrato(Contrato cc) {
		contrato = cc;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public abstract boolean esContratable();
	
}
