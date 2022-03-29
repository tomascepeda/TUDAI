package parcialito4.criterios;

import parcialito4.Pelicula;

public class CriterioAnd implements Criterio{
    Criterio c1, c2;

    public CriterioAnd(Criterio c1, Criterio c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean cumple(Pelicula peli) {
        return c1.cumple(peli) && c2.cumple(peli);
    }
}
