package E4;

public class Empleado {

	// el id se auto asigna
	private static int numberId = 0;
	private String id = "e";

	@SuppressWarnings("unused")
	private String nombre, apellido;
	@SuppressWarnings("unused")
	private int edad, fuerza;

	public Empleado(String nombre, String apellido, int edad, int fuerza) {
		Empleado.numberId++;
		this.id += Empleado.numberId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fuerza = fuerza;
	}

	public Empleado(int fuerza) {
		Empleado.numberId++;
		this.id += Empleado.numberId;
		this.fuerza = fuerza;
	}

	public String getId() {
		return this.id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public String toString() {
		return id;
	}

}
