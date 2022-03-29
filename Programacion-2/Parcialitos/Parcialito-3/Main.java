package Parcialito;

public class Main {

	public static void main(String[] args) {
		
		Plataforma p = new Plataforma();
		
		Pelicula p1 = new Pelicula("terminator", "buena", "yirrap", 2015, 18, 120);
		p1.addActor("arnold");
		p1.addGenero("accion");
		Pelicula p2 = new Pelicula("furious 9", "muy buena", "justin lin", 2020, 18, 220);
		p2.addActor("Will Smith");
		p2.addGenero("accion");
		Pelicula p3 = new Pelicula("barney super luna", "media", "Martin Scorsese", 2018, 8, 90);
		p3.addActor("tarras");
		p3.addGenero("infantil");
		
		p.addPelicula(p1);
		p.addPelicula(p2);
		p.addPelicula(p3);
		
		CriterioTitulo ctitulo = new CriterioTitulo("luna");
		CriterioGenero cgenero = new CriterioGenero("accion");
		CriterioGenero cgenero2 = new CriterioGenero("infantil");
		CriterioGenero cgenero3 = new CriterioGenero("comedia");
		CriterioActor cactor = new CriterioActor("Will Smith");
		CriterioDirector cdirector = new CriterioDirector("Martin Scorsese");
		CriterioAnd and = new CriterioAnd(cactor, new CriterioNot(cdirector));
		CriterioEstrenoMenor cemenor = new CriterioEstrenoMenor(2020);
		CriterioEstrenoMayor cemayor = new CriterioEstrenoMayor(2000);
		CriterioDuracionMenor cdmenor = new CriterioDuracionMenor(120);
		CriterioAnd and2 = new CriterioAnd(cemenor, cdmenor);
		CriterioOr or = new CriterioOr(cgenero, cgenero2);
		CriterioOr or2 = new CriterioOr(cemayor, or);
		CriterioOr or3 = new CriterioOr(cemayor, or);
		
		System.out.println(p.buscarPeliculas(ctitulo));
		System.out.println(p.buscarPeliculas(cgenero));
		System.out.println(p.buscarPeliculas(and));
		System.out.println(p.buscarPeliculas(and2));
		
		System.out.println(p.isRentable(p1, and2));
		System.out.println(p.isRentable(p1, or2));

	}

}
