package practico6;

import java.util.List;

public class Arbol{

    private Nodo raiz;

    public Arbol( int valor ) {
        this.raiz = new Nodo( valor );
    }

    public Arbol( Nodo raiz ) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    private void addNodo( Nodo nodo, Nodo raiz ) {
        if ( raiz == null ) {
            this.setRaiz(nodo);
        }
        else {
            if ( nodo.getValor() <= raiz.getValor() ) {
                if (raiz.getHojaIzquierda() == null) {
                    raiz.setHojaIzquierda(nodo);
                }
                else {
                    addNodo( nodo , raiz.getHojaIzquierda() );
                }
            }
            else {
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                }
                else {
                    addNodo( nodo, raiz.getHojaDerecha() );
                }
            }
        }
    }
    
    public void addNodo( Nodo nodo ) {
        this.addNodo( nodo , this.raiz );
    }
    
    private void recorrer(Nodo nodo /* , AccionEjecutable accion */) {	//la interface <<AccionEjecutable>> tiene el metodo ejecutarNodo(Nodo nodo);
    	if(nodo.getHojaIzquierda() != null)
    		recorrer(nodo.getHojaIzquierda());
    	/* accion. */ejecutarNodo(nodo);
    	if(nodo.getHojaDerecha() != null) 
    		recorrer(nodo.getHojaDerecha());
    }
    
    public void imprimir() {	//deberia ser una clase que implemente <<AccionEjecutable>>
    	recorrer(this.raiz);
    }

    private void ejecutarNodo(Nodo nodo) {	//ejemplo de implementacion de la funcionalidad de la clase imprimir
	System.out.println(nodo.getValor());	
    }
	
}//class
