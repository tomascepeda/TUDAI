package tpe;
public class PesoMayor implements CriterioAnimal {
	private double peso;
	
	public PesoMayor(double p) {
		peso = p;
	}

	@Override
	public boolean cumple(Animal animal) {
		return animal.getPeso() > peso;
	}

}
