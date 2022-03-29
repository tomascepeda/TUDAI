import java.util.ArrayList;

public abstract class ElementoSIS {
	
	public abstract ArrayList<Cama> getCamasDisponibles(Paciente p);
	public abstract ElementoSIS getCamas(Criterio c);
	public abstract int getTotalCamas();

}
