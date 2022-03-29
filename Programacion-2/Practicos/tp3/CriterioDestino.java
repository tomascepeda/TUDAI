package envios;

public class CriterioDestino implements Criterio {
	
	private String destino;

	public CriterioDestino(String destino) {
		super();
		this.destino = destino;
	}

	@Override
	public boolean cumple(ElementoSP envio) {
		return envio.getDestino().contains(destino);
	}
	
}
