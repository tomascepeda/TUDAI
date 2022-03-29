package parcialito4;

import java.util.ArrayList;
import java.util.Vector;

public class Pelicula {
    private String titulo;
    private String sinopsis;
    private String director;
    private int anio;
    private int duracion;
    private int edadMin;
    private ArrayList<String> generos;
    private ArrayList<String> actores;

    public Pelicula(String titulo, String sinopsis, String director,
                    int anio, int duracion, int edadMin) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.anio = anio;
        this.duracion = duracion;
        this.edadMin = edadMin;
        this.generos = new ArrayList<>();
        this.actores = new ArrayList<>();
    }

    public Pelicula(String titulo, String sinopsis, String director,
                    int anio, int duracion, int edadMin,
                    Vector<String> actores, Vector<String> genero) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.anio = anio;
        this.duracion = duracion;
        this.edadMin = edadMin;
        this.generos = new ArrayList<>(generos);

        this.actores = new ArrayList<>();
        this.actores.addAll(actores);
    }

    public ArrayList<String> getGeneros(){
        //return this.generos; //ERROR GRAVE
        return new ArrayList<>(generos);
    }

    public boolean contieneGenero(String genero){
        return generos.contains(genero);
    }
    public boolean contieneActor(String actor){
        return actores.contains(actor);
    }

    public int getAnio() {
        return anio;
    }
}
