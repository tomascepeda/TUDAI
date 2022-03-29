package E4;

import java.util.ArrayList;

public class Equipo {

	private ArrayList<Empleado> grupo1, grupo2;
	private int fuerzaG1, fuerzaG2;

	public Equipo() {
		this.grupo1 = new ArrayList<Empleado>();
		this.grupo2 = new ArrayList<Empleado>();
		this.fuerzaG1 = 0;
		this.fuerzaG2 = 0;
	}

	public int getFuerzaG1() {
		return fuerzaG1;
	}

	public int getFuerzaG2() {
		return fuerzaG2;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Empleado> getG1() {
		return (ArrayList<Empleado>) grupo1.clone();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Empleado> getG2() {
		return (ArrayList<Empleado>) grupo2.clone();
	}

	public void addEmpleadoG1(Empleado e) {
		this.grupo1.add(e);
		this.fuerzaG1 += e.getFuerza();
	}

	public void addEmpleadoG2(Empleado e) {
		this.grupo2.add(e);
		this.fuerzaG2 += e.getFuerza();
	}

	public void removeEmpleadoG1(Empleado e) {
		this.grupo1.remove(e);
		this.fuerzaG1 -= e.getFuerza();
	}

	public void removeEmpleadoG2(Empleado e) {
		this.grupo2.remove(e);
		this.fuerzaG2 -= e.getFuerza();
	}

	public void addEmpleadosG1(ArrayList<Empleado> empleados) {
		for (Empleado e : empleados) {
			this.addEmpleadoG1(e);
		}
	}

	public void addEmpleadosG2(ArrayList<Empleado> empleados) {
		for (Empleado e : empleados) {
			this.addEmpleadoG2(e);
		}
	}

	public void removeEmpleadosG1(ArrayList<Empleado> empleados) {
		for (Empleado e : empleados) {
			this.removeEmpleadoG1(e);
		}
	}

	public void removeEmpleadosG2(ArrayList<Empleado> empleados) {
		for (Empleado e : empleados) {
			this.removeEmpleadoG2(e);
		}
	}

	public int getDiferencia() {
		if (!grupo1.isEmpty() && !grupo2.isEmpty())
			return Math.abs(fuerzaG1 - fuerzaG2);
		else
			return Integer.MAX_VALUE;
	}

	public String toString() {
		return "Grupo 1 = " + grupo1 + " con fuerza de trabajo = " + getFuerzaG1() + " , Grupo 2 = " + grupo2
				+ " con fuerza de trabajo = " + getFuerzaG2();
	}

}
