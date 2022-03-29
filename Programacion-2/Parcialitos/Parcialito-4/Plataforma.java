package parcialito4;

import parcialito4.criterios.Criterio;

import java.util.ArrayList;

public class Plataforma {
    private ArrayList<Pelicula> peliculas;
    Criterio rentabilidad;

    public Plataforma(){
        peliculas = new ArrayList<>();
    }

    public void setCriterio(Criterio nuevo){
        rentabilidad = nuevo;
    }

    public ArrayList<Pelicula> buscar(Criterio criterio){
        ArrayList<Pelicula> lasQueCumplen = new ArrayList<>();
        for(Pelicula peli:peliculas){
            if (criterio.cumple(peli))
                lasQueCumplen.add(peli);
        }
        return  lasQueCumplen;
    }

    public void addPelicula(Pelicula p){
        if (esRentable(p))
            peliculas.add(p);
    }

    public boolean esRentable(Pelicula peli){
        return rentabilidad.cumple(peli);
    }
}
