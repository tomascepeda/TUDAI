package prefinal2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class final2019 { //se pide invertir CANT secuencias de la matriz comenzando del final
	
	final static int nfil=2;
	final static int ncol=7; 

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int [][] mat = new int [nfil][ncol];
		int cant=-1;
		cargar_matriz(mat);
		while(cant<1) {
			try {
				System.out.println("CANT:");
				cant = new Integer(entrada.readLine());
			}catch(Exception exc) {
				System.out.println(exc);
			}
		}
		buscar_secuencias(mat, cant);
		mostrar(mat);
	}
	
	public static void cargar_matriz(int [][] mat) {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			int carga=0;
			boolean valido=false;
			System.out.println("CARGA LA MATRIZ KPO:");
			for(int i=0; i<nfil; i++) {
				for(int s=0; s<ncol; s++) {
					try {
						System.out.println("INGRESA VALOR");
						carga = new Integer(entrada.readLine());
						while(valido==false) {
							if(carga>=4&&carga<=9||carga==0) {
								mat[i][s]=carga;
								valido=true;
							}else {
								System.out.println("LE ERRASTE BOLUDO");
								carga = new Integer(entrada.readLine());
							}
						}
						valido=false;
					}catch(Exception exc) {
						System.out.println(exc);
					}
				}
				System.out.println("OTRA FILA MASTER");
			}
		}
	
	public static void buscar_secuencias(int [][] mat, int cant) {
		int i=ncol-1;
		int inicio=-1;
		int fin=-1;
		int f=nfil-1;
		while(cant>0&&f>=0) {
			while(cant>0&&i>0) {
				while(i>0&&mat[f][i]==0) {
					i--;
				}
				if(mat[f][i]!=0) {
					inicio=i;
					while(i>0&&mat[f][i]!=0) {
						fin=i;
						i--;
					}
				}
				if(inicio!=-1&&fin!=-1) {	
					invertir_secuencia(mat,f,inicio,fin);
					cant--;
				}
				i--;
				fin=-1;
				inicio=-1;
			}
			f--;
			i=ncol-1;
		}
	}
	
	public static void invertir_secuencia(int [][] mat, int f, int inicio, int fin) {
		int aux=0;
		while(inicio>fin&&fin<inicio) {
			aux=mat[f][fin];
			mat[f][fin]=mat[f][inicio];
			mat[f][inicio]=aux;
			fin++;
			inicio--;
		}
	}

	public static void mostrar(int [][] mat) {
		for ( int i = 0; i < nfil; i++) {
			System.out.print("|");
			for ( int j = 0; j < ncol; j++ ) {
				System.out.print(mat[i][j] + "|");
			}
			System.out.println();
		}
	}

}//class
