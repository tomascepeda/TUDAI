class Enemigo
{
    intervaloAparicion;
    div;
    value;

    constructor(div, value) {
        this.div = div;
        this.value = value;
    }


    colision(personaje, juego) {
        let x = setInterval(() => {
            let offsetPlayer = personaje.div.getBoundingClientRect();
            let enemigo = this.div.getBoundingClientRect();
            let rect1  = {
                x : offsetPlayer.x,
                y : offsetPlayer.y,
                width : offsetPlayer.width,
                height : offsetPlayer.height
            }
            let rect2 = {
                x : enemigo.x,
                y : enemigo.y,
                width : enemigo.width,
                height : enemigo.height

            }
            if (rect1.x < rect2.x + rect2.width &&
                rect1.x + rect1.width > rect2.x + this.value &&
                rect1.y < rect2.y + rect2.height &&
                rect1.height + rect1.y > rect2.y + this.value) {
                if(this.value > 100)
                    juego.disminuirVidas(6);
                else
                juego.disminuirVidas(8);
            }
        }, 50);
    }

}