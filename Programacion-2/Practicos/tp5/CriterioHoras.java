package tp6;

public class CriterioHoras extends Criterio {

	private int horas;
	
	public CriterioHoras(int horas) {
		this.horas = horas;
	}
	
	@Override
	public boolean esContratable() {
		return contrato.getHoras() <= this.horas;
	}
	
}
