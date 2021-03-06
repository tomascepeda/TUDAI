package service.rest.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NamedQueries(value = {
//		Consigna 2:
//		c) recuperar todos los estudiantes, y especificar alg?n criterio de ordenamiento simple.
		// Se seleccionan todos los esdudiantes y se los ordena
		@NamedQuery(name = Estudiante.BUSCAR_TODOS, query = "SELECT DISTINCT e FROM Estudiante e ORDER BY e.nombre"),
//		e) recuperar todos los estudiantes, en base a su g?nero.
		// Se seleccionan todos los estudiantes y se los filtra por un g?nero pasado por
		// par?metro
		@NamedQuery(name = Estudiante.BUSCAR_POR_GENERO, query = "SELECT e FROM Estudiante e WHERE e.genero = :generoPass"),
//		d) recuperar un estudiante, en base a su n?mero de libreta universitaria.
		// Se seleccionan todos los estudiantes en base a un n?mero de libreta pasado
		// por par?metro
		@NamedQuery(name = Estudiante.BUSCAR_POR_NUM_LIBRETA, query = "SELECT e FROM Estudiante e WHERE e.num_libreta = :num_libretaPass"), })
@Entity
public class Estudiante {

	public static final String BUSCAR_TODOS = "Estudiante.buscarTodos";
	public static final String BUSCAR_POR_GENERO = "Estudiante.buscarPorGenero";
	public static final String BUSCAR_POR_NUM_LIBRETA = "Estudiante.buscarPorNumLibreta";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_libreta;

	@Column
	private int num_doc;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column
	private int edad;

	@Column
	private String ciudad_residencia;

	@Transient
//	@OneToMany(mappedBy="estudiante")
	private List<EstudianteCarrera> carreras;

	@Column
	private String genero;

	public Estudiante() {
	}

	public Estudiante(int num_libreta, int num_doc, String nombre, String apellido, int edad, String ciudad_residencia,
			List<EstudianteCarrera> carreras, String genero) {
		super();
		this.num_libreta = num_libreta;
		this.num_doc = num_doc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudad_residencia = ciudad_residencia;
		this.carreras = carreras;
		this.genero = genero;
	}

	public Estudiante(int num_doc, String nombre, String apellido, int edad, String ciudad_residencia, String genero) {
		super();
		this.num_doc = num_doc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudad_residencia = ciudad_residencia;
		this.carreras = new ArrayList<EstudianteCarrera>();
		this.genero = genero;
	}

	public Estudiante(int num_libreta, int num_doc, String nombre, String apellido, int edad, String ciudad_residencia,
			String genero) {
		super();
		this.num_libreta = num_libreta;
		this.num_doc = num_doc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudad_residencia = ciudad_residencia;
		this.carreras = new ArrayList<EstudianteCarrera>();
		;
		this.genero = genero;
	}

	public int getNum_libreta() {
		return num_libreta;
	}

	public void setNum_libreta(int num_libreta) {
		this.num_libreta = num_libreta;
	}

	public int getNum_doc() {
		return num_doc;
	}

	public void setNum_doc(int num_doc) {
		this.num_doc = num_doc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudad_residencia() {
		return ciudad_residencia;
	}

	public void setCiudad_residencia(String ciudad_residencia) {
		this.ciudad_residencia = ciudad_residencia;
	}

	public List<EstudianteCarrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<EstudianteCarrera> carreras) {
		this.carreras = carreras;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Estudiante [num_libreta=" + num_libreta + ", num_doc=" + num_doc + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + ", ciudad_residencia=" + ciudad_residencia + ", genero=" + genero + "]";
	}

}