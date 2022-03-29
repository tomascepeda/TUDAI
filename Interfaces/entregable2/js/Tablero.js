class Tablero {
    fondo;
    tamaño;
    huecos; // matriz que almacena las coordenadas (x, y) de los huecos del tablero 
    contenedor;
    cantFichas;
    tablero; // la matriz
    contenedores;

    constructor() {
        this.fichasJ1 = [];
        this.fichasj2 = [];
        this.tablero = [];
        this.fondo = new Image();
        this.fondo.src = "./img/pastito.jpg";

        let dinamica = JuegoConfig.getDinamica();
        let diff = dinamica - 4;
        if (diff > 0)
            diff = diff * 2;
        this.tamaño = ScreenConfig.getTamFicha() * (8 + diff); // ajuste dinamico del tablero
        this.contenedores = [];
        this.contenedor = new Image();
        this.contenedor.src = "./img/contenedor.png"

        Canvas.cargarCanvas();
        this.cantFichas = 0;
        this.cargarContenedores();
        this.onLoadImages();
        this.cargarFichasRandom(this.cantFichas);

    }

    addFichas(fichasJ1, fichasj2) {
        this.fichasJ1 = fichasJ1;
        this.fichasj2 = fichasj2;
    }

    // Se controla se las imagenes fueron cargadas o no.
    onLoadImages() {
        this.fondo.onload = this.cargarTablero.bind(this);
        this.contenedor.onload = this.cargarTablero.bind(this); // se ejecuta en otro lado, pierde le contexto si no le paso this
    }

    // Logica del tablero para saber cuando cargarse,depende de las fotos si ya estan cargadas, llama al canvas para que las dibuje
    cargarTablero() {

        let isFondo = this.fondo.complete && this.fondo.naturalHeight != 0;
        let isContenedor = this.contenedor.complete && this.contenedor.naturalHeight != 0;
        if (isFondo && isContenedor) {
            Canvas.limpiar();
            this.cargarFondo();
            this.dibujarContenedores();
            this.dibujarFichas();
            let x = setTimeout(() => {
                this.dibujarFichas();    
                clearTimeout(x);
            }, 50);
        }
    }

    cargarFondo() {
        Canvas.dibujarImagen(this.fondo, (Canvas.getAncho() / 2 - this.tamaño / 2), ScreenConfig.getMarginTop(), this.tamaño, Canvas.getAlto() - ScreenConfig.getMarginTop());
    }

    cargarContenedores() {
        let i = 0;
        let j = 0;
        for (let x = (Canvas.getAncho() / 2 - this.tamaño / 2); x < (Canvas.getAncho() / 2 + this.tamaño / 2) - 10; x = x + ScreenConfig.getTamFicha()) {
            this.tablero[i] = []; 
            this.contenedores[i] = [];
            for (let y = ScreenConfig.getMarginTop(); y < Canvas.getAlto(); y = y + ScreenConfig.getTamFicha()) {
                this.cantFichas++;
                // se cargan las coordenadas (x, y) del centro de los huecos 
                this.tablero[i][j] = {
                    x: x + ScreenConfig.getTamFicha() / 2,
                    y: y + ScreenConfig.getTamFicha() / 2
                };
                this.contenedores[i].push(new Contenedor(x, y, ScreenConfig.getTamFicha(), ScreenConfig.getTamFicha(), this.contenedor));
                j++;
                //this.contenedores.push(new Contenedor(x, y, ScreenConfig.getTamFicha(), ScreenConfig.getTamFicha(), this.contenedor));
            }
            i++;
        }
    }

    dibujarFichas() {
        for (let i = 0; i < this.fichasJ1.length; i++) {
            Canvas.dibujarImagen(this.fichasJ1[i].img, this.fichasJ1[i].posx - (this.fichasJ1[i].radius / 2), this.fichasJ1[i].posy - (this.fichasJ1[i].radius / 2), this.fichasJ1[i].radius, this.fichasJ1[i].radius);
        }
        for (let i = 0; i < this.fichasj2.length; i++) {
            Canvas.dibujarImagen(this.fichasj2[i].img, this.fichasj2[i].posx - (this.fichasj2[i].radius / 2), this.fichasj2[i].posy - (this.fichasj2[i].radius / 2), this.fichasj2[i].radius, this.fichasj2[i].radius);
        }
    }

    dibujarContenedores() {

        for (let i = 0; i < this.contenedores.length; i++) {
            for (let j = 0; j < this.contenedores[i].length; j++) {
                let img = this.contenedores[i][j].img;
                let x = this.contenedores[i][j].posx;
                let y = this.contenedores[i][j].posy;
                let tamx = this.contenedores[i][j].tamFichax;
                let tamy = this.contenedores[i][j].tamFichay;
                Canvas.dibujarImagen(img, x, y, tamx, tamy)
            }
        }
    }

    cargarFichasRandom(cant) {
        let tamañoFicha = ScreenConfig.getTamFicha();
        let anchoCanvas = Canvas.getAncho();
        let altoCanvas = Canvas.getAlto();
        let marginTop = ScreenConfig.getMarginTop();
        let tamFichaJugador = tamañoFicha + (tamañoFicha * 0.50); // el tamaño de la ficha real con la que el jugador interactua

        let srcFichaJ1 = JuegoConfig.getFichaJ1();
        if (srcFichaJ1 == undefined)
            srcFichaJ1 = "./img/fichadiego.png";
        for (let i = 0; i < cant / 2; i++) {
            // aleatrorizador entre el inicio del canvas y el inicio del tablero
            let posx = Math.round(Math.random() * (anchoCanvas / 2 - this.tamaño / 2)) + tamañoFicha;
            if (posx > (anchoCanvas / 2 - this.tamaño / 2) - tamañoFicha) {
                posx = (anchoCanvas / 2 - this.tamaño / 2) - tamañoFicha - 10;
            }
            let posy = Math.round(Math.random() * altoCanvas + marginTop);
            if (posy > altoCanvas - tamañoFicha) {
                posy = altoCanvas - tamañoFicha;
            } else if (posy < tamañoFicha) {
                posy = tamañoFicha;
            }
            let ficha = new Image();
            ficha.src = srcFichaJ1;
            ficha.onload = ()=>{
                this.fichasJ1.push(new Ficha(posx, posy, tamFichaJugador, ficha, 1));
            }
        }

        let srcFichaJ2 = JuegoConfig.getFichaJ2();
        if (srcFichaJ2 == undefined)
            srcFichaJ2 = "./img/fichamessirve.png";
        for (let i = 0; i < cant / 2; i++) {
            // aleatrorizador entre el fin del tablero y el fin del canvas
            let posx = Math.round(Math.random() * (anchoCanvas - (anchoCanvas / 2 + this.tamaño / 2))) + (anchoCanvas / 2 + this.tamaño / 2) + tamañoFicha;
            if (posx > anchoCanvas - tamañoFicha) {
                posx = anchoCanvas / 2 + this.tamaño / 2 + tamañoFicha * 2;
            } else if (posx < anchoCanvas / 2 + this.tamaño / 2) {
                posx = anchoCanvas / 2 + this.tamaño / 2 + tamañoFicha * 3;
            }
            let posy = Math.round(Math.random() * altoCanvas + marginTop);
            if (posy > altoCanvas - tamañoFicha) {
                posy = altoCanvas - tamañoFicha;
            } else if (posy < tamañoFicha) {
                posy = tamañoFicha;
            }
            let ficha = new Image();
            ficha.src = srcFichaJ2;
            ficha.onload = ()=>{
                this.fichasj2.push(new Ficha(posx, posy, tamFichaJugador, ficha, 2));
            }
        }
    }

    getFichasj1() {
        return this.fichasJ1;
    }

    getFichasj2() {
        return this.fichasj2;
    }

    static getTamTablero() {
        return this.tamaño;
    }


    obtenerNroColumna(x) {
        let estaEnColumna;
        for (let i = 0; i < this.contenedores.length; i++) {
            estaEnColumna = this.contenedores[i][0].estaEnColumna(x);
            if (estaEnColumna) {
                return i;
            }
        }
    }

    // Devuelve true o false si fue insertada la ficha
    insertarFicha(columna, ficha) {
        for (let i = this.contenedores[columna].length - 1; i >= 0; i--) {
            if (this.contenedores[columna][i].vacio()) {

                this.contenedores[columna][i].almacenarFicha(ficha);
                ficha.moveA(this.contenedores[columna][i].posx + (this.contenedores[columna][i].tamFichax / 2), this.contenedores[columna][i].posy + (this.contenedores[columna][i].tamFichax / 2));
                let gano = this.comprobarAreaDeFicha(i, columna);
                if (gano) {
                    setTimeout(() => {
                        if (ficha.jugador == 1)
                            alert("Ganó " + JuegoConfig.getJ1());
                        else
                            alert("Ganó " + JuegoConfig.getJ2());
                        location.reload();
                    }, 200);
                }
                return true;
            }
        }
        return false;
    }

    comprobarAreaDeFicha(fila, columna) {
        let gano = false;
        let i = -3;
        let j = -3;
        let filaAux;
        let columnaAux;

        while ((i <= 3) & !gano) {
            j = -3;
            while ((j <= 3) & !gano) {
                filaAux = fila + i;
                columnaAux = columna + j;

                if ((filaAux >= 0 & filaAux < this.contenedores[0].length) & (columnaAux >= 0 & columnaAux < this.contenedores.length)) {
                    gano = this.comprobarFicha(filaAux, columnaAux);
                }
                j++;
            }
            i++;
        }

        return gano;
    }

    comprobarFicha(fila, columna) {
        let contenedor1 = this.contenedores[columna][fila];
        let contenedor2;
        let iguales;

        let horizontalDerecha = i => { return this.contenedores[columna + i][fila]; };
        let horizontalIzquierda = i => { return this.contenedores[columna + (i * -1)][fila]; };
        let verticalArriba = i => { return this.contenedores[columna][fila + (i * -1)]; };
        let verticalAbajo = i => { return this.contenedores[columna][fila + i]; };
        let diagonalArribaDerecha = i => { return this.contenedores[columna + i][fila + i]; };
        let diagonalAbajoIzquierda = i => { return this.contenedores[columna + (i * -1)][fila + (i * -1)]; };
        let diagonalArribaIzquierda = i => { return this.contenedores[columna + (i * -1)][fila + i]; };
        let diagonalAbajoDerecha = i => { return this.contenedores[columna + i][fila + (i * -1)]; };

        let direcciones = new Array();
        direcciones[0] = horizontalDerecha;
        direcciones[1] = horizontalIzquierda;
        direcciones[2] = verticalArriba;
        direcciones[3] = verticalAbajo;
        direcciones[4] = diagonalArribaDerecha;
        direcciones[5] = diagonalAbajoIzquierda;
        direcciones[6] = diagonalArribaIzquierda;
        direcciones[7] = diagonalAbajoDerecha;

        for (let direccion = 0; direccion < direcciones.length; direccion++) {
            let i = 1;
            iguales = true;
            while ((i < JuegoConfig.getDinamica()) & iguales) {
                try {
                    contenedor2 = direcciones[direccion](i);
                } catch (error) {
                    contenedor2 = undefined;
                }
                if (contenedor2 != undefined) {
                    iguales = contenedor1.comparar(contenedor2);
                    i++;
                } else {
                    iguales = false;
                }
            }

            if (iguales) {
                this.cambiarImgFichas(contenedor1,direcciones[direccion]);
                return true;
            }
        }

        return false;
    }

    cambiarImgFichas(contenedor,direccion) {
        let imgContenedor;
        let imgFichaGanadora = new Image();
        imgContenedor = document.querySelector("#contenedor-verde");
        imgFichaGanadora.src = "./img/pelota.png";
        let ficha = contenedor.getFicha();
        ficha.setImg(imgFichaGanadora);
        contenedor.setImg(imgContenedor);
        for (let i = 1; i <= JuegoConfig.getDinamica()-1; i++) {
            contenedor = direccion(i);
            ficha = contenedor.getFicha();
            ficha.setImg(imgFichaGanadora);
            contenedor.setImg(imgContenedor);
        }
    }

}
