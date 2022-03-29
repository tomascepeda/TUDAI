package tpe;
public class EdadMayor implements CriterioAnimal {
	
	private int edad;
	
	public EdadMayor(int e) {
		edad = e;
	}

	@Override
	public boolean cumple(Animal animal) {
		return animal.getEdad() > edad;
	}

}
