package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Iterator;

import javax.persistence.*;
import Repository.*;
import Data.*;
import Entities.Estudiante;
import Entities.EstudianteCarrera;
import Entities.Carrera;
/*
 * Consignas:
 * Consigna 1:
 *         Los diagramas se encuentran la carpeta diagramas del mismo proyecto, las entidades se
 *      encuentran en el paquete Entities
 *  Consigna 2 y 3:
 *       Todas las consultas est�n resultas con Named Queries, y se encuentran repartidas entre  
 *       sus respectivas clases. La ejecuci�n de las mismas se lleva a cabo en sus
 *       respectivos repositorios
 * 
 * 
 * 
 * Descripci�n de paquetes:
 * Entities:
 *      Contiene las clases de sql mapeadas a java
 *  Data:
 *       Contiene los datos con los que se cargar� la BBDD
 *  Ropository:
 *       Contiene las clases del patr�n repository
 *  Main:
 *         Contiene el c�digo con el que se instancian las clases y se prueba el mismo
 *
 *
 *
 *  Usuario y contrase�a para la conexi�n a l�a BBDD:
 *      Usuario: "root"
 *      Contrase�a: ""
 * */
import Entities.DTOEstudianteCarrera;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String dataBaseName = "tudai_aweb_tp2_entregable";
		createDataBase(dataBaseName);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();

		EstudianteRepository er = new EstudianteRepository(em);
		CarreraRepository cr = new CarreraRepository(em);
		EstudianteCarreraRepository ecr = new EstudianteCarreraRepository(em);

		em.getTransaction().begin();
		er.addAll(EstudianteData.getEstudiantes());
		cr.addAll(CarreraData.getCarreras());
		em.getTransaction().commit();

		em.getTransaction().begin();
		ecr.addAll(Estudiante_CarreraData.getEstudiante_Carrera(em));
		em.getTransaction().commit();

//		1) Considere el dise�o de un registro de estudiantes, con la siguiente informaci�n: nombres,
//		apellido, edad, g�nero, n�mero de documento, ciudad de residencia, n�mero de libreta
//		universitaria, carrera(s) en la que est� inscripto, antig�edad en cada una de esas carreras, y
//		si se gradu� o no. Dise�ar el diagrama de objetos y el diagrama DER correspondiente.
//		Diagrama de SQL:
//		Diagrama de clases: 
//		Entidades: est�n en el paquete Entity(Estudiante, Carrera, EstudianteCarrera)

		
//		2) Implementar consultas para:

//		a) dar de alta un estudiante
		em.getTransaction().begin();
		Estudiante juan = new Estudiante(2983, 98456782, "Juan", "Juanes", 49, "Olavarria", "Male");
		er.add(juan);
		em.getTransaction().commit();
		
//		b) matricular un estudiante en una carrera
		em.getTransaction().begin();
		Carrera arqui = new Carrera(10001, "Arquitecturas Web");
		cr.add(arqui);
		em.getTransaction().commit();
		em.getTransaction().begin();
		ecr.add(new EstudianteCarrera(juan, arqui, new Timestamp(2000), new Timestamp(2021)));
		em.getTransaction().commit();
		
//		c) recuperar todos los estudiantes, y especificar alg�n criterio de ordenamiento simple.
		System.out.println("\n\nc) recuperar todos los estudiantes, y especificar alg�n criterio de ordenamiento simple.");
		System.out.println(er.getAll());
		
//		d) recuperar un estudiante, en base a su n�mero de libreta universitaria.
		System.out.println("\n\nd) recuperar un estudiante, en base a su n�mero de libreta universitaria.");
		System.out.println(er.getById(juan.getNum_libreta()));
		
//		e) recuperar todos los estudiantes, en base a su g�nero.
		System.out.println("\n\ne) recuperar todos los estudiantes, en base a su g�nero");
		System.out.println(er.getPorGenero("Male"));
		
//		f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
		System.out.println("\n\nf) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.");
		System.out.println(cr.getCarrerasConInscriptos());
		
//		g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
		System.out.println("\n\ng) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.");
		System.out.println(er.getCarrerasPorCarreraCiudad(10001, "Olavarria"));
	
	
//		3) Generar un reporte de las carreras, que para cada carrera incluya informaci�n de los
//		inscriptos y egresados por a�o. Se deben ordenar las carreras alfab�ticamente, y presentar
//		los a�os de manera cronol�gica.

//		esta comentado para poder ver los resultados de arriba (trae muchos registros)
		Iterator<DTOEstudianteCarrera> carreras = cr.getReporteCarreras().iterator();
		while(carreras.hasNext())
			System.out.println(carreras.next());


		em.close();
		emf.close();
	}

	
	// Esta funci�n crea una la BBDD: si existe, la borra, y luego la crea
	public static void createDataBase(String dataBaseName) {
		String existsDatabaseQuery = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = '"
				+ dataBaseName + "'";
		String dropQuery = "DROP DATABASE " + dataBaseName;
		String createQuery = "CREATE DATABASE " + dataBaseName;
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String uri = "jdbc:mysql://localhost:3306/";

		try {
			Connection conn = DriverManager.getConnection(uri, "root", "");
			conn.setAutoCommit(false);
			PreparedStatement ps0 = conn.prepareStatement(existsDatabaseQuery);
			ResultSet rs = ps0.executeQuery();
			if (rs.next()) {
				PreparedStatement ps1 = conn.prepareStatement(dropQuery);
				ps1.executeUpdate();
				conn.commit();
			}
			PreparedStatement ps2 = conn.prepareStatement(createQuery);
			ps2.executeUpdate();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
