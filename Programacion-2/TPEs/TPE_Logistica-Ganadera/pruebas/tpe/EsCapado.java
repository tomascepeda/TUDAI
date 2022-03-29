package tpe;

public class EsCapado implements CriterioAnimal {
	private boolean capado;
	
	public EsCapado(boolean c) {
		capado = c;
	}

	@Override
	public boolean cumple(Animal animal) {
		return animal.esCapado() == capado;
	}

}
