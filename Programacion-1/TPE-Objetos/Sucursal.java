
public class Sucursal {
	
	int matriz[][] = new int[3][5];
	
	Sucursal(){
		precargarMatriz();
	}
	
	Sucursal(int n, int min, int cant, int max){
		configurarProducto(n,min,cant,max);
	}
	
	public void precargarMatriz() {
		for (int i=0; i<=2; i++) {
			for (int s=0; s<=4; s++) {
				matriz[i][s]=(-1);
			}
		} 
	}
	
	public void listado() {
		for (int i=0; i<=4; i++) {
			System.out.print("id del producto: "+i);
			System.out.print(" min: "+matriz[1][i]);
			System.out.print(" cant: "+matriz[0][i]);
			System.out.print(" max: "+matriz[2][i]);
			System.out.println();
		}
	}

	public void configurarProducto(int n, int min, int cant, int max){
		matriz[0][n]= cant;
		matriz[1][n]= min;
		matriz[2][n]= max;
	}
	
	public void venderProducto(int n, int cant) {
		if (cant<=matriz[0][n] && matriz[0][n]!=-1) {
			matriz[0][n]=matriz[0][n]-cant;
		}
	}        
	
	public void necesitaReposicion() {
		int h=0;
		int c=0;
		for (int i=0; i<=4; i++){
			if (matriz[0][i]<matriz[1][i]) {
				c=(matriz[2][i]+matriz[1][i])/2;
				c=c-matriz[0][i];
				System.out.print(" necesita reponer el producto "+i+": cantidad: "+c); 
				h++;
			}
		}
		if (h==0) {
			System.out.println(" no necesita reposicion");
		}
	}

	public int necesitaReabastecer(int p) {
		int reposicion=0;
		if (matriz[0][p]<matriz[1][p]) {
			reposicion=(((matriz[1][p]+matriz[2][p])/2)-matriz[0][p]);
		}
		return reposicion;
	}
	
	public void agregarCantidad(int cant, int prod){
		matriz[0][prod]=matriz[0][prod]+cant;
	}
	
	public int retMax(int p) {
		return matriz[2][p];
	}
	
	public int retMaxCant(int p) {
		return matriz[0][p];
	}

	public void sumarProducto(int cuenta, int p) {
		while (matriz[0][p]<matriz[2][p]&&cuenta>0) {
			matriz[0][p]=matriz[0][p]+1;
			cuenta--;
		}
	}
}//close class