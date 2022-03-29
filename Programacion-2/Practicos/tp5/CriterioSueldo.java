package tp6;

public class CriterioSueldo extends Criterio {

	@Override
	public boolean esContratable() {
		return contrato.getSueldo() >= candidato.getSueldo();
	}

}
