package ej7;

import java.util.ArrayList;

public class Historiador {
	
	private ArrayList<Documento> documentos;

	public Historiador() {
		documentos = new ArrayList<Documento>();
	}
	
	public void addDocumento(Documento d) {
		documentos.add(d);
	}
	
	public ArrayList<Documento> getDocumentos(Criterio c1){
		
		ArrayList<Documento> seleccionados = new ArrayList<Documento>();
		
		for (Documento i : documentos) {
			if(c1.cumple(i))
				seleccionados.add(i);
		}
		
		return seleccionados;
	}
	
	public ArrayList<Documento> getDocumentos(Criterio c1, Criterio c2){
		
		ArrayList<Documento> seleccionados = new ArrayList<Documento>();
		
		seleccionados = (ArrayList<Documento>) getDocumentos(c1).clone();
		
		for (Documento i : documentos) {
			if(c2.cumple(i))
				seleccionados.add(i);
		}
		
		return seleccionados;
	}
	
}
