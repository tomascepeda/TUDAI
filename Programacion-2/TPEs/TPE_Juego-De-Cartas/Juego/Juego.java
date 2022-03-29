package Juego;

import java.util.ArrayList;
import java.util.Collections;

import Pocimas.Pocima;

public class Juego {
	
	private Jugador jugador1, jugador2;
	private Mazo mazo;
	private ArrayList<Pocima> pocimas;
	private ArrayList<String> text = new ArrayList<String>();
	
	public Juego(Jugador j1, Jugador j2, Mazo m) {
		super();
		this.jugador1 = j1;
		this.jugador2 = j2;
		this.mazo = m;
		this.pocimas = new ArrayList<Pocima>();
	}
	
	public void addPocima(Pocima po) {
		this.pocimas.add(po);
	}
	
	public void barajarPocimas() {
		Collections.shuffle(pocimas);
	}

	public void jugar(int rondas) {
		
		if(!mazo.isPar() || rondas == 0) {
			text.add("No se puede jugar");
		}else {
	
			this.mazo.repartirCartas(jugador1, jugador2, this.pocimas);	
		
			Jugador ganador = null; 
			int i = 0;
			Jugador j1 = jugador1;
			Jugador j2 = jugador2;
			Jugador ganadorRonda = j1;
			
			while ((i<rondas && ganador == null) && (j1.getCarta() != null && j2.getCarta() != null)){
				
				Carta cartaJugador1 = j1.getCarta();
				Carta cartaJugador2 = j2.getCarta();
				i++;
				text.add("---- Ronda " + i + " ----");
				
				try {
					String atributoSelecionado = ganadorRonda.elegirAtributo(ganadorRonda.getCarta());
				
					text.add("El jugador " + ganadorRonda.getNombre() + " selecciona competir por el atributo: " + atributoSelecionado);
					text.add("La carta de " + j1.getNombre() + " es " + cartaJugador1.getNombre() + " con " + atributoSelecionado + " " + cartaJugador1.getLog(atributoSelecionado));
					text.add("La carta de " + j2.getNombre() + " es " + cartaJugador2.getNombre() + " con " + atributoSelecionado + " " + cartaJugador2.getLog(atributoSelecionado));
					
					//se comprueba el ganador de la ronda 
					if (cartaJugador1.getValor(atributoSelecionado) > cartaJugador2.getValor(atributoSelecionado)) {
						j1.addCarta(cartaJugador2);
						j2.removeCarta(cartaJugador2);
						ganadorRonda = j1;
						text.add("Gana la ronda " + ganadorRonda.getNombre() + " y queda con " + ganadorRonda.cantCartas() + " cartas (" + j2.getNombre() + " posee ahora " + j2.cantCartas() + " cartas)");
					}else if (cartaJugador1.getValor(atributoSelecionado) < cartaJugador2.getValor(atributoSelecionado)) {
						j2.addCarta(cartaJugador1);
						j1.removeCarta(cartaJugador1);
						text.add("Gana la ronda " + j2.getNombre() + " y queda con " + j2.cantCartas() + " cartas (" + j1.getNombre() + " posee ahora " + j1.cantCartas() + " cartas)");
						ganadorRonda = j2;
	                    				
					}else {
						text.add("empate");
					}
					
				} catch (Exception e) {
					System.out.println("catch");
					if (cartaJugador1 == null) {
						ganador = j2;
					}else {
						ganador = j1;
					}
				}
				
			} //cierra while
			
			text.add("---- FIN DEL JUEGO ----");
			if (ganador != null) {
				text.add("GANO " + ganador.getNombre());			
			}else if (j1.cantCartas() > j2.cantCartas()) {
				text.add("GANO " + j1.getNombre());
			}else if (j1.cantCartas() < j2.cantCartas()) {
				text.add("GANO " + j2.getNombre());
			}else {
				text.add("EMPATE");
			}
			
		} //cierra else principal
		
	} //cierra jugar
	
	public ArrayList<String> textoJuego(){
		return this.text;
	}
	
}
