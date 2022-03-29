package tp6;

public class Candidato {

	private String nombre, empresa;
	private float sueldo;
	private Criterio criterio_contrato;
	
	public Candidato(String nombre) {
		this.nombre = nombre;
		this.sueldo = 0;
	}
	
	public Candidato(String nombre, String empresa, float sueldo) {
		super();
		this.nombre = nombre;
		this.empresa = empresa;
		this.sueldo = sueldo;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public void setCriterio_contrato(Criterio criterio) {
		criterio_contrato = criterio;
		criterio_contrato.setCandidato(this);
	}
	
	public boolean esContratable(Contrato contrato) {
		criterio_contrato.setContrato(contrato);
		return criterio_contrato.esContratable();
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public float getSueldo() {
		return sueldo;
	}

}
