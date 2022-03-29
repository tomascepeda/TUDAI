package tp7;

import java.time.LocalDate;

public abstract class ElementoSA {
    protected String nombre;
    protected LocalDate fCreacion;
    protected LocalDate fModificacion;
    protected String ubicacion;

    public ElementoSA(String nombre) {
        this.nombre = nombre;
        this.fCreacion = LocalDate.now();
        this.fModificacion = LocalDate.now();
    }

    protected void setfModificacion() {
        this.fModificacion = LocalDate.now();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.setfModificacion();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getfCreacion() {
        return fCreacion;
    }
    
    public String getUbicacion() {
    	return this.ubicacion;
    }

    public LocalDate getfModificacion() {
        return fModificacion;
    }
    
    protected void updateUbicacion(String ruta) {
    	this.ubicacion = ruta + this.nombre + "/";
    }

    public abstract double getTamanio();
    public abstract int cantidadArchivos();
    public abstract int cantidadElementos();
    public abstract int cantidadCarpetas();
}
