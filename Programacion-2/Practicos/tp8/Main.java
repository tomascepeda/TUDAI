package tp8;

public class Main {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("yirrap", 1234);
		Persona p2 = new Persona("el tomy", 12345);
		Persona p3 = new Persona("icardi", 1234);
		Persona p4 = new Persona("rogelio", 12345);
		Persona p5 = new Persona("el luis", 1234);
		Persona p6 = new Persona("marce", 12345);
		Persona p7 = new Persona("alonso", 1234);
		Persona p8 = new Persona("cimo", 12345);
		Persona p9 = new Persona("pana alfredo", 1234);
		Persona p10 = new Persona("oscu", 12345);
		
		Candidato c1 = new Candidato("cristi", 11, "chorizos", "fpchoreo");
		Candidato c2 = new Candidato("gatito", 12, "jxc", "cambiemos");
		Candidato c3 = new Candidato("nico", 13, "chorizos", "fpchoreo");
		Candidato c4 = new Candidato("eliel", 14, "jxc", "cambiemos");
		Candidato c5 = new Candidato("albert", 15, "chorizos", "fpchoreo");
		Candidato c6 = new Candidato("coscu", 16, "jxc", "cambiemos");
		Candidato c7 = new Candidato("messi", 17, "chorizos", "fpchoreo");
		Candidato c8 = new Candidato("pipa", 18, "jxc", "cambiemos");
		
		Establecimiento argentina = new Establecimiento();
		Establecimiento bsas = new Establecimiento();
		Establecimiento cordoba = new Establecimiento();
		Establecimiento tandil = new Establecimiento();
		Establecimiento villa_italia = new Establecimiento();
		Establecimiento tunitas = new Establecimiento();

		Mesa m1 = new Mesa();
		Mesa m2 = new Mesa();
		Mesa m3 = new Mesa();
		Mesa m4 = new Mesa();
		Mesa m5 = new Mesa();
		
		m1.addVotante(p1);
		m1.addVotante(p2);
		m2.addVotante(p3);
		m2.addVotante(p4);
		m3.addVotante(p5);
		m3.addVotante(p6);
		m4.addVotante(p7);
		m4.addVotante(p8);
		m5.addVotante(p9);
		m5.addVotante(p10);
		
		argentina.addEstablecimiento(bsas);
		argentina.addEstablecimiento(m5);
		argentina.addEstablecimiento(cordoba);
		cordoba.addEstablecimiento(m1);
		bsas.addEstablecimiento(tandil);
		tandil.addEstablecimiento(m2);
		tandil.addEstablecimiento(tunitas);
		tandil.addEstablecimiento(villa_italia);
		tunitas.addEstablecimiento(m4);
		villa_italia.addEstablecimiento(m3);
		
		p1.votar(m1, c2);
		p2.votar(m1, c2);
		p3.votar(m2, c5);
		p4.votar(m2, c6);
		p5.votar(m3, c2);
		p6.votar(m3, c8);
		p7.votar(m4, c3);
		p8.votar(m4, c2);
		p9.votar(m5, c1);
		p10.votar(m1, c8);

		System.out.println(argentina.getPorcentajeVotos(new CriterioCandidato(c2)));
		System.out.println(argentina.getTotalVotos());
		System.out.println(m1.getPorcentajeVotos(new CriterioCandidato(c2)));
		
		System.out.println(Candidato.getCandidatos().toString());
		
	}

}
