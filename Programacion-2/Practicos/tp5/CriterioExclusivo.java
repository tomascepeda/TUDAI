package tp6;

public class CriterioExclusivo extends Criterio{

	@Override
	public boolean esContratable() {
		return candidato.getEmpresa() == null;
	}

}
