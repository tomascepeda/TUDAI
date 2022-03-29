import java.util.ArrayList;

public class EstablecimientoSanitario extends ElementoSIS{
	
	private ArrayList<ElementoSIS> establecimientos;

	public EstablecimientoSanitario() {
		establecimientos = new ArrayList<ElementoSIS>();
	}
	
	public void addEstablecimiento(ElementoSIS e) {
		if(e != null)
			this.establecimientos.add(e);
	}
	
	private ArrayList<ElementoSIS> getEstablecimientos(){
		return (ArrayList<ElementoSIS>) establecimientos.clone();
	}

	@Override
	public ArrayList<Cama> getCamasDisponibles(Paciente p) {
		ArrayList<Cama> camas = new ArrayList<Cama>(); 
		for (ElementoSIS i : establecimientos) {
			camas.addAll(i.getCamasDisponibles(p));
		}
		return camas;
	}

	@Override
	public ElementoSIS getCamas(Criterio c) {
		if(this.establecimientos.isEmpty())
			return null;
		EstablecimientoSanitario copia = new EstablecimientoSanitario();		
		for (ElementoSIS i : establecimientos) {
			if(i.getCamas(c) != null) {
				copia.addEstablecimiento(i.getCamas(c));
			}
		}
		if(!copia.getEstablecimientos().isEmpty())
			return copia;
		else return null;
	}

	@Override
	public int getTotalCamas() {
		if(this.getEstablecimientos().isEmpty())
			return 0;
		int total = 0;
		for (ElementoSIS i : establecimientos) {
			total += i.getTotalCamas();
		}
		return total;
	}
	
}
