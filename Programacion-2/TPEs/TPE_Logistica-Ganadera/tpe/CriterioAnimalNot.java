package tpe;

public class CriterioAnimalNot implements CriterioAnimal {
	private CriterioAnimal c;
	
	public CriterioAnimalNot(CriterioAnimal c1) {
		c = c1;
	}

	@Override
	public boolean cumple(Animal animal) {
		return !c.cumple(animal);
	}

}
