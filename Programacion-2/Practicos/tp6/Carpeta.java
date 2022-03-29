package tp7;

import java.time.LocalDate;
import java.util.ArrayList;

public class Carpeta extends ElementoSA{

    private ArrayList<ElementoSA> contenido;

    public Carpeta(String nombre){
        super(nombre);
        this.contenido = new ArrayList<>();
        this.ubicacion = "C:/";
    }

    public void addElemento(ElementoSA elem){
    	elem.updateUbicacion(ubicacion);
        contenido.add(elem);
    }

    public boolean contieneElemento(ElementoSA elquebusco){
        //for (ElementoSA elem:contenido){
        //    cant += elem.cantidadArchivos();
        //}
        return false;
    }

    /**
     * Este método retorna todo el camino desde la raiz hasta este elemento
     * @return
     */
    public String rutaCompleta(){
        return null;
    }

    public boolean vacia(){
        return false;
    }

    @Override
    public int cantidadArchivos(){
        int cant = 0;
        for (ElementoSA elem:contenido){
            cant += elem.cantidadArchivos();
        }
        return cant;
    }

    @Override
    public int cantidadElementos() {
        int cant = 0;
        for (ElementoSA elem:contenido){
            cant += elem.cantidadElementos();
        }
        return cant + 1; //(+YO);
    }

    @Override
    public int cantidadCarpetas() {
        int cant = 0;
        for (ElementoSA elem:contenido){
            cant += elem.cantidadCarpetas();
        }
        return cant + 1; //(+YO);
    }

    public double getTamanio(){
        double tamanioTotal = 0.0;
        for(ElementoSA elem:contenido){
            tamanioTotal += elem.getTamanio();
        }
        return tamanioTotal;

        //ESTO ESTARIA ****PESIMO****
        //for (ElementoSA elem:contenido){
            //si sos un archivo
            //tamanio total += elem.getTamano
            //si sos una carpeta
       // }
    }


    @Override
    public boolean equals(Object obj) {
        try {
            Carpeta otra = (Carpeta) obj;
            //SIMPLIFICACION
            return this.getNombre().equals(otra.getNombre()) &&
                    this.cantidadArchivos() == otra.cantidadArchivos();

        } catch (Exception e){
            return false;
        }
    }
}
