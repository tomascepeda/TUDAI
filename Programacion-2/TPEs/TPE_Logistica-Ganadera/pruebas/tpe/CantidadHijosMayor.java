package tpe;

public class CantidadHijosMayor implements CriterioAnimal {
	private int cantHijos;
	
	public CantidadHijosMayor(int c) {
		cantHijos = c;
	}

	@Override
	public boolean cumple(Animal animal) {
		return animal.getCantidadHijos() > cantHijos;
	}

}
