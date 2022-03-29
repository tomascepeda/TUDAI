package ej7;

import java.util.ArrayList;

public class CriterioPalabraClave implements Criterio{
	
	private String palabra;
	
	public CriterioPalabraClave(String palabra) {
		this.palabra = palabra;
	}

	@Override
	public boolean cumple(Documento d) {
		ArrayList<String> copia = new ArrayList<String>();
		copia = (ArrayList<String>) d.getPalabras_clave().clone();
		for (String i : copia) {
			 if(this.palabra.equals(i))
				 return true;
		}
		return false;
	}
	
}
