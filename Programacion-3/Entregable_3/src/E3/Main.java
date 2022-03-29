package E3;

public class Main {

	public static void main(String[] args) {
		
		Ciudad pehuajo = new Ciudad(1,"Pehuajo");
		pehuajo.setTieneBalanza(true);
		
		Ciudad ayacucho = new Ciudad(2,"Ayacucho");
		ayacucho.setTieneBalanza(false);
		
		Ciudad tandil = new Ciudad(3,"Tandil");
		tandil.setTieneBalanza(true);
		
		Ciudad olavarria = new Ciudad(4,"Olavarria");
		olavarria.setTieneBalanza(true);
		
		Ciudad mardel = new Ciudad(5,"Mar del Plata");
		mardel.setTieneBalanza(true);
		
		Ciudad rauch = new Ciudad(6,"Rauch");
		rauch.setTieneBalanza(false);
		
		Ciudad bolivar = new Ciudad(7,"Bolivar");
		bolivar.setTieneBalanza(false);
		
		Ciudad azul = new Ciudad(8,"Azul");
		azul.setTieneBalanza(false);
		
		Mapa mapa = new Mapa();
		
		mapa.addCiudad(pehuajo);
		mapa.addCiudad(ayacucho); 
		mapa.addCiudad(tandil); 
		mapa.addCiudad(olavarria);
		mapa.addCiudad(mardel);
		mapa.addCiudad(rauch);
		mapa.addCiudad(bolivar);
		mapa.addCiudad(azul);
		
		mapa.addRuta(pehuajo, bolivar, 70);
		mapa.addRuta(pehuajo, ayacucho, 540);
		mapa.addRuta(ayacucho, rauch, 50);
		mapa.addRuta(ayacucho, tandil, 70);
		mapa.addRuta(tandil, rauch, 60);
		mapa.addRuta(tandil, olavarria, 130);
		mapa.addRuta(tandil, mardel, 200);
		mapa.addRuta(olavarria, rauch, 210);
		mapa.addRuta(olavarria, bolivar, 140);
		mapa.addRuta(bolivar, azul, 100);
		
		// se considera camino optimo a aquel camino que posea:
		// la menor distancia entre origen y destino, y solo atraviese 1 balanza (sin contar la de origen)
		
		System.out.println(mapa.encontrarCamino(bolivar, ayacucho)); 
		
		System.out.println(mapa.encontrarCamino(azul, ayacucho)); 
		System.out.println(mapa.encontrarCamino(rauch, mardel)); 
		System.out.println(mapa.encontrarCamino(mardel, pehuajo)); 
		
		mapa.borrarCiudad(ayacucho); 
		mapa.borrarRuta(tandil, rauch); 

		System.out.println(mapa.encontrarCamino(mardel, pehuajo)); 
		System.out.println(mapa.encontrarCamino(pehuajo, rauch)); 
		System.out.println(mapa.encontrarCamino(mardel, ayacucho)); 

	}

}
