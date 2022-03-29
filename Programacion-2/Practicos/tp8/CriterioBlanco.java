package tp8;

public class CriterioBlanco implements Criterio{

	@Override
	public boolean cumple(Voto v) {
		return v.getCandidato() == null;
	}

}
