package envios;

public class CriterioPesoMenor implements Criterio{
	
	private double peso;

	public CriterioPesoMenor(double peso) {
		super();
		this.peso = peso;
	}

	@Override
	public boolean cumple(ElementoSP envio) {
		return envio.getPeso() < this.peso;
	}

}
