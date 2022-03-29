package tp8;

import java.time.LocalDate;

public class CriterioHora implements Criterio{

	private LocalDate hora;
	
	public CriterioHora(LocalDate hora) {
		super();
		this.hora = hora;
	}

	@Override
	public boolean cumple(Voto v) {
		// TODO Auto-generated method stub
		return false;
	}

}
