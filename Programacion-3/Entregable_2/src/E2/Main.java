package E2;

public class Main {
	
	public static void main(String[] args) {
		
		// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
		int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
		Tree miArbol = new Tree(valoresIniciales);
		
		System.out.print("Arbol: ");
		miArbol.printPreOrder();
		System.out.println();
		System.out.println("Elemento mas grande: " + miArbol.getMaxElem());
		System.out.println("Altura: " + miArbol.getHeight());
		System.out.println("Rama mas larga: " + miArbol.getLongestBranch());
		System.out.println("Obtener elementos del nivel x: " + miArbol.getElementAtLevel(2));
		System.out.println("Frontera: " + miArbol.getFrontera());

		miArbol.add(23);
		miArbol.add(3);
		miArbol.delete(6);
		miArbol.delete(30);

		System.out.println();
		System.out.print("Arbol: ");
		miArbol.printPreOrder();
		System.out.println();
		System.out.println("Elemento mas grande: " + miArbol.getMaxElem());
		System.out.println("Altura: " + miArbol.getHeight());
		System.out.println("Rama mas larga: " + miArbol.getLongestBranch());
		System.out.println("Obtener elementos del nivel x: " + miArbol.getElementAtLevel(2));
		System.out.println("Frontera: " + miArbol.getFrontera());

		miArbol.add(65);
		miArbol.delete(5);
		miArbol.delete(15);
		miArbol.add(55);

		System.out.println();
		System.out.print("Arbol: ");
		miArbol.printPreOrder();
		System.out.println();
		System.out.println("Elemento mas grande: " + miArbol.getMaxElem());
		System.out.println("Altura: " + miArbol.getHeight());
		System.out.println("Rama mas larga: " + miArbol.getLongestBranch());
		System.out.println("Obtener elementos del nivel x: " + miArbol.getElementAtLevel(2));
		System.out.println("Frontera: " + miArbol.getFrontera());
	
	}

}
