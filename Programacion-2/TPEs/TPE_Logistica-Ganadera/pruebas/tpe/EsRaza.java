package tpe;
public class EsRaza implements CriterioAnimal {
	
	private String raza;
	
	public EsRaza(String r) {
		raza = r;
	}

	@Override
	public boolean cumple(Animal animal) {
		return raza.equals( animal.getRaza() );
	}

}
