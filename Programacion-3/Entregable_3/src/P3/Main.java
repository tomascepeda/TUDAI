package P3;

public class Main {

	public static void main(String[] args) {

		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);
		grafito.agregarVertice(7);
		grafito.agregarVertice(8);
	
		grafito.agregarArco(1, 2, 30F);
		grafito.agregarArco(1, 4, 35F);
		grafito.agregarArco(1, 6, 13F);
		grafito.agregarArco(2, 5, 23F);
		grafito.agregarArco(2, 3, 33F);
		grafito.agregarArco(3, 2, 40F);
		grafito.agregarArco(4, 3, 3F);
		grafito.agregarArco(5, 1, 7F);
		grafito.agregarArco(5, 6, 0F);
		grafito.agregarArco(6, 8, 344F);
		
		// 10 arcos
		System.out.println(grafito.cantidadArcos());
		grafito.borrarVertice(1);
		// al borrar el vertice se eliminan sus propios arcos y los arcos que apuntan hacia el en otros vertices
		// deberia borrar 4, (los de las lineas 18,19,20 y 25)
		System.out.println(grafito.cantidadArcos());
		// si existe lo borra, resta 1
		grafito.borrarArco(6, 8);
		// deberian quedar 5
		System.out.println(grafito.cantidadArcos());
		
		// 5 arcos
		grafito.borrarVertice(2);
		// deberia borrar los de las lineas 21,22,23 (el de la linea 18 ya no existe)
		// deberian quedar 2
		System.out.println(grafito.cantidadArcos());
		
		grafito.borrarArco(4, 3);
		grafito.borrarArco(5, 6);
		
		// queda en 0
		System.out.println(grafito.cantidadArcos());
		
	}

}
