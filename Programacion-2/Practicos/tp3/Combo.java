package envios;

import java.util.ArrayList;

public class Combo extends ElementoSP{
	
	private ArrayList<ElementoSP> envios;
	private Criterio criterio;
	
	public Combo(Criterio c) {
		envios = new ArrayList<ElementoSP>();
		this.criterio = c;
		this.setIdTracking();
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}
	
	public void addEnvio(ElementoSP envio) {
		envio.setIdTracking(this.idTracking);
		envios.add(envio);
	}

	@Override
	protected void setIdTracking(int id) {
		this.idTracking = id;
	}
	
	private void setIdTracking() {
		this.idTracking = super.getIdTracking();
	}

	@Override
	public double getPeso() {
		double peso = 0;
		for (ElementoSP i : envios) {
			peso += i.getPeso();
		}
		return peso;
	}

	@Override
	public String getDestinatario() {
		return envios.get(0).getDestinatario();
	}

	@Override
	public String getRemitente() {
		return envios.get(0).getRemitente();
	}

	@Override
	public String getDestino() {
		return envios.get(0).getDestino();
	}

	@Override
	public String getOrigen() {
		return envios.get(0).getOrigen();
	}
	
	public ArrayList<ElementoSP> getEnvios(){
		ArrayList<ElementoSP> envios = new ArrayList<ElementoSP>();
		for (ElementoSP i : this.envios) {
			if(criterio.cumple(i))
				envios.addAll(i.getEnvios());
		}
		return envios;
	}
	
	public ArrayList<ElementoSP> getEnvios(Criterio criterio){
		ArrayList<ElementoSP> envios = new ArrayList<ElementoSP>();
		for (ElementoSP i : this.envios) {
			if(criterio.cumple(i))
				envios.addAll(i.getEnvios());
		}
		return envios;
	}

	@Override
	public String toString() {
		return "Combo [envios=" + envios.toString() + ", idTracking=" + idTracking + "]";
	}

}
