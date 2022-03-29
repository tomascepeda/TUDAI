package practica;

public class practicoMatrices {
	final static int maxf = 5;
	final static int maxc = 10;
	
	public static void main(String[] args) {
		
		int [][] matriz = new int [maxf][maxc];
		
		int [] arreglo = new int [maxc];
		
		//metodos de carga
		
		cargarMatriz(matriz);

		cargarArreglo(arreglo);
		
		//metodos de muestra
		
		impArreglo(arreglo);
		
		imprimir(matriz);
		
		//metodos de matriz
		
		sumarDiagonal(matriz); //suma los elementos de la diagonal del centro, para elegir otra diagonal aumenten el indice del for
		
		invertirContFila(matriz, 1); //matriz, fila a invertir
		
		insertarFila(matriz, arreglo, 1); //matriz, arreglo, posicion de fila a insertar (hace corrimiento)
		
		eliminarFila(matriz, 1); //matriz, fila a eliminar (hace corrimiento)
		
		ordenarFilas(matriz); //ordena de menor a mayor, para la viceversa hay que modificar posmenor y menor para que busquen
		//la posicion y el numero mas grande
		
		ordenarxSuma(matriz, arreglo); //el arreglo es el comparador para hacer la suma
		
	}
	
	public static void cargarMatriz(int [][] matriz) {
		for (int i=0; i<maxf; i++) {
			for (int s=0; s<maxc; s++) {
				matriz[i][s]= (int) Math.floor(Math.random()*9+1);
			}
		}
	}
	
	public static void cargarArreglo(int [] arreglo) {
		for (int i=0; i<maxc; i++) {
			arreglo[i] = (int) Math.floor(Math.random()*9+1);
		}
	}
	
	public static void impArreglo(int [] arreglo) {
		System.out.println("arreglo");
		for (int i=0; i<maxc; i++) {
			System.out.print(arreglo[i]);
		}
	}
	
	public static void imprimir(int [][] matriz) {
		for (int i=0; i<maxf; i++) {
			System.out.println();
			for (int s=0; s<maxc; s++) {
				System.out.print(matriz[i][s]);
			}
		}
	}
	
/////////////////////////////1a/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static void sumarDiagonal(int [][] matriz) {
		int suma=0;
		for(int i=0; i<maxf; i++) {
			suma = suma + matriz[i][i];
		}
		System.out.println(suma);
	}
	
/////////////////////////////1b////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static void invertirContFila(int [][] matriz, int f) {
		int i=0;
		int s=maxc-1;
		int save=0;
		while((s>0&&i<maxc)&&(i<s && s>i)) {
			save=matriz[f][s];
			matriz[f][s]=matriz[f][i];
			matriz[f][i]=save;
			i++;
			s--;
		}
	}
	
/////////////////////////////2////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void insertarFila(int [][] matriz,int [] arreglo, int pos) {
		int c=0;
		while(c<maxc) {
			for(int i=maxf-1; i>pos; i--) {			//modificado para funcionar con ej. 5
				matriz[i][c]=matriz[i-1][c];
			}	
			c++;
		}
		for(int s=0; s<maxc; s++) {
			matriz[pos][s]=arreglo[s];
		}
	}
	
/////////////////////////////3////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void eliminarFila(int [][] matriz, int pos) {
		int c=0;
		while(c<maxc) {
			for(int i=pos; i<maxf-1; i++) {
				matriz[i][c]=matriz[i+1][c];
			}	
			c++;
		}
	}
	
/////////////////////////////4///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static int posMenor(int [][] matriz, int f, int c) { //ubica la posicion del numero mas chico
		int maschico=1000;
		int pos=0;
		for(int i=c; i<maxc; i++) {
			if(matriz[f][i]<maschico) {
				maschico=matriz[f][i];
				pos=i;
			}
		}
		return pos;
	}
	
	public static int menor(int [][] matriz, int f, int c) { //ubica el numero mas chico
		int maschico=1000;
		for(int i=c; i<maxc; i++) {
			if(matriz[f][i]<maschico) {
				maschico=matriz[f][i];
			}
		}
		return maschico;
	}
	
	public static void ordenarFilas(int [][] matriz) {
		for(int i=0; i<maxf; i++) {
			for(int s=0; s<maxc; s++) {
				int save;
				int pos;
				save=matriz[i][s];
				pos=posMenor(matriz,i,s);
				matriz[i][s]=menor(matriz,i,s);
				matriz[i][pos]=save;
			}
		}
	}

//////////////////////////5///////////////////////////////////////////////////////////////////////////////////////////////////////

	public static int sumaFila(int [][] matriz, int f) {
		int suma=0;
		for(int i=0; i<maxc; i++) {
			suma=suma+matriz[f][i];
		}
		return suma;
	}
	
	public static int sumaArreglo(int [] arreglo) {
		int suma=0;
		for(int i=0; i<maxc; i++) {
			suma=suma+arreglo[i];
		}
		return suma;
	}
	
	public static void ordenarxSuma(int [][] matriz, int [] arreglo) {
		int s_arreglo=0;
		s_arreglo=sumaArreglo(arreglo);
		for(int i=0; i<maxf-1; i++) {
			int f_actual;
			int f_sig;
			f_actual=sumaFila(matriz,i);
			f_sig=sumaFila(matriz,i+1);
			if(s_arreglo < f_actual && f_sig > s_arreglo) {
				insertarFila(matriz,arreglo,i);
				break; //ojo, si no lo toman como valido buscar la forma de hacerlo con un while. computacionalmente funciona bien
			}
		}
	}
	
} //class