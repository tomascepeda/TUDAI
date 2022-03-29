class Contenedor
{
    img;
    posx;
    posy;
    tamFichax;
    tamFichay;
    ficha;


    constructor(x,y,tamx,tamy,img)
    {
        this.img = img
        this.posx = x;
        this.posy = y;
        this.tamFichay = tamy;
        this.tamFichax = tamx;
    }

    //
    estaEnColumna(x)
    {
        return x> this.posx + this.tamFichax && x<(this.posx + this.tamFichax * 2)
    }

    vacio()
    {
        return this.ficha == undefined;
    }

    setImg(img){
        this.img = img;
    }

    almacenarFicha(ficha)
    {
        this.ficha = ficha;
    }

    getFicha(){
        return this.ficha;
    }

    
    comparar(contenedor) {
        if (contenedor.ficha != undefined  & this.ficha != undefined) {
            let fichaContenedor = contenedor.ficha;
            return this.ficha.comparar(fichaContenedor);
        } else {
            return false;
        }
    }






}