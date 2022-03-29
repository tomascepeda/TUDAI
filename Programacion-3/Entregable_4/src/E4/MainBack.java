package E4;

import java.util.ArrayList;

public class MainBack {

	public static void main(String[] args) {
		
		// empleados

		Empleado e1 = new Empleado(48);
		Empleado e2 = new Empleado(57);
		Empleado e3 = new Empleado(51);
		Empleado e4 = new Empleado(73);
		Empleado e5 = new Empleado(15);
		Empleado e6 = new Empleado(33);
		Empleado e7 = new Empleado(92);
		Empleado e8 = new Empleado(71);
		Empleado e9 = new Empleado(19);
		Empleado e10 = new Empleado(22);
		Empleado e11 = new Empleado(41);
		Empleado e12 = new Empleado(49);
		Empleado e13 = new Empleado(14);
		Empleado e14 = new Empleado(33);
		Empleado e15 = new Empleado(16);
		Empleado e16 = new Empleado(21);
		Empleado e17 = new Empleado(79);
		Empleado e18 = new Empleado(32);
		Empleado e19 = new Empleado(78);
		Empleado e20 = new Empleado(67);

		// entradas

		ArrayList<Empleado> entrada1 = new ArrayList<Empleado>();
		entrada1.add(e1);
		entrada1.add(e2);
		entrada1.add(e3);
		entrada1.add(e4);
		entrada1.add(e5);
		entrada1.add(e6);

		ArrayList<Empleado> entrada2 = new ArrayList<Empleado>();
		entrada2.add(e7);
		entrada2.add(e4);
		entrada2.add(e8);
		entrada2.add(e15);

		ArrayList<Empleado> entrada3 = new ArrayList<Empleado>();
		entrada3.add(e19);
		entrada3.add(e12);
		entrada3.add(e11);
		entrada3.add(e13);

		ArrayList<Empleado> entrada4 = new ArrayList<Empleado>();
		entrada4.add(e19);
		entrada4.add(e18);
		entrada4.add(e14);
		entrada4.add(e16);

		ArrayList<Empleado> entrada5 = new ArrayList<Empleado>();
		entrada5.add(e7);
		entrada5.add(e8);
		entrada5.add(e20);
		entrada5.add(e3);
		entrada5.add(e16);

		ArrayList<Empleado> entrada6 = new ArrayList<Empleado>();
		entrada6.add(e8);
		entrada6.add(e15);
		entrada6.add(e17);
		entrada6.add(e13);
		entrada6.add(e16);
		entrada6.add(e10);

		ArrayList<Empleado> entrada7 = new ArrayList<Empleado>();
		entrada7.add(e17);
		entrada7.add(e2);
		entrada7.add(e19);
		entrada7.add(e20);
		entrada7.add(e4);
		entrada7.add(e12);
		entrada7.add(e15);

		ArrayList<Empleado> entrada8 = new ArrayList<Empleado>();
		entrada8.add(e12);
		entrada8.add(e14);
		entrada8.add(e18);
		entrada8.add(e6);
		entrada8.add(e2);
		entrada8.add(e9);
		entrada8.add(e10);
		entrada8.add(e16);

		ArrayList<Empleado> entrada9 = new ArrayList<Empleado>();
		entrada9.add(e1);
		entrada9.add(e2);
		entrada9.add(e3);
		entrada9.add(e4);
		entrada9.add(e5);
		entrada9.add(e6);
		entrada9.add(e7);
		entrada9.add(e8);
		entrada9.add(e9);
		entrada9.add(e10);
		entrada9.add(e11);
		entrada9.add(e12);
		entrada9.add(e13);
		entrada9.add(e14);
		entrada9.add(e15);
		entrada9.add(e16);
		entrada9.add(e17);
		entrada9.add(e18);
		entrada9.add(e19);
		entrada9.add(e20);

		Backtracking bkt = new Backtracking();

		// algoritmos

		System.out.println("entrada 1");
		System.out.println(bkt.armarGrupos(entrada1));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 2");
		System.out.println(bkt.armarGrupos(entrada2));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 3");
		System.out.println(bkt.armarGrupos(entrada3));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 4");
		System.out.println(bkt.armarGrupos(entrada4));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 5");
		System.out.println(bkt.armarGrupos(entrada5));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 6");
		System.out.println(bkt.armarGrupos(entrada6));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 7");
		System.out.println(bkt.armarGrupos(entrada7));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 8");
		System.out.println(bkt.armarGrupos(entrada8));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

		System.out.println();
		System.out.println("entrada 9");
		System.out.println(bkt.armarGrupos(entrada9));
		System.out.println("Cantidad de estados explorados: " + bkt.getCantEstados());

	}

}
