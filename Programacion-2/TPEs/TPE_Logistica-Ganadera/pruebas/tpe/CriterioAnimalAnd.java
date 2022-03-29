package tpe;

public class CriterioAnimalAnd implements CriterioAnimal {
	private CriterioAnimal c1;
	private CriterioAnimal c2; 
	
	public CriterioAnimalAnd(CriterioAnimal cr1,CriterioAnimal cr2) {
		c1 = cr1;
		c2 = cr2;
	}

	@Override
	public boolean cumple(Animal animal) {
		return c1.cumple(animal) && c2.cumple(animal);
	}
}
