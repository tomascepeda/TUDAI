package tp6;

public class Contrato {

	private int horas;
	private float sueldo;
	private String empresa;
	
	public Contrato(int horas, float sueldo, String empresa) {
		this.horas = horas;
		this.sueldo = sueldo;
		this.empresa = empresa;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
