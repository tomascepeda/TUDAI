package envios;

import java.util.ArrayList;

public abstract class ElementoSP {
	
	protected static int id = 0;
	protected int idTracking; 
	
	protected static int getIdTracking() {
		id++;
		return id;
	}
	
	protected abstract void setIdTracking(int id);
	public abstract double getPeso();
	public abstract String getDestinatario();
	public abstract String getRemitente();
	public abstract String getDestino();
	public abstract String getOrigen();
	public abstract ArrayList<ElementoSP> getEnvios();
	
}
