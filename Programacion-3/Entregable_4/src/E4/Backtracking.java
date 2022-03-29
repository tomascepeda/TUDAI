package E4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Backtracking {

	private LinkedList<Empleado> empleados;
	private int cantEmpleados;
	private Equipo solucion, tmp;
	private long cantEstados;
	private int fuerzaTotal;

	public Equipo armarGrupos(ArrayList<Empleado> entrada) {
		empleados = new LinkedList<Empleado>();
		solucion = new Equipo();
		tmp = new Equipo();
		cantEstados = 0;
		fuerzaTotal = 0;
		cantEmpleados = entrada.size();
		for (Empleado e : entrada) {
			empleados.add(e);
			fuerzaTotal += e.getFuerza();
		}
		busqueda();
		return solucion;
	}

	private void busqueda() {
		Empleado e = null;
		if (!empleados.isEmpty()) {
			e = empleados.removeFirst();
			if ( 
				!poda()
				) {
				cantEstados++;
				tmp.addEmpleadoG1(e);
				busqueda();
				tmp.removeEmpleadoG1(e);
				tmp.addEmpleadoG2(e);
				busqueda();
				tmp.removeEmpleadoG2(e);
				empleados.add(e);
			}
		} else if (esFinal() && tmp.getDiferencia() < solucion.getDiferencia()) {
			solucion.removeEmpleadosG1(solucion.getG1());
			solucion.removeEmpleadosG2(solucion.getG2());
			solucion.addEmpleadosG1(tmp.getG1());
			solucion.addEmpleadosG2(tmp.getG2());
			cantEstados++;
		}
	}

	private boolean esFinal() {
		return ((tmp.getG1().size() + tmp.getG2().size()) == cantEmpleados);
	}

	public long getCantEstados() {
		return this.cantEstados;
	}

	private boolean poda() {
		if (fuerzaTotal % 2 == 0) {
			if (solucion.getDiferencia() == 0)
				return true;
		} else if (solucion.getDiferencia() == 1)
			return true;
		return false;
	}

}