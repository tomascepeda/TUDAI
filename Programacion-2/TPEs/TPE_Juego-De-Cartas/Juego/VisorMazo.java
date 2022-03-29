package Juego;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VisorMazo {

    public static Mazo armarMazo(String jsonFile) {    	
    	Mazo mazo = new Mazo(); // Preparo el mazo
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) { // Crea las cartas a partir del json
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                
                Carta c = new Carta(nombreCarta);
                String atributosStr = "";
                for (String nombreAtributo:atributos.keySet()) { // Agrega los atributos a la carta
                	
                	atributosStr = atributosStr + nombreAtributo + ": " +
                    atributos.getInt(nombreAtributo) + "; ";     
                	Atributo a = new Atributo(nombreAtributo.toLowerCase(),atributos.getInt(nombreAtributo));
                	c.addAtributo(a);
                } // Termina de agregar atributos
                    
                // TODO del object Carta
                mazo.addCarta(c); // Agrego al mazo
            
            } // Termina de recorrer las cartas del json

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mazo;
    }

}