package envios;

import java.util.ArrayList;
import java.util.Collection;

public class Paquete extends ElementoSP{

	private double peso;
	private boolean envioaDomicilio;
	private Persona remitente, destinatario;
		
	public Paquete(double peso, boolean envioaDomicilio) {
		super();
		this.peso = peso;
		this.envioaDomicilio = envioaDomicilio;
		this.setIdTracking();
	}

	public Paquete(double peso, boolean envioaDomicilio, Persona remitente, Persona destinatario) {
		super();
		this.peso = peso;
		this.envioaDomicilio = envioaDomicilio;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.setIdTracking();
	}

	public void setRemitente(String nombre, String direccion) {
		Persona remitente = new Persona(nombre, direccion);
		this.remitente = remitente;
	}

	public void setDestinatario(String nombre, String direccion) {
		Persona destinatario = new Persona(nombre, direccion);
		this.destinatario = destinatario;
	}
	
	public String getOrigen() {
		return remitente.getDireccion();
	}
	
	public String getDestino() {
		return destinatario.getDireccion();
	}

	public String getRemitente() {
		return remitente.getNombre();
	}

	public String getDestinatario() {
		return destinatario.getNombre();
	}

	public double getPeso() {
		return peso;
	}

	public boolean isEnvioaDomicilio() {
		return envioaDomicilio;
	}

	@Override
	protected void setIdTracking(int id) {
		this.idTracking = id;
	}
	
	private void setIdTracking() {
		this.idTracking = super.getIdTracking();
	}

	@Override
	public String toString() {
		return "Paquete [peso=" + peso + ", envioaDomicilio=" + envioaDomicilio + ", remitente=" + remitente.toString()
				+ ", destinatario=" + destinatario.toString() + ", idTracking=" + idTracking + "]";
	}

	@Override
	public ArrayList<ElementoSP> getEnvios() {
		ArrayList<ElementoSP> envio = new ArrayList<ElementoSP>();
		envio.add(this);
		return envio;
	}

}
