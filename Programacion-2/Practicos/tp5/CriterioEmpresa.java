package tp6;

public class CriterioEmpresa extends Criterio {

	@Override
	public boolean esContratable() {
		return candidato.getEmpresa() != contrato.getEmpresa();
	}

}
