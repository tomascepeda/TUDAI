package tpe;

public class EsMacho implements CriterioAnimal {
	private boolean macho;
	
	public EsMacho(boolean m) {
		macho = m;
	}

	@Override
	public boolean cumple(Animal animal) {
		return animal.esMacho() == macho;
	}

}
