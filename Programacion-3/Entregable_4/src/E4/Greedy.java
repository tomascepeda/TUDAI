package E4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Greedy {

	private ArrayList<Empleado> empleados;
	private int cantCandidatos;

	@SuppressWarnings("unchecked")
	public Equipo armarGrupos(ArrayList<Empleado> entrada) {
		this.cantCandidatos = 0;
		this.empleados = (ArrayList<Empleado>) entrada.clone();

		// ordeno el arreglo de mayor fuerza a menor
		Collections.sort(empleados, new Comparator<Empleado>() {
			@SuppressWarnings("deprecation")
			@Override
			public int compare(Empleado e1, Empleado e2) {
				return new Integer(e2.getFuerza()).compareTo(new Integer(e1.getFuerza()));
			}
		});

		return generarGrupos();
	}

	private Equipo generarGrupos() {

		Equipo solucion = new Equipo();

		while (!empleados.isEmpty()) {
			Empleado e = seleccionar();
			empleados.remove(e);
			if (evaluarGrupo(solucion, e))
				solucion.addEmpleadoG1(e);
			else
				solucion.addEmpleadoG2(e);
		}

		return solucion;
	}

	private boolean evaluarGrupo(Equipo solucion, Empleado e) {

		int fuerza1 = solucion.getFuerzaG1() + e.getFuerza();
		int fuerza2 = solucion.getFuerzaG2() + e.getFuerza();

		int diff1 = Math.abs(fuerza1 - solucion.getFuerzaG2());
		int diff2 = Math.abs(fuerza2 - solucion.getFuerzaG1());

		if (diff1 < diff2)
			return true; // añadirlo al grupo 1
		else
			return false; // añadirlo al grupo 2
	}

	private Empleado seleccionar() {
		cantCandidatos++;
		return empleados.get(0);
	}

	public int getCantCandidatos() {
		return this.cantCandidatos;
	}

}
