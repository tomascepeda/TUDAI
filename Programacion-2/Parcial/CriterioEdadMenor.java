
public class CriterioEdadMenor implements Criterio{

	private int edad;
	
	public CriterioEdadMenor(int edad) {
		super();
		this.edad = edad;
	}

	@Override
	public boolean cumple(Paciente p) {
		if(p.getEdad() < edad)
			return true;
		else return false;
	}
	
	

}
