
public class CriterioSintoma implements Criterio{

	private String sintoma;
	
	public CriterioSintoma(String sintoma) {
		super();
		this.sintoma = sintoma;
	}

	@Override
	public boolean cumple(Paciente p) {
		if(p.getLista_sintomas().contains(sintoma))
			return true;
		else return false;
	}

}
