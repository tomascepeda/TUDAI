class Juego {
    perdido;
    iniciado;
    vidas;
    copa;
    personaje;
    copas;
    cantCopas;
    enemigo;
    enemigoAreo;
    valorDanio;
    valorParcial;

    constructor() {
        this.perdido = false;
        this.iniciado = true;
        this.cantCopas = document.querySelector('#cantidadCopas');;
        this.vidas = document.querySelector('#vidasRestantes');
        this.cantCopas.innerHTML = 0;
        this.copas = 0;
        this.vidas.innerHTML = 5;
        this.personaje = new Personaje();
        this.enemigo = new Enemigo(document.querySelector("#enemigo-terrestre"), 101);
        this.enemigoAreo = new Enemigo(document.querySelector("#enemigo-aereo"), 100);
        this.copa = new Copa();
        this.copa.movimiento();
        this.saltar();
        this.colisionEnemigo();
        this.valorDanio = 0;
        this.valorParcial = 0;
    }

    colisionEnemigo() {
        this.enemigo.colision(this.personaje, this);
        this.enemigoAreo.colision(this.personaje, this);
    }

    // faltaria matar el campo "animation a todos los divs que se muevan"
    finalizarJuego() {
        let elems = document.querySelector("#elementos").querySelectorAll("div");
        elems.forEach(i => {
            i.style.cssText = "animation-play-state: paused;";
        });

        let spanCopas = document.querySelector('#copas')
        spanCopas.innerHTML = parseInt(this.copas);



        let modal = document.querySelector('#modal')
        modal.classList.add('show')
        modal.style.display = 'block';

    }

    saltar() {
        document.addEventListener("keypress", (e) => {

            if (e.which == 119 && this.personaje.salto == false) {
                this.personaje.saltar(e);
                const onColision = () => {
                    this.copa.getSonido().reproducir();
                    this.aumentarCopas();
                }
                let obtuvoCopa = this.copa.colision(this.personaje, onColision.bind(this));
            }
        })
    }

    aumentarCopas() {
        this.copas++;
        document.querySelector("#spancopas").style.cssText = "color: yellow !important;";
        this.cantCopas.style.cssText = "color: yellow !important;";
        setTimeout(() => {
            document.querySelector("#spancopas").style.cssText = "color: white !important;";
            this.cantCopas.style.cssText = "color: white !important;";
        }, 1500);
        this.cantCopas.innerHTML = parseInt(this.cantCopas.innerHTML) + 1;
    }

    disminuirVidas(valor) {
        this.valorParcial++;
        if (this.valorParcial == valor && parseInt(this.vidas.innerHTML) > 0) {
            this.valorParcial = 0;
            this.vidas.innerHTML = parseInt(this.vidas.innerHTML) - 1;
            document.querySelector("#spanvidas").style.cssText = "color: red !important;";
            this.vidas.style.cssText = "color: red !important;";
            setTimeout(() => {
                document.querySelector("#spanvidas").style.cssText = "color: white !important;";
                this.vidas.style.cssText = "color: white !important;";
            }, 1500);
            if (parseInt(this.vidas.innerHTML) <= 0)
                this.finalizarJuego();
        }
    }

    setIniciado(iniciado) {
        this.iniciado = iniciado;
    }

    getIniciado() {
        return this.iniciado;
    }
}