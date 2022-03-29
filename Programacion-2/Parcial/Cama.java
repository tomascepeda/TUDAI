import java.util.ArrayList;

public class Cama extends ElementoSIS{
	
	private ArrayList<String> equipamientos;
	private Paciente paciente;
	private Criterio criterio;
	
	public Cama(Criterio criterio) {
		this.equipamientos = new ArrayList<String>();
		this.criterio = criterio;
	}
	
	public Cama(ArrayList<String> equipamientos, Paciente paciente, Criterio criterio) {
		super();
		this.equipamientos = equipamientos;
		this.paciente = paciente;
		this.criterio = criterio;
	}

	public void addEquipamientos(String equipamiento) {
		this.equipamientos.add(equipamiento);
	}
	
	public void addPaciente(Paciente paciente) {
		if(criterio.cumple(paciente))
			this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
	
	public ArrayList<String> getEquipamientos() {
		return (ArrayList<String>) equipamientos.clone();
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public boolean isDisponible() {
		if(this.paciente != null)
			return false;
		else return true;
	}

	@Override
	public ArrayList<Cama> getCamasDisponibles(Paciente p) {
		ArrayList<Cama> camas = new ArrayList<Cama>(); 
		if(this.isDisponible() && criterio.cumple(p))
			camas.add(this);
		return camas;
	}

	@Override
	public ElementoSIS getCamas(Criterio c) {
		if(this.isDisponible() && c.cumple(paciente))
			return new Cama(this.getEquipamientos(), this.getPaciente(), this.getCriterio());
		else return null;
	}

	@Override
	public int getTotalCamas() {
		return 1;
	}

}
