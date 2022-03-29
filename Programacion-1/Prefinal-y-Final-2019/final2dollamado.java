package practica;

public class final2dollamado { //2019
	
	//se tiene un arreglo ARR de enteros de tamaño MAX con secuencias de numeros distintos de cero separadas por uno o mas ceros
	//el arreglo tiene orden ascendente segun la suma de los elementos de cada secuencia
	//se pide hacer un programa completo para insertar en ARR manteniendo su orden una secuencia dada en un arreglo NUEVO de enteros
	//suponer que ARR y NUEVO comienzan y terminan con uno o mas ceros y que se encuentran cargados

	final static int max=10;
	
	public static void main(String[] args) {
		
		int [] arr = {0,1,2,0,1,4,0,1,5,0};
		int [] nuevo = {0,0,0,0,1,3,8,0,0,0};
		
		encontrar_posicion(arr,nuevo);
		mostrar(arr);

	}
	
	public static void encontrar_posicion(int [] arr, int [] nuevo) { //busca la posicion para insertar la secuencia de NUEVO en ARR, si la encuentra la inserta en la posiccion correspondiente, sino la inserta al final

		int i=0;
		int inicio=-1;
		int suma=0;
		boolean encontro=false;
		int valor=suma_sec_nuevo(nuevo);
		
		while(encontro==false && i<max) {
			while(arr[i]==0) {
				i++;
			}
			inicio=i-1;
			while(arr[i]!=0) {
				suma=suma+arr[i];
				i++;
			}
			if(suma>=valor) {
				insertar(arr,nuevo,inicio);
				encontro=true;
			}else {
				suma=0;
			}
			i++;
		}
		if(i==max && encontro==false) {
			insertar_al_fin(arr,nuevo);
		}
	}

	public static int suma_sec_nuevo(int [] nuevo){
		
		int i=0;
		int suma=0;
		
		while(nuevo[i]==0) {
			i++;
		}
		while(nuevo[i]!=0) {
			suma=suma+nuevo[i];
			i++;
		}
		return suma;
	}
	
	public static int long_sec_nuevo (int [] nuevo) {
		
		int i=0;
		int longitud=0;
		
		while(nuevo[i]==0) {
			i++;
		}
		while(nuevo[i]!=0) {
			longitud++;
			i++;
		}
		return longitud;
	}
	
	public static void insertar(int [] arr, int [] nuevo, int inicio) {
		
		int s=0;
		int longitud=long_sec_nuevo(nuevo);
		
		longitud++;
		while(longitud>0) {
			for(int i=max-1; i>inicio; i--) {
				arr[i]=arr[i-1];
			}
			longitud--;
		}
		inicio++;
		while(nuevo[s]==0) {
			s++;
		}
		while(nuevo[s]!=0) {
			arr[inicio]=nuevo[s];
			inicio++;
			s++;
		}
	}
	
	public static void mostrar(int [] arr) {
		for (int i=0; i<max; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static void insertar_al_fin(int [] arr, int [] nuevo) {
		
		int longitud=long_sec_nuevo(nuevo);
		int s=0;
		int j=max-2;
		
		longitud=longitud+2;
		while(longitud>0) {
			for(int i=0; i<max-1; i++) {
				arr[i]=arr[i+1];
			}
			longitud--;
		}
		while(nuevo[s]==0) {
			s++;
		}
		while(nuevo[s]!=0) {
			s++;
		}
		s--;
		while(nuevo[s]!=0) {
			arr[j]=nuevo[s];
			j--;
			s--;
		}
	}
	
}//class
