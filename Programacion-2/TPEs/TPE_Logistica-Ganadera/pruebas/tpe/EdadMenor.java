package tpe;

public class EdadMenor implements CriterioAnimal {
	private int edad;
	
	public EdadMenor(int e) {
		edad = e;
	}

	@Override
	public boolean cumple(Animal animal) {
		return animal.getEdad() < edad;
	}

}
