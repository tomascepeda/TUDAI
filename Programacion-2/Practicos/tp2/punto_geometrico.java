package practica;

public class punto_geometrico {

	private int x, y;

	public punto_geometrico() {
		super();
		x = 0;
		y = 0;
	}
	
	public punto_geometrico(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void desplazarPlano(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getdDistanciaEuclidea(int x, int y) {
		return ((this.x - x) * (this.x - x)) + ((this.y - y) * (this.y - y));
	}
	
}
