package parcialito4.criterios;

import parcialito4.Pelicula;

public class CriterioAnioMayor implements Criterio{
    int anioQueBusco;

    public CriterioAnioMayor(int anio){
        anioQueBusco=anio;
    }

    @Override
    public boolean cumple(Pelicula peli) {
        return anioQueBusco > peli.getAnio();
    }
}
