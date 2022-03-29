
public class Main {

	public static void main(String[] args) {
		
		Paciente p1 = new Paciente("p1", 20);
		p1.addEquipamientoRequerido("respirador");
		p1.addSintoma("covid");
		Paciente p2 = new Paciente("p2", 20);
		p2.addEquipamientoRequerido("monitor");
		p2.addSintoma("covid");
		Paciente p3 = new Paciente("p3", 20);
		p3.addEquipamientoRequerido("respirador");
		p3.addSintoma("covid");
		
		CriterioEquipamiento ce = new CriterioEquipamiento("respirador");
		CriterioEquipamiento ce2 = new CriterioEquipamiento("monitor");
		CriterioSintoma cs = new CriterioSintoma("covid");
		CriterioEdadMenor cem = new CriterioEdadMenor(70); //para mayor hay que negarlo con CriteroNot
		CriterioNot cnot = new CriterioNot(cem);
		CriterioAnd cand = new CriterioAnd(ce, ce2);
		CriterioOr cor = new CriterioOr(cs, ce2);
		
		Cama c1 = new Cama(ce);
		Cama c2 = new Cama(ce);
		Cama c3 = new Cama(ce);
		
		c1.addEquipamientos("respirador");
		c1.addPaciente(p1); 
		c3.addPaciente(p2);

		EstablecimientoSanitario e1 = new EstablecimientoSanitario();
		e1.addEstablecimiento(c1);
		e1.addEstablecimiento(c2);
		e1.addEstablecimiento(c3); //solo 1 disponible
		
		System.out.println(e1.getCamas(ce));
		System.out.println(e1.getTotalCamas());
		
		System.out.println(e1.getCamasDisponibles(p2));
	
	}

}
