package tp8;

public class Persona{
	
	protected String nombre;
	private int dni;
	
	public Persona(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public void votar(Mesa m, Candidato c) {
		Voto v = new Voto(c);
		m.addVoto(this, v);
	}

	public int getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object o) {
		try {
			return ((Persona) o).getDni() == this.getDni();			
		} catch (Exception e) {
			return false;
		}
	}
	
}
