import java.util.Iterator;

public class Main {

	// O(n) siendo n el tamaño de la lista de entrada
	public static SimpleLinkedList getSubSecuencias(SimpleLinkedList entrada, int umbral) {
		
		if(entrada.isEmpty())
			return entrada;
		
		SimpleLinkedList salida = new SimpleLinkedList();
		Iterator<Integer> it = entrada.iterator();
		int count = 0;
		
		while(it.hasNext()) {
			int data = it.next();
			if((count + data) <= umbral)
				count += data;
			else if (count <= umbral && count != 0) { 
				salida.insertLast(count);
				count = data;
			} else
				count = data;
		}

		if(count <= umbral && count != 0)
			salida.insertLast(count);
		
		return salida;
	}
		
	public static void main(String[] args) {
		
		//Listas
		
		//Lista de entrada = [] Valor umbral: 10
		//Lista de salida = [] // No devuelve nada (una lista vacía)
		SimpleLinkedList lista1 = new SimpleLinkedList();
		
		System.out.println("Lista de entrada: " + lista1.print());
		System.out.println("Lista de salida: " + getSubSecuencias(lista1, 10).print());
		
		//Lista de entrada = [1, 2, 3] Valor umbral: 10
		//Lista de salida = [6] // Todos los valores de la lista
		SimpleLinkedList lista2 = new SimpleLinkedList();
		lista2.insertLast(1);
		lista2.insertLast(2);
		lista2.insertLast(3);
		
		System.out.println();
		System.out.println("Lista de entrada: " + lista2.print());
		System.out.println("Lista de salida: " + getSubSecuencias(lista2, 10).print());
		
		//Lista de entrada = [1, 2, 3] Valor umbral: 2
		//Lista de salida = [1, 2] // Dos elementos, el 3 como sub-secuencia supera el valor umbral.
		SimpleLinkedList lista3 = new SimpleLinkedList();
		lista3.insertLast(1);
		lista3.insertLast(2);
		lista3.insertLast(3);
		
		System.out.println();
		System.out.println("Lista de entrada: " + lista3.print());
		System.out.println("Lista de salida: " + getSubSecuencias(lista3, 2).print());
		
		//Lista de entrada = [3, 5, 2, 7, 19, 14, 28] Valor umbral: 10
		//Lista de salida = [10, 7] // Los valores surgen de las sub-secuencias [3,5,2]; [7]; 
		SimpleLinkedList lista4 = new SimpleLinkedList();
		lista4.insertLast(3);
		lista4.insertLast(5);
		lista4.insertLast(2);
		lista4.insertLast(7);
		lista4.insertLast(19);
		lista4.insertLast(14);
		lista4.insertLast(28);
		
		System.out.println();
		System.out.println("Lista de entrada: " + lista4.print());
		System.out.println("Lista de salida: " + getSubSecuencias(lista4, 10).print());
		
		//Lista de entrada = [3, 5, 4, 2, 7, 15, 14, 28] Valor umbral: 15	
		//Lista de salida = [14,7,15,14] // Los valores surgen de las sub-secuencias [3,5,4,2]; [7]; [15];[14]
		SimpleLinkedList lista5 = new SimpleLinkedList();
		lista5.insertLast(3);
		lista5.insertLast(5);
		lista5.insertLast(4);
		lista5.insertLast(2);
		lista5.insertLast(7);
		lista5.insertLast(15);
		lista5.insertLast(14);
		lista5.insertLast(28);
		
		System.out.println();
		System.out.println("Lista de entrada: " + lista5.print());
		System.out.println("Lista de salida: " + getSubSecuencias(lista5, 15).print());
		
		//pueden usar este para probar, es mas facil para cargar elementos (para el programador)
		int[] valores = { 9, 17, 4, 6, 7, 15, 1, 28, 74, 5, 31, 1, 3 };
		SimpleLinkedList entrada = new SimpleLinkedList(valores);
		
		System.out.println();
		System.out.println("Lista de entrada: " + entrada.print());
		System.out.println("Lista de salida: " + getSubSecuencias(entrada, 21).print());

	}

}
