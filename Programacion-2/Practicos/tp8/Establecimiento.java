package tp8;

import java.time.LocalDate;
import java.util.ArrayList;

public class Establecimiento extends SistemaElectoral {
	
	private ArrayList<SistemaElectoral> establecimientos;

	public Establecimiento() {
		this.establecimientos = new ArrayList<SistemaElectoral>();
	}

	public void addEstablecimiento(SistemaElectoral m) {
		establecimientos.add(m);
	}
	
	@Override
	public double getPorcentajeVotos(Criterio c) {
		double cuenta = getVotos(c);
		double cant = 0;
		for (SistemaElectoral i : establecimientos) {
			cant += i.getTotalVotos();
		}
		return cuenta / cant * 100;
	}

	@Override
	protected int getVotos(Criterio c) {
		int cuenta = 0;
		for (SistemaElectoral i : establecimientos) {		
			cuenta += i.getVotos(c);
		}
		return cuenta;
	}

	@Override
	public int getTotalVotos() {
		int cuenta = 0;
		for (SistemaElectoral i : establecimientos) {
			cuenta += i.getTotalVotos();
		}
		return cuenta;
	}


}
