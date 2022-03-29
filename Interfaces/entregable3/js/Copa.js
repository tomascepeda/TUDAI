class Copa
{
    div
    sonido;

    constructor()
    {
        this.div = document.querySelector('#copa')
        this.sonido = new Sound('./audios/moneda.mp3')
    }

    tiempoRandom()
    {
        return Math.round(Math.random() *5000) + 5000;
    }

    movimiento()
    {
        setInterval( () => {
                this.div.classList.add("copa");
                setTimeout(() =>{
                    this.div.classList.remove("copa");
                }, 3000);
                }, this.tiempoRandom());
    }

    colision(personaje, Oncolision)
    {
        window.choco = false;
        let x = setInterval(() => {

            let posPersonaje = personaje.div.getBoundingClientRect();
            let posCopa = this.div.getBoundingClientRect();
            let value2 = posPersonaje.right - posCopa.left;
            let value3 = posPersonaje.top - posCopa.bottom;

            if((value2>-20 && value2<104) && (value3>-184 && value3<0) && !window.choco)  {
               Oncolision()
               window.choco = true;
               clearInterval(x)

            }
        }, 200)
    }
    
    getSonido()
    {
        return this.sonido;
    }

}
