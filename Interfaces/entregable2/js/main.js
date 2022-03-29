document.addEventListener("DOMContentLoaded", function() {
    document.querySelector("#launchmodal").classList.add("display-none");

    document.querySelector("#launchmodal").click();

    let x = setTimeout(() => {
        JuegoConfig.setFichaJ2();
        JuegoConfig.setFichaJ1();
        clearTimeout(x);
    }, 100);
    
    let juego;

    document.querySelector("#play").addEventListener("click", () => {
        ScreenConfig.calcularTamaños();
        JuegoConfig.updateConfig();
        juego = new Juego();
    });

    document.querySelector("#btn-reiniciar").addEventListener("click", ()=>{
        location.reload();
    });
    
})