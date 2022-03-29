package practico6;

import java.util.Iterator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
	
		ContenedorConcreto cc = new ContenedorConcreto(
			8,	//inicio
			50,	//fin
			3);	//multiplos de x numero
		
		Iterator<Integer> it = cc.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	
	}

}
