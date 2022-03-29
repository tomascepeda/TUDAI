document.addEventListener("DOMContentLoaded", () => {

    let portada = document.querySelector("#inicio");
    portada.style.cssText = "width: " + document.querySelector("html").clientWidth + "px;";
    portada.style.cssText = "height: " + document.querySelector("html").clientHeight + "px;";

    let resolucionx =  1366 + "px"; 
    document.querySelector(".cesped").style.backgroundSize = resolucionx; 
    document.querySelector(".cielo").style.backgroundSize = resolucionx; 
    document.querySelector(".tribuna").style.backgroundSize = resolucionx; 
    document.querySelector(".letrero").style.backgroundSize = resolucionx; 
    document.querySelector(".ayudantes").style.backgroundSize = resolucionx; 

    document.querySelector("#jugar").addEventListener("click", ()=>{
        portada.classList.add("display-none");
        let juego = new Juego();
        document.querySelector("#runner").classList.remove("display-none");
    })
    
    document.querySelector('#btn-reiniciar').addEventListener('click', () => {
        location.reload()
    })

})