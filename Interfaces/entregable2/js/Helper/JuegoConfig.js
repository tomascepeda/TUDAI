class JuegoConfig
{
    static dinamica;
    static j1;
    static j2;
    static pelota;
    static fichaJ1;
    static fichaJ2;

    static updateConfig()
    {
        this.dinamica = document.querySelector("#x-enlinea").value;
        this.comprobarNombres();
        this.pelota = new Image();
        this.pelota.src = "./img/pelota.png";
    }

    static setFichaJ1(){
        let botonera = document.getElementById("team-j1");
        let fichas = botonera.querySelectorAll("button");
        for (let i = 0; i < fichas.length; i++) {
            fichas[i].addEventListener("click", ()=>{
                for (let j = 0; j < fichas.length; j++) fichas[j].classList.remove("ficha-selected");
                fichas[i].classList.add("ficha-selected");
                JuegoConfig.fichaJ1 = fichas[i].value;
            });
        }
    }

    static setFichaJ2(){
        let botonera = document.getElementById("team-j2");
        let fichas = botonera.querySelectorAll("button");
        for (let i = 0; i < fichas.length; i++) {
            fichas[i].addEventListener("click", ()=>{
                for (let j = 0; j < fichas.length; j++) fichas[j].classList.remove("ficha-selected");
                fichas[i].classList.add("ficha-selected");
                JuegoConfig.fichaJ2 = fichas[i].value;
            });
        }
    }

    static getFichaJ1(){
        return this.fichaJ1;
    }

    static getFichaJ2(){
        return this.fichaJ2;
    }

    static getPelota()
    {
        return this.pelota;
    }

    static getDinamica(){
        return this.dinamica;
    }

    static getJ1()
    {
        return this.j1;
    }

    static getJ2()
    {
        return this.j2;
    }

    static comprobarNombres()
    {
        this.j1 = document.querySelector("#j1").value;
        this.j2 = document.querySelector("#j2").value;
        
        if (this.j1.length == 0)
        this.j1 = "jugador 1";
        if (this.j2.length == 0)
        this.j2 = "jugador 2";


    }



}