package envios;

public class CriterioRemitente implements Criterio {

	private String remitente;
	
	public CriterioRemitente(String remitente) {
		super();
		this.remitente = remitente;
	}

	@Override
	public boolean cumple(ElementoSP envio) {
		return envio.getRemitente().equals(remitente);
	}

}
