package ej7;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		CriterioAutor ca = new CriterioAutor("julio berne");
		CriterioContenidoPalabraClave cpc = new CriterioContenidoPalabraClave("que");
		CriterioContenidoCantPalabras ccpc = new CriterioContenidoCantPalabras(6);
		CriterioPalabraClave pc = new CriterioPalabraClave("nuevo");
		CriterioSinPalabrasClave spc = new CriterioSinPalabrasClave();
		CriterioTitulo ct = new CriterioTitulo("martin fierro");
		CriterioTituloPalabra ctp = new CriterioTituloPalabra("fierro");
		
		Historiador h = new Historiador();
		
		Documento d1 = new Documento("martin fierro", "nunca me gusto este cuento pero ya fue");
		d1.addAutor("el que lo hizo");
		//d1.addPalabraClave("libro"); d1.addPalabraClave("viejo"); d1.addPalabraClave("gauchesco");
		
		Documento d2 = new Documento("records mundiales guinnes", "libro con todos los records mundiales");
		d2.addAutor("guinnes records");
		d2.addPalabraClave("libro"); d2.addPalabraClave("actualizable"); d2.addPalabraClave("mundial");
		
		Documento d3 = new Documento("condorito", "historieta que leia de chico xd");
		d3.addAutor("quoda");
		d3.addPalabraClave("historieta"); d3.addPalabraClave("nuevo"); d3.addPalabraClave("entretenido");
		
		Documento d4 = new Documento("mafalda", "muy vieja para mi generacion pero segun dicen es buena");
		d4.addAutor("no me acuerdo");
		d4.addPalabraClave("historieta"); d4.addPalabraClave("viejo"); d4.addPalabraClave("blanco y negro");
		
		Documento d5 = new Documento("libro de historia", "mi libro de historia que usaba en el secuendario");
		d5.addAutor("secundario");
		d5.addPalabraClave("libro"); d5.addPalabraClave("nuevo"); d5.addPalabraClave("historia");
		
		Documento d6 = new Documento("revista gente", "revista que tampoco leo pero se compra en casa");
		d6.addAutor("gente");
		d6.addPalabraClave("revista"); d6.addPalabraClave("nuevo"); d6.addPalabraClave("chusmerio");
		
		h.addDocumento(d1); h.addDocumento(d2); h.addDocumento(d3); h.addDocumento(d4); h.addDocumento(d5); h.addDocumento(d6);
		
		System.out.print("[");
		for (Documento i : h.getDocumentos(spc, ccpc)) {
			System.out.print(i.getTitulo() + ", ");
		}
		System.out.println("]");
		
		System.out.print("[");
		for (Documento i : h.getDocumentos(spc)) {
			System.out.print(i.getTitulo() + ", ");
		}
		System.out.println("]");
		
		System.out.print("[");
		for (Documento i : h.getDocumentos(pc)) {
			System.out.print(i.getTitulo() + ", ");
		}
		System.out.println("]");
		
		System.out.print("[");
		for (Documento i : h.getDocumentos(cpc)) {
			System.out.print(i.getTitulo() + ", ");
		}
		System.out.println("]");
		
	}

}
