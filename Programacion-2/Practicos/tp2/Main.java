package practica;

public class Main {

	public static void main(String[] args) {
		
		/*
		Persona marano = new Persona(42361543);
		
		System.out.println(marano.enForma());
		System.out.println(marano.getImc());
		System.out.println(marano.mayorDeEdad());
		System.out.println(marano.puedeVotar());
		System.out.println(marano.getInfo());
		 */
		
		/*
		Electrodomestico pava = new Electrodomestico();
		
		System.out.println(pava.altaGama());
		System.out.println(pava.getBalance());
		System.out.println(pava.getColor());
		pava.setColor("amarillo de carreras");
		System.out.println(pava.getColor());
		pava.setConsumo(1000);
		System.out.println(pava.bajoConsumo());
		*/
		
		/*
		punto_geometrico p1 = new punto_geometrico(4,8);
		System.out.println(p1.getdDistanciaEuclidea(8, 16));
		*/
		
		Serie got = new Serie("game of thrones", "re piola wachin mirala", "hbo", "fantasia");
		
		Temporada t1 = new Temporada("t", "d", "c", "g");
		Temporada t2 = new Temporada("t", "d", "c", "g");
		Temporada t3 = new Temporada("t", "d", "c", "g");
		Temporada t4 = new Temporada("t", "d", "c", "g");
		
		got.addTemporada(t1);
		got.addTemporada(t2);
		got.addTemporada(t3);
		got.addTemporada(t4);

		Episodio e1 = new Episodio("t", "d");
		Episodio e2 = new Episodio("t", "d");
		Episodio e3 = new Episodio("t", "d");
		Episodio e4 = new Episodio("t", "d");
		Episodio e5 = new Episodio("t", "d");
		Episodio e6 = new Episodio("t", "d");
		Episodio e7 = new Episodio("t", "d");
		Episodio e8 = new Episodio("t", "d");
		Episodio e9 = new Episodio("t", "d");
		Episodio e10 = new Episodio("t", "d");

		t1.addEpisodio(e1);
		t1.addEpisodio(e2);
		t1.addEpisodio(e3);
		t2.addEpisodio(e4);
		t2.addEpisodio(e5);
		t2.addEpisodio(e6);
		t3.addEpisodio(e7);
		t3.addEpisodio(e8);
		t4.addEpisodio(e9);
		t4.addEpisodio(e10);
		
		e1.setCalificacion(3);
		e2.setCalificacion(4);
		e3.setCalificacion(4);
		e4.setCalificacion(5);
		e5.setCalificacion(100);
		e5.setCalificacion(5);
		e6.setCalificacion(5);
		e7.setCalificacion(4);
		e8.setCalificacion(4);
		e9.setCalificacion(3);
		e10.setCalificacion(2);
		
		e1.setVisto(true);
		e2.setVisto(true);
		e3.setVisto(false);
		e4.setVisto(true);
		e5.setVisto(true);
		e6.setVisto(true);
		e7.setVisto(true);
		e8.setVisto(false);
		e9.setVisto(true);
		e10.setVisto(true);
		
		System.out.println("t1 episodios vistos: " + t1.getTotalEpisodiosVistos());
		System.out.println("t2 episodios vistos: " + t2.getTotalEpisodiosVistos());
		System.out.println("t3 episodios vistos: " + t3.getTotalEpisodiosVistos());
		System.out.println("t4 episodios vistos: " + t4.getTotalEpisodiosVistos());
		
		System.out.println("serie got episodios vistos: " + got.getTotalEpisodiosVistos());
		
		System.out.println("t1 promedio de calificaciones: " + t1.getPromedioCalificaciones());
		System.out.println("t2 promedio de calificaciones: " + t2.getPromedioCalificaciones());
		System.out.println("t3 promedio de calificaciones: " + t3.getPromedioCalificaciones());
		System.out.println("t4 promedio de calificaciones: " + t4.getPromedioCalificaciones());
		
		System.out.println("serie got promedio de calificaciones: " + got.getPromedioCalificaciones());
		
		System.out.println("serie got todos los episodios vistos: " + got.isTodosEpisodiosVistos());
		
	}

}
