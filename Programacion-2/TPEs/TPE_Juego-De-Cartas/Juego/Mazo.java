package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import Pocimas.Pocima;

public class Mazo {

	private ArrayList<Carta> cartas;
	
	public Mazo() {
		cartas = new ArrayList<Carta>();
	}
	
	public void addCarta(Carta c) {
		if(cartas.size() == 0) {
			cartas.add(c);
		}else {
			boolean repetida = false;
			for (Carta i : cartas) {
				if (i.equals(c))
					repetida = true;
			} 
			if (!repetida && c.tieneAtributos(cartas.get(0))) {
				cartas.add(c);				
			}
		}
		barajarCartas();
	}
	
	public void removeCarta(Carta c) {
		cartas.remove(c);
	}
	
	public Carta getCarta() {
		try {
			Carta aux = cartas.get(0);			
			cartas.add(aux);
			cartas.remove(0);
			return aux;
		} catch (Exception e) {
			return null;
		}
	}

	private void barajarCartas() {
		if(this.isPar())
		Collections.shuffle(cartas);
	}
	
	public int size() {
		return cartas.size();
	}

	public boolean isPar() {
		return(this.cartas.size()%2==0); 
	}

	public void repartirCartas(Jugador j1, Jugador j2, ArrayList<Pocima> pocimas) {
		boolean cartaDada = false;
		for (int i = 0; i <this.size(); i++) {
		Carta c = new Carta(this.getCarta().getNombre(), this.getCarta().getAtributos(), this.getCarta().getPocima());
			if (!pocimas.isEmpty()) {
				int rdm = (int) Math.random()*pocimas.size();
				c.setPocima(pocimas.get(rdm));
				pocimas.remove(rdm);
			}	
			if(cartaDada)
				j1.addCarta(c);
			else
				j2.addCarta(c);
			cartaDada = !cartaDada;
		}		
	}

}

