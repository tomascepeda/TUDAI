package practica;

public class Electrodomestico {

	private String nombre, color;
	private int precio, consumo, peso;
	
	public Electrodomestico() {
		super();
		color = "gris plata";
		consumo = 10;
		precio = 100;
		peso = 2;
	}

	public Electrodomestico(String nombre, String color, int precio, int consumo, int peso) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.precio = precio;
		this.consumo = consumo;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public boolean bajoConsumo() {
		if(consumo < 45) {
			return true;
		}else {
			return false;
		}
	}
	
	public double getBalance() {
		return precio / peso;
	}
	
	public boolean altaGama() {
		double balance = getBalance();
		if(balance > 3) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
