package tp7;

import java.time.LocalDate;

public class Archivo extends ElementoSA {
    private String extension;
    private double tamanio;

    //NOTA: NO MODELAMOS EL CONTENIDO DEL ARCHIVO

    public Archivo(String nombre, String extension, double tamanio){
        super(nombre);
        this.extension = extension;
        this.tamanio = tamanio;
    }

    public void setExtension(String extension) {
        this.extension = extension;
        this.setfModificacion();
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
        this.setfModificacion();
    }

    public String getExtension() {
        return extension;
    }

    public double getTamanio() {
        return tamanio;
    }

    @Override
    public int cantidadArchivos() {
        return 1;
    }

    @Override
    public int cantidadElementos() {
        return 1;
    }

    @Override
    public int cantidadCarpetas() {
        return 0;
    }
    
    public String getUbicacion() {
    	return this.ubicacion + "." + this.extension;
    }
    
    protected void updateUbicacion(String ruta) {
    	this.ubicacion = ruta + this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Archivo otro = (Archivo) obj;
            //SIMPLIFICACION
            return this.getNombre().equals(otro.getNombre()) &&
                    this.getExtension().equals(otro.getExtension()) &&
                    this.getTamanio() == otro.getTamanio();

        } catch (Exception e){
            return false;
        }
    }
}
