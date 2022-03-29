
public class CriterioEquipamiento implements Criterio{
	
	private String equipamiento;

	public CriterioEquipamiento(String equipamiento) {
		super();
		this.equipamiento = equipamiento;
	}

	@Override
	public boolean cumple(Paciente p) {
		if(p.getLista_equipamientos().contains(equipamiento))
			return true;
		else
			return false;
	}

}
