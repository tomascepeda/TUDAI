package tp7;

public class SistemaArchivos {
    private Carpeta raiz;

    public SistemaArchivos(){
        this.raiz = new Carpeta ("raiz");
    }

    public void addElemento(ElementoSA elem){
        raiz.addElemento(elem);
    }

    public int cantElementos(){
        return raiz.cantidadElementos();
    }

    public static void main(String[] args) {
        SistemaArchivos windows = new SistemaArchivos();

        Carpeta tudai = new Carpeta("Tudai");
        Carpeta anio1 = new Carpeta("1er anio");
        Carpeta anio2 = new Carpeta("2do anio");
        Carpeta prog2 = new Carpeta("Prog 2");
        Carpeta fotos = new Carpeta("Fotos");
        Archivo parcial = new Archivo("Parcial", "doc", 300.1);
        Archivo recu = new Archivo("Recuperatorio", "pdf", 600.1);
        Archivo prefi = new Archivo("Prefinal", "txt", 5000.1);
        Archivo fotito = new Archivo("picture", "jpg", 12.6);

        windows.addElemento(tudai);
        windows.addElemento(fotos);
        windows.addElemento(fotito);

        tudai.addElemento(anio1);
        tudai.addElemento(anio2);
        anio1.addElemento(prog2);
        prog2.addElemento(parcial);
        prog2.addElemento(recu);
        prog2.addElemento(prefi);
        
        //TODO 

        
        int c = windows.cantElementos();
        System.out.println("Hay "+c+" elementos en el sistema");
        System.out.println(prefi.getUbicacion());

    }
}
