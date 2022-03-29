//default package (shared classes *M-C-S.java) JDK 12.0.1

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		String option;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			System.out.println("Ingrese string para iniciar primera parte: ");
			
			option = entrada.readLine();
			
			Central central = new Central();
			Sucursal sucursal0 = new Sucursal();
			Sucursal sucursal1 = new Sucursal();
			Sucursal sucursal2 = new Sucursal();
			sucursal0.precargarMatriz();
			sucursal1.precargarMatriz();
			sucursal2.precargarMatriz();
			central.agregarSucursal(sucursal0);
			central.agregarSucursal(sucursal1);
			central.agregarSucursal(sucursal2);
			central.listarRed();
			
			System.out.println("Ingrese string para iniciar segunda parte: ");
			
			option = entrada.readLine();
			
			central.configurarProducto(0, 20, 50, 100);
			central.configurarProducto(1, 30, 60, 90);
			central.configurarProducto(2, 30, 150, 200);
			sucursal0.configurarProducto(0, 2, 5, 10);
			sucursal0.configurarProducto(1, 3, 6, 9);
			sucursal0.configurarProducto(2, 3, 12, 20);
			sucursal1.configurarProducto(0, 2, 5, 10);
			sucursal1.configurarProducto(1, 3, 6, 9);
			sucursal1.configurarProducto(2, 3, 12, 20);
			sucursal2.configurarProducto(1, 3, 5, 12);
			sucursal2.configurarProducto(2, 3, 18, 20);
			central.listarRed();
			
			System.out.println("Ingrese string para iniciar tercera parte: ");
			
			option = entrada.readLine();
			
			sucursal0.venderProducto(0, 4);
			sucursal0.venderProducto(1, 2);
			sucursal1.venderProducto(0, 1);
			sucursal2.venderProducto(1, 5);
			sucursal2.venderProducto(2, 15);
			central.listarRed();
			
			System.out.println("Ingrese string para iniciar cuarta parte: ");
			
			option = entrada.readLine();
		
			central.necesitanReposicion();
			central.listarRed();
			
			System.out.println("Ingrese string para iniciar quinta parte: ");
			
			option = entrada.readLine();
		
			central.reponerSucursales();
			central.listarRed();
			
			System.out.println("Ingrese string para iniciar sexta parte: ");
			
			option = entrada.readLine();
		
			central.adquirirProducto(0);
			
			System.out.println("Ingrese string para salir: ");   //5 7
			
			option = entrada.readLine();
			
		}
		catch (Exception exc) {
			System.out.println(exc);
		}
	}//close method
} //close class
