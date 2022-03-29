package parcialito4.criterios;

import parcialito4.Pelicula;

import java.util.ArrayList;

public class CriterioContieneActor implements Criterio{
    String elactor;

    public CriterioContieneActor(String elActorQueBusco){
        elactor = elActorQueBusco;
    }

    @Override
    public boolean cumple(Pelicula peli) {
        return peli.contieneActor(elactor);
    }
}
