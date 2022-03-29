class Ficha
{
    constructor(posx, posy, tamanio,img, jugador)
    {
        this.img = img;
        this.posx = posx;
        this.posy = posy
        this.radius = tamanio/2;
        this.colocada = false;
        this.tamanio = tamanio;
        this.jugador = jugador;
    }



    actualizarFicha(x,y)
    {
        this.posx = x;
        this.posy = y;
    }

    setImg(img){
        this.img = img;
    }

    setPosition(posx,posy){
        this.posx = posx;
        this.posy = posy;
    }

    getX(){
        return this.posx;
    }

    getY(){
        return this.posy;
    }

    getRadius()
    {
        return this.radius;
    }

    isPointInside(x, y){

        let extremoIzquierdoX = this.posx - (this.radius / 2) 
        let extremoDerechoX = this.posx + (this.radius / 2)

        let extremoIzquierdoY = this.posy
        let extremoDerechoY =  this.posy + (ScreenConfig.getTamFicha())

        let isInX = (x>= extremoIzquierdoX && x<=extremoDerechoX)
        let isInY = (y>= extremoIzquierdoY && y<=extremoDerechoY)

        return isInX && isInY;
         
    }
    moveA(x,y)
    {
        this.posx = x;
        this.posy = y;
    }

    setColocada(colocada)
    {
        this.colocada = colocada;
    }

    isColocada()
    {
        return this.colocada;
    }
    
    comparar(ficha) {
        if ( (this.jugador == 1 & ficha.jugador == 1) ||
              (this.jugador == 2 & ficha.jugador == 2)) {
            return true;
        } else {
            return false;
        }
    }
   
}