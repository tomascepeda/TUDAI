package practica;

import java.sql.Date;

public class Persona {

	private int dni, edad;
	private String nombre, apellido, sexo;
	private Date nacimiento;
	private double peso, altura;
	
	public Persona(int dni) {
		super();
		this.dni = dni;
		nacimiento = new Date(2000, 01, 01);
		sexo = "femenino";
		nombre = "n";
		apellido = "n";
		peso = 1;
		altura = 1;
	}
	
	//constructores

	public Persona(int dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Persona(int dni, String nombre, String apellido, Date nacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
	}

	public Persona(int dni, int edad, String nombre, String apellido, String sexo, Date nacimiento,
			double peso, double altura) {
		super();
		this.dni = dni;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacimiento = nacimiento;
		this.peso = peso;
		this.altura = altura;
	}
	
	//metodos
	
	public double getImc() {
		return peso / (altura*altura);
	}
	
	public boolean enForma() {
		double imc = getImc();
		if((imc >= 18.5) && (imc <=25)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cumpleAños() {
		return false;
	}
	
	public boolean mayorDeEdad() {
		if(edad>=18) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean puedeVotar() {
		if(edad>16) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esCoherente() {
		return false;
	}
	
	public String getInfo() {
		return "nombre: " + nombre + " apellido: " + apellido + " dni: " + dni + " edad: " + edad + " sexo: " + sexo + " fecha de nacimiento: " 
				+ nacimiento + " peso: " + peso + " altura: " + altura;
	}
	
	//seters

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}// class
