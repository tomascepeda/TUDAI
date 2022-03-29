package tp8.ej6;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		TareaCompuesta t1 = new TareaCompuesta("pintar vereda");
		TareaCompuesta t2 = new TareaCompuesta("cortar pasto");
		TareaCompuesta t3 = new TareaCompuesta("pintar techo");
		
		TareaTerminal tt1 = new TareaTerminal("comprar bolsas");
		tt1.setInicio(LocalDate.of(2020, 1, 23));
		tt1.setFin(LocalDate.of(2020, 1, 23));
		tt1.setETinicio(LocalDate.of(2010, 1, 23));
		tt1.setETfin(LocalDate.of(2020, 1, 23));
		TareaTerminal tt2 = new TareaTerminal("preparar pintura");
		tt2.setInicio(LocalDate.of(2020, 1, 23));
		tt2.setFin(LocalDate.of(2020, 1, 23));
		tt2.setETinicio(LocalDate.of(2004, 1, 23));
		tt2.setETfin(LocalDate.of(2020, 1, 23));
		TareaTerminal tt3 = new TareaTerminal("comprar nafta");
		tt3.setInicio(LocalDate.of(2020, 1, 23));
		tt3.setFin(LocalDate.of(2020, 1, 23));
		tt3.setETinicio(LocalDate.of(2020, 1, 23));
		tt3.setETfin(LocalDate.of(2020, 1, 23));
		TareaTerminal tt4 = new TareaTerminal("comprar tanza");
		tt4.setInicio(LocalDate.of(2006, 1, 23));
		tt4.setFin(LocalDate.of(2020, 1, 23));
		tt4.setETinicio(LocalDate.of(2020, 1, 23));
		tt4.setETfin(LocalDate.of(2020, 1, 23));
		TareaTerminal tt5 = new TareaTerminal("comprar aceite");
		tt5.setInicio(LocalDate.of(2020, 1, 23));
		tt5.setFin(LocalDate.of(2020, 1, 23));
		tt5.setETinicio(LocalDate.of(2020, 1, 23));
		tt5.setETfin(LocalDate.of(2009, 1, 23));
		TareaTerminal tt6 = new TareaTerminal("saludar vecinos");
		tt6.setInicio(LocalDate.of(2020, 1, 23));
		tt6.setFin(LocalDate.of(2020, 1, 23));
		tt6.setETinicio(LocalDate.of(2013, 1, 23));
		tt6.setETfin(LocalDate.of(2020, 1, 23));
		
		RecursoExclusivo r1 = new RecursoExclusivo("cortadora", LocalDate.of(2019, 9, 12), LocalDate.of(2020, 1, 23));
		RecursoCompartido r2 = new RecursoCompartido("pincel");
		RecursoExclusivo r3 = new RecursoExclusivo("escalera", LocalDate.of(2020, 10, 25), LocalDate.of(2020, 10, 25));
		RecursoCompartido r4 = new RecursoCompartido("aguarras");
		RecursoExclusivo r5 = new RecursoExclusivo("escuadra", LocalDate.of(2020, 10, 12), LocalDate.of(2020, 10, 26));
		
		tt1.addRecurso(r1);
		tt1.addRecurso(r5);
		tt2.addRecurso(r3);
		tt3.addRecurso(r5);
		tt4.addRecurso(r2);
		tt5.addRecurso(r2);
		tt6.addRecurso(r5);
		
		t1.addTarea(tt5);
		t1.addTarea(tt3);
		t2.addTarea(t1);
		t2.addTarea(tt2);
		t3.addTarea(tt4);
		t3.addTarea(tt1);
		
		System.out.println(t1.getEstado());
		System.out.println(t1.getInicio());
		System.out.println(t1.getFin());
		System.out.println(t1.getETfin());
		System.out.println(t1.getDuracion());
		
	}

}
