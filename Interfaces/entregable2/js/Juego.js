
class Juego {
    j1;
    j2;
    restart;
    tablero;
    tiempo;
    fichaEnMovimiento;
    fichaPosXOriginal;
    fichaPosYOriginal;
    turno;

    constructor() {
        this.j1 = JuegoConfig.getJ1();
        this.j2 = JuegoConfig.getJ2(); // obtiene los nombres de los jugadores
        this.cargarTablero(); //instancia de tablero 
        Canvas.cargarCanvas(); // static instancia del canvas
        this.addDrawEventsListeners(); // eventos dentro del canvas
        this.turno = 2; // Turno 1 = j1/ Turno 2 = j2
        this.tiempo = 300000;
        document.querySelector("#reiniciar").classList.remove("display-none");
        this.setTurno();
        this.dibujarTextoJugadores();
        this.restart = document.querySelector("#btn-reiniciar");
    }

    cargarTablero() {

        this.tablero = new Tablero();

        // fin del juego tras 5 minutos
        setTimeout(() => {
            alert("Tiempo maximo de juego excedido");
            this.restart.click();
        }, 300100);

        // se muestra al usuario el tiempo de juego restante
        let countDownDate = new Date().getTime() + 5 * 60000;
        let x = setInterval(function () {
            let now = new Date().getTime();
            let distance = countDownDate - now;
            let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            let seconds = Math.floor((distance % (1000 * 60)) / 1000);
            let timeForScreen = "";
            if (minutes > 0)
                timeForScreen = "El juego finalizara en: " + minutes + " minutos " + seconds + " segundos";
            else
                timeForScreen = "El juego finalizara en: " + seconds + " segundos";
            document.getElementById("restart").innerHTML = timeForScreen;
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("restart").innerHTML = "Se acabó el tiempo";
            }
        }, 1000);

    }

    /*
       Dadas las posiciones x & y y preguntando sobre el turno obtenes las fichas del jugador en
       particular y se calcula si donde esta el puntero es una posicion acertada a una ficha
    */
    seleccionarFicha(x, y) {
        if (this.turno == 1) {
            let fichas = this.tablero.getFichasj1();
            for (let i = 0; i < fichas.length; i++) {
                let figura = fichas[i];
                if (figura.isPointInside(x, y)) {
                    return figura;
                    //ctx.drawImage(figura, x, y, tamFichaJugador, tamFichaJugador);
                }
            }
        }
        else if (this.turno == 2) {
            let fichas = this.tablero.getFichasj2();
            for (let i = 0; i < fichas.length; i++) {
                let figura = fichas[i];
                if (figura.isPointInside(x, y)) {
                    return figura;
                    //ctx.drawImage(figura, x, y, tamFichaJugador, tamFichaJugador);
                }
            }
        }
    }

    addDrawEventsListeners() {
        /*
           Funcion que controla la logica sobre el click dentro del canvas.

        */
        let mifuncion = (e) => {
            let b = e.clientX;
            let a = e.clientY - ScreenConfig.getRadio() / 2;
            if (screen.width < 1920)
                a = (a - ScreenConfig.getRadio() / 2);
            let figuraSeleccionada = this.seleccionarFicha(b, a);
            if (figuraSeleccionada && !figuraSeleccionada.isColocada()) {
                this.fichaEnMovimiento = figuraSeleccionada;
                this.fichaPosXOriginal = figuraSeleccionada.posx; // se almacena la posicion original de la ficha
                this.fichaPosYOriginal = figuraSeleccionada.posy;

            }
            else {
                this.fichaEnMovimiento = undefined;
            }
        }
        Canvas.agregarEvento('mousedown', mifuncion.bind(this));

        /*
            Funcion que controla la logica sobre el arrastre de la ficha hacia un hueco valido
            por cada movimiento se redibuja el tablero
        */
        let arrastrarFicha = (e) => {
            if (this.fichaEnMovimiento) {
                let b = e.clientX;
                let a = e.clientY - ScreenConfig.getTamFicha();
                if (screen.width < 1920)
                    a = a - ScreenConfig.getTamFicha() / 2;
                this.fichaEnMovimiento.moveA(b, a) // le setea las nuevas coordenadas a la ficha
                this.tablero.cargarTablero();
                //printCanvas(canvas)
                //Canvas.dibujarImagen(this.fichaEnMovimiento, b, a, ScreenConfig.getTamFicha(), ScreenConfig.getTamFicha());
            }
        }

        /*
            Funcion que controla la logica de soltar una ficha
            se calcula si la posicion donde el jugador solto la fica es valida y en caso de serlo
            se camba de turno en caso de que no, la ficha vuelve a su posicion original
        */

        let soltarFicha = (e) => {
            if (this.fichaEnMovimiento != undefined) {
                let columna = this.tablero.obtenerNroColumna(this.fichaEnMovimiento.getX() + this.fichaEnMovimiento.getRadius());
                if (columna != undefined) {
                    let insertada = this.tablero.insertarFicha(columna, this.fichaEnMovimiento);
                    if (insertada) {
                        this.fichaEnMovimiento.setColocada(true);
                        this.setTurno();
                    }
                } else { // si le erro al movimiento es decir no acerto en niguna columna
                    // TO-DO: Aca se podria aplicar alguna animacion para que el movimiento de vuelta no sea tan brusco
                    this.fichaEnMovimiento.moveA(this.fichaPosXOriginal, this.fichaPosYOriginal)
                    this.fichaEnMovimiento = undefined; // se deja de tener una ficha en memoria
                    //movimientoValido = false;
                }
                this.tablero.cargarTablero();
                this.fichaEnMovimiento = undefined;
            }
        }
        Canvas.agregarEvento('mouseup', soltarFicha.bind(this));
        Canvas.agregarEvento('mousemove', arrastrarFicha.bind(this));
    }

    setTurno() {
        let text = document.querySelector("#turno-jugador");
        if (this.turno == 1) {
            this.turno = 2;
            text.classList.remove("txt-turno-j1");
            text.classList.add("txt-turno-j2");
            text.innerHTML = "Turno de " + JuegoConfig.getJ2();
        } else {
            this.turno = 1;
            text.classList.remove("txt-turno-j2");
            text.classList.add("txt-turno-j1");
            text.innerHTML = "Turno de " + JuegoConfig.getJ1();
        }
    }

    dibujarTextoJugadores() {
        document.querySelector(".label-canvas").classList.remove("display-none");
        document.querySelector("#nombre-jugadores").innerHTML = "Jugando al " + JuegoConfig.getDinamica() + " en linea";
    }

}