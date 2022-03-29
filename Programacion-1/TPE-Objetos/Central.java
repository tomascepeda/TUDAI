
public class Central {
	
	int matriz[][] = new int[3][5];
	
	final static int MAXSUCURSALES = 10;
	
	private Sucursal[] nSucursales = new Sucursal[MAXSUCURSALES];
	
	private int cantSucursales = 0;
	
	public void agregarSucursal(Sucursal sucursal){
		if (cantSucursales<MAXSUCURSALES){
			nSucursales[cantSucursales] = sucursal;
			cantSucursales++;
		} else System.out.println("Maximo sucursales");
	}
	
	public void precargarSucursales() {
		for (int i=0; i<cantSucursales; i++) {
			nSucursales[i].precargarMatriz();
		}
	}
	
	public void listado() {
		System.out.println();
		System.out.println("Central");
		for (int i=0; i<=4; i++) {
			System.out.print("id del producto: "+i);
			System.out.print(" min: "+matriz[1][i]);
			System.out.print(" cant: "+matriz[0][i]);
			System.out.print(" max: "+matriz[2][i]);
			System.out.println();
		}
	}
	
	public void listarRed() {
		listado();
		for (int i=0; i<cantSucursales; i++) {
			System.out.println("Sucursal: "+i);
			nSucursales[i].listado();
		}
	}
	
	public void necesitanReposicion() {
		for (int i=0; i<cantSucursales; i++) {
			System.out.println();
			System.out.print("Sucursal "+i+":");
			nSucursales[i].necesitaReposicion();
		}
	}
	
	public void reponerSucursales() {
		for (int i=0; i<cantSucursales; i++) {
			for (int p=0; p<=4; p++) {
				int reabastecer = nSucursales[i].necesitaReabastecer(p);
				if (reabastecer>0) {
					if (matriz[0][p]>=reabastecer) {
						matriz[0][p]=matriz[0][p]-reabastecer;
						nSucursales[i].agregarCantidad(reabastecer,p);
					}else {
						System.out.println("no hay cantidad suficiente para reabastecer la sucursal "+i);
					}
				}
			}
		}
	}
	
	public void configurarProducto(int n, int min, int cant, int max){
		matriz[0][n]= cant;
		matriz[1][n]= min;
		matriz[2][n]= max;
	}
	
	public int sumarMaximos(int p) {
		int cont=0;
		for (int i=0; i<cantSucursales; i++) {
			cont=cont+nSucursales[i].retMax(p);
		}
		return cont+matriz[2][p];
	}
	
	public int sumarCantidades(int p) {
		int cont=0;
		for (int i=0; i<cantSucursales; i++) {
			cont=cont+nSucursales[i].retMaxCant(p);
		}
		return cont+matriz[0][p];
	}
	
	public int adquirirProductos(int p) {
		return sumarMaximos(p)-sumarCantidades(p);
	}
	
	public void adquirirProducto(int p) {
		int cuenta=0;
		cuenta=adquirirProductos(p);
		System.out.println("cantidad a adquirir del producto "+p+": "+cuenta);
		while (matriz[0][p]<matriz[2][p]&&cuenta>0) {
			matriz[0][p]=matriz[0][p]+1;
			cuenta--;
		}
		for (int i=0; i<cantSucursales; i++) {
			nSucursales[i].sumarProducto(cuenta,p);
		}
	}
}//close class