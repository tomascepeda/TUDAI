package parcial;

public class Main {

	public static void main(String[] args) {

		Region r1 = new Region("r1");
		Region r2 = new Region("r2");
		Region r3 = new Region("r3");
		
		Comarca c1 = new Comarca("c1", 10, 20, 30);		//hab //sup //ing
		Comarca c2 = new Comarca("c2", 20, 200, 300);
		Comarca c3 = new Comarca("c3", 30, 40, 70);
		Comarca c4 = new Comarca("c4", 40, 400, 700);
		Comarca c5 = new Comarca("c5", 50, 60, 90);
		Comarca c6 = new Comarca("c6", 60, 600, 900);
		
		r1.addRegion(c1);
		r1.addRegion(c2);
		r2.addRegion(c3);
		r2.addRegion(c4);
		r3.addRegion(c5);
		r3.addRegion(c6);
		
		r2.addRegion(r3);
		r1.addRegion(r2);
		
		System.out.println(r1.getHabitantes());
		System.out.println(r1.getSuperficie());
		System.out.println(r1.getIngresosPerCapita());
		System.out.println(r1.getDensidad());
		
		CriterioHabitantes c = new CriterioHabitantes(210);
		CriterioDensidad d = new CriterioDensidad(0.10);
		CriterioNombre n = new CriterioNombre("c4");
		CriterioAnd and = new CriterioAnd(c, d);
		CriterioOr or = new CriterioOr(c, n);
		CriterioNot not = new CriterioNot(d);
		r1.getListaComarcas(new CriterioNombre("a"));
		
		System.out.println(c.cumple(r1));
		System.out.println(d.cumple(r1));
		System.out.println(n.cumple(r1));
		System.out.println(and.cumple(r1));
		System.out.println(or.cumple(r1));
		System.out.println(not.cumple(r1));
		System.out.println(r1.getListaComarcas(d));
				
	
	}

}
