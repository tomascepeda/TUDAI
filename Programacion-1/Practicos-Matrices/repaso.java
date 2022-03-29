package practica;

public class repaso {  //aca hay de todo

	final static int maxf=5;
	final static int maxc=20;
	
	
	public static void main(String[] args) {
		
		
		int [][] matriz = {
				{0,1,2,3,4,5,0,7,1,0,0,2,8,6,4,7,4,7,8,0},
				{0,7,2,0,1,4,4,7,0,1,5,8,1,0,4,0,0,7,8,0},
				{0,7,8,6,0,4,0,0,0,1,2,9,5,1,0,0,4,0,8,0},
				{0,3,8,0,9,6,3,1,0,0,9,6,8,0,1,1,4,1,0,0},
				{0,5,8,6,4,0,4,0,8,2,0,8,0,0,1,4,8,1,0,0}
		};
		
		int [][] inventario = new int [2][100];
		segundo_parcial(inventario);
		imprimir(inventario);
		segundo_parcial_2018(matriz);
		imprimir(matriz);
		final_regular(matriz);
		imprimir(matriz);
		
	}

	public static void imprimir(int [][] matriz) {
		for (int i=0; i<maxf; i++) {
			System.out.println();
			for (int s=0; s<maxc; s++) {
				System.out.print(matriz[i][s]);
			}
		}
	}
	
	public static void impRes(int [] res) {
		System.out.println();
		System.out.print("arreglo ");
		for (int i=0; i<maxc; i++) {
			System.out.print(res[i]);
		}
	}
	
	public static int inicio_sec(int [][] matriz, int f, int ant, int valor, int longitud) {
		
		int inicio=-1;
		int s=ant;
		int l_long=0;
			
		while(s<maxc-1 && inicio==-1) {
			
			if(matriz[f][s] == matriz[f][s+1]) {
				inicio=s;
				l_long++;
				while(matriz[f][s] == matriz[f][s+1]) {
					l_long++;
					s++;
				}
			}
				
			if(l_long==longitud && inicio!=-1 && matriz[f][inicio]==valor) {
				inicio=-1;
			}
			s++;
		}
		return inicio;
	}

	public static int fin_sec(int [][] matriz, int f, int inicio) {
		
		int fin=-1;
		
		if(inicio!=-1) {
			fin=inicio;
			while(matriz[f][inicio] == matriz[f][inicio+1]) {
				fin++;
				inicio++;
			}
		}
		return fin;
	}

	public static int cant_rep(int [][] matriz, int valor, int longitud) {
		
		int cant=0;
		int s=0;
		int l_long=0;
		
		for(int i=0; i<maxf; i++) {
			
			while(s<maxc-1) {
				if(matriz[i][s]==valor) {
					l_long++;
					while(matriz[i][s]==matriz[i][s+1] && s<maxc-1) {
						l_long++;
						s=s+1;
					}
				}
				if(matriz[i][s]==valor && l_long==longitud) {
					cant++;
				}
				s++;
			}
			s=0;
		}return cant;
	}

	public static void agregar_res(int [] res, int valor, int longitud) {
		for(int i=0; i<longitud; i++) {
			res[i]=valor;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void llenar_inventario(int [][] inventario) {
		for(int i=0; i<100; i++) {
			inventario[0][i]=i;
			inventario[1][i]= (int) Math.floor(Math.random()*9);
		}
	}
	
	public static void segundo_parcial(int [][] inventario) {
		
		llenar_inventario(inventario);
		
		int valor_cantidad = 7;

			while(valor_cantidad>=0) {
				for(int i=0; i<100; i++) {
					if(inventario[1][i]==valor_cantidad) {
						System.out.println();
						System.out.print("|"+i+"|");
						System.out.print(inventario[1][i]+"|");
						System.out.println();
					}
				}
				valor_cantidad--;
			}
		
		segunda_parte(inventario);
	}
	
	public static void segunda_parte(int [][] inventario) {
		
		llenar_inventario(inventario);
		
		int columna_a_eliminar=50;
		
		for(int i=columna_a_eliminar; i<99; i++) {
			inventario[0][i]=inventario[0][i+1];
			inventario[1][i]=inventario[1][i+1];
		}
		inventario[0][99]=-1;
		inventario[1][99]=-1;
		
		for(int i=0; i<2; i++) {
			for(int s=0; s<100; s++) {
				System.out.print(inventario[i][s]);
			}
			System.out.println();
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void sp(int [][] matriz, int f) {
		int i=0;
		int cant=4;
		while(i<20) {
			if(matriz[f][i]==1) {
				int inicio=i;
				int contador=0;
				while(matriz[f][i]!=0) {
					contador++;
					i++;
				}
				if(contador==cant && matriz[f][i-1]==1) {
					invertir_secuencia(matriz, f, inicio, i-1);
				}
			}
			i++;
		}
	}
	
	public static void invertir_secuencia(int [][] matriz, int f, int inicio, int fin) {
		int aux=0;
		while(inicio<fin && fin>inicio) {
			aux=matriz[f][inicio];
			matriz[f][inicio]=matriz[f][fin];
			matriz[f][fin]=aux;
			inicio++;
			fin--;
		}
	}

	public static void segundo_parcial_2018(int [][] matriz) {
		for(int i=0; i<5; i++) {
			sp(matriz,i);
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void final_regular(int [][] matriz) { 
		for(int i=0; i<5; i++) {
			fr(matriz,i);
		}
	}

	public static void fr(int [][] matriz, int f) {
		int i=0;
		while(i<20) {
			if(matriz[f][i]!=0) {
				int inicio=i;
				while(matriz[f][i]<matriz[f][i+1] && matriz[f][i+1]!=0) {
					i++;
				}
				if(matriz[f][i+1]==0) {
					eliminar_secuencia(matriz, f, inicio, i);
				}
			}
			i++;
		}
	}

	public static void eliminar_secuencia(int [][] matriz, int f, int inicio, int fin) {
		int longitud=fin+1-inicio;
		int relleno=longitud;
		while(longitud>0) {	
			for(int i=inicio; i<maxc-1; i++) {
				matriz[f][i]=matriz[f][i+1];
			}
			inicio++;
			longitud--;
		}
	}

}//class
