package tp6;

public class Main {

	public static void main(String[] args) {
		
		Consultora cons = new Consultora();
		
		Candidato c1 = new Candidato("nicolas", "bayon s.a", 350);
		Candidato c2 = new Candidato("fede", "rucula s.a", 300);
		Candidato c3 = new Candidato("raul", "duko s.a", 10000);
		Candidato c4 = new Candidato("nicole", "monaco s.a", 10);
		Candidato c5 = new Candidato("luis", "dass s.a", 100);
		Candidato c6 = new Candidato("nicky", "ssrl s.a", 1500);
		
		c1.setCriterio_contrato(new CriterioHoras(8));
		c2.setCriterio_contrato(new CriterioSueldo());
		c3.setCriterio_contrato(new CriterioEmpresa());
		c4.setCriterio_contrato(new CriterioSueldo());
		c5.setCriterio_contrato(new CriterioHoras(6));
		c6.setCriterio_contrato(new CriterioEmpresa());
		
		cons.addCandidato(c1);
		cons.addCandidato(c2);
		cons.addCandidato(c3);
		cons.addCandidato(c4);
		cons.addCandidato(c5);
		cons.addCandidato(c6);
		
		Contrato contratoPiola = new Contrato(4, 150000, "duko s.a");
		Contrato contratoNormal = new Contrato(8, 50000, "bayon s.a");
		Contrato contratoFeo = new Contrato(12, 100, "rucula s.a");
		
		System.out.println(cons.listarCandidatos(contratoPiola));
		System.out.println(cons.listarCandidatos(contratoNormal));
		System.out.println(cons.listarCandidatos(contratoFeo));
		
	}

}
