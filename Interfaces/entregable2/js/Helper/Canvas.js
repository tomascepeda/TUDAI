class Canvas
{
    static canvas;
    static ctx;
    static ancho;
    static alto;


    static cargarCanvas()
    {
        this.canvas = document.querySelector("#tablero");
        this.ctx = this.canvas.getContext("2d");
        this.ancho = screen.width;
        this.canvas.width = this.ancho;
        this.alto = ScreenConfig.tamTamblero+ScreenConfig.marginTop;
        this.canvas.height = this.alto;
    }


    static getCanvas()
    {
        return this.canvas;
    }
    static getContext()
    {
        return this.ctx;
    }
    static getAlto()
    {
        return this.alto;
    }
    static getAncho()
    {
        return this.ancho;
    }
    
    static dibujarImagen(imagen,x,y,ancho,alto)
    {
        this.ctx.drawImage(imagen,x,y,ancho,alto);
    }

    static dibujarTexto(texto,x,y,color,fuente,valorAlineacion)
    {
        this.ctx.font = fuente;
        this.ctx.textAlign = valorAlineacion;
        this.ctx.fillStyle = color;
        this.ctx.fillText(texto, x, y);
    }

    static agregarEvento(e, callback)
    {
        this.canvas.addEventListener(e,callback);
    }

    static limpiar()
    {
        this.ctx.clearRect(0, 0, this.ancho, this.alto);
    }






}
