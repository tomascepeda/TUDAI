class Personaje{
    
    div;
    salto;

    constructor()
    {
        this.div = document.querySelector('#diego')
        this.salto = false;
    }

    saltar(e)
    {
            if(this.salto == false){
                this.salto = true;
                let diego = document.querySelector("#diego");
                diego.classList.remove("diego-correr");
                diego.classList.add("diego-salto");
                let x = setTimeout(() => {
                        this.salto = false;
                        clearTimeout(x);
                        diego.classList.remove("diego-salto");
                        diego.classList.add("diego-correr");
                    }, 1500);
            }
    }
}