package Juego;

import java.util.ArrayList;

import Estrategias.*;
import Pocimas.*;

public class Main {

	public static void main(String[] args) {
	
		Estrategia es1 = new EstrategiaObstinado("Obstinado", "fuerza");
		Estrategia es2 = new EstrategiaAmbicioso("Ambicioso");
		Estrategia es3 = new EstrategiaTimbero("Timbero");
		
		Jugador j1 = new Jugador("Jere", es1);
		Jugador j2 = new Jugador("Tomas", es2);
		
		//Pocimas
		PocimaPorcentaje p1 = new PocimaPorcentaje("kriptonita", -20);
	    PocimaPorcentaje p2 = new PocimaPorcentaje("fortalecedora plus", 50);
	    PocimaValorFijo p5 = new PocimaValorFijo("quiero vale 4", 4);
	    PocimaValorFijo p6 = new PocimaValorFijo("numero magico", 22);
	    PocimaSelectiva p7 = new PocimaSelectiva("selectiva fuerza", "fuerza", 35);
	    PocimaSelectiva p8 = new PocimaSelectiva("selectiva peso", "peso", 43);
	    
	    //esto es para el caso especial de la pocima cocktail
	    ArrayList<Pocima> pocimasAux = new ArrayList<Pocima>();
	    pocimasAux.add(p1); pocimasAux.add(p2);
	    pocimasAux.add(p5); pocimasAux.add(p6); pocimasAux.add(p7); pocimasAux.add(p8);
	    PocimaCocktail p9 = new PocimaCocktail("cocktail", pocimasAux);
		
	    String mazoPath = "./superheroes.json"; 
	    Mazo mazo = VisorMazo.armarMazo(mazoPath);
	    
		Juego juego = new Juego(j1, j2, mazo);
		juego.addPocima(p1);
		juego.addPocima(p2);
		juego.addPocima(p5);
		juego.addPocima(p6);
		juego.addPocima(p7);
		juego.addPocima(p8);
		juego.addPocima(p9);
		
		juego.jugar(20); //run
		
		ArrayList<String> log = juego.textoJuego();
		
		for (int i = 0; i <log.size(); i++) {
			System.out.println(log.get(i));
		}
		
	}

}
