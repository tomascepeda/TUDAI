package tpe;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Grupo empresa = new Grupo("Nombre empresaa");
		Grupo otraEmpresa = new Grupo("nombre empresa");
		Rodeo rodeo1   = new Rodeo();
		Rodeo rodeo2   = new Rodeo();
		Rodeo rodeo3   = new Rodeo();
		Rodeo rodeo4   = new Rodeo();
		
		Animal a1 = new Animal(
				12, //edad
				650, //peso
				"a", //raza
				true, //macho
				false, //capado 
				0 // cantidad de hijos
				);
		Animal a2 = new Animal(12,444,"b",false,true,0);
		Animal a3 = new Animal(12,555,"b",false,true,0);
		Animal a4 = new Animal(12,666,"b",false,true,0);
		Animal a5 = new Animal(12,456,"b",false,true,0);
		Animal a6 = new Animal(12,123,"otro",false,true,0);
		Animal a7 = new Animal(12,321,"c",false,true,0);
		Animal a8 = new Animal(12,650,"c",false,true,0);
		Animal a9 = new Animal(12,650,"c",false,true,0);
		Animal a10 = new Animal(13,650,"x",true,false,4);
		
		empresa.addEslabon(a1);
		
		rodeo1.addAnimal(a2);
		rodeo1.addAnimal(a3);
		rodeo1.addAnimal(a4);
		
		empresa.addEslabon(rodeo1);
		
		rodeo2.addAnimal(a5);
		
		otraEmpresa.addEslabon(rodeo2);
		
		rodeo3.addAnimal(a6);
		rodeo3.addAnimal(a7);
		
		otraEmpresa.addEslabon(rodeo3);
		
		rodeo4.addAnimal(a8);
		rodeo4.addAnimal(a9);
		rodeo4.addAnimal(a10);
		
		otraEmpresa.addEslabon(rodeo4);
		
		empresa.addEslabon(otraEmpresa);
		
		
		double promedioPeso = empresa.getPesoProm(); // guardo el promedio de peso de las vacas que estan en la empresa
		CriterioGrupo pesoMayor = new PesoPromMayor(651); // creo el criterio de comparacion
		boolean puedeVender = empresa.puedeVender(pesoMayor); // guardo un boolean que indica si puede o no
		
		System.out.println(
				"El promedio de peso es: " + promedioPeso + " y puedeVender: " + puedeVender
				);
		
		
		Camion camion = new Camion(1,new EsRaza("otro"));// creo la condicion de que el camion solo acepte vacas de 'otro' con 1 capacidad
		
		
		
		empresa.mostrarIDS(); //muestra los ID's de todas las vacas, 1,2,3,4
		
		List<Animal> animalesDevueltos = //meto en esta lista llenarCamion
		empresa.llenarCamion(// llenarCamion devuelve una lista de animales que cumplan con la condicion y una cantidad, y los borra de la empresa, NO los agrega al camion
				camion.getCapacidad(), camion.getCriterio() // aca paso la cantidad y la condicion
				);
		
		empresa.mostrarIDS(); // vuelvo a mostrar y 'otro' no esta se la llevo el camion,  1,2,4

		CriterioAnimal mayor8Meses        = new EdadMayor(7);
		CriterioAnimal menor8Meses        = new EdadMenor(8);
		CriterioAnimal mayorAnio          = new EdadMayor(12);
		CriterioAnimal menorAnio          = new CriterioAnimalNot(mayorAnio);
		CriterioAnimal entreOchoyAnio     = new CriterioAnimalAnd(menorAnio,mayor8Meses);
		CriterioAnimal mayor2Anios        = new EdadMayor(24);
		CriterioAnimal menor2Anios        = new CriterioAnimalNot(mayor2Anios);
		CriterioAnimal menor4Anios        = new EdadMenor(49);
		CriterioAnimal mayor15meses       = new EdadMayor(15);
		CriterioAnimal parioTernero       = new CantidadHijosMayor(0);
		CriterioAnimal noParioTernero     = new CriterioAnimalNot(parioTernero);
		CriterioAnimal macho              = new EsMacho(true);
		CriterioAnimal hembra             = new EsMacho(false);
		CriterioAnimal capado             = new EsCapado(true);
		CriterioAnimal hembra15meses      = new CriterioAnimalAnd(hembra,mayor15meses);
		CriterioAnimal machoCapado        = new CriterioAnimalAnd(macho,capado);
		CriterioAnimal mayor4Anios        = new EdadMayor(48);
		CriterioAnimal noCapado           = new EsCapado(false);
		
		Clasificacion lechal     = new Clasificacion("lechal",menor8Meses);
		Clasificacion ternero    = new Clasificacion("ternero",entreOchoyAnio);
		Clasificacion aniojo     = new Clasificacion("aniojo",new CriterioAnimalAnd(mayorAnio,menor2Anios) );
		Clasificacion novillo    = new Clasificacion("novillo",new CriterioAnimalAnd(mayor2Anios,menor4Anios));
		Clasificacion cebon      = new Clasificacion("cebon",new CriterioAnimalAnd(menorAnio,capado));
		Clasificacion vaquillona = new Clasificacion("vaquillona", new CriterioAnimalAnd(hembra15meses,noParioTernero) );
		Clasificacion vaca       = new Clasificacion("vaca",new CriterioAnimalAnd(mayor15meses,parioTernero) );
		Clasificacion buey       = new Clasificacion("buey", new CriterioAnimalAnd(machoCapado,mayor4Anios) );
		Clasificacion toro       = new Clasificacion("toro", new CriterioAnimalAnd(macho,noCapado) );
		
		SistemaGanadero sistema = new SistemaGanadero();
		
		sistema.addClasificacion(lechal);
		sistema.addClasificacion(ternero);
		sistema.addClasificacion(aniojo);
		sistema.addClasificacion(novillo);
		sistema.addClasificacion(cebon);
		sistema.addClasificacion(vaquillona);
		sistema.addClasificacion(vaca);
		sistema.addClasificacion(buey);
		sistema.addClasificacion(toro);
		
		List<String> clasificaciones = sistema.getClasificacion(a1);
		
		for (String s : clasificaciones) 
			System.out.println(s);
	}
	
	public static void printArrayAnimales(ArrayList<Animal> animales) {
		System.out.print("|");
		for (Animal animal : animales) {
			System.out.print( animal.getRaza() + "|");
		}
	}

}
