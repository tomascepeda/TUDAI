
public class CriterioNot implements Criterio{

	private Criterio criterio;
	
	public CriterioNot(Criterio criterio) {
		super();
		this.criterio = criterio;
	}

	@Override
	public boolean cumple(Paciente p) {
		return !criterio.cumple(p);
	}

}
