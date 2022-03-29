import java.util.ArrayList;

public class Paciente {
	
	private String nombre;
	private int edad;
	private ArrayList<String> lista_sintomas, lista_equipamientos;
	
	public Paciente(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.lista_sintomas = new ArrayList<String>();
		this.lista_equipamientos = new ArrayList<String>();
	}
	
	public void ocuparCama(Cama c) {
		c.addPaciente(this);
	}
	
	public void addSintoma(String sintoma) {
		this.lista_sintomas.add(sintoma);
	}
	
	public void addEquipamientoRequerido(String equipamiento) {
		this.lista_equipamientos.add(equipamiento);
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public ArrayList<String> getLista_sintomas() {
		return (ArrayList<String>) lista_sintomas.clone();
	}

	public ArrayList<String> getLista_equipamientos() {
		return (ArrayList<String>) lista_equipamientos.clone();
	}
	
	

}
