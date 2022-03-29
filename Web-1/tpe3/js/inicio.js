"use strict";

let boton = document.querySelector("#see-more");
let txtInvisible = document.querySelector("#texto-oculto");

boton.addEventListener("click", vermas);

function vermas() {
    txtInvisible.classList.toggle("super-invisible");
    boton.classList.toggle("vermenos");
    if (boton.classList.contains("vermenos")) {
        boton.textContent = "Ver Menos";
    } else {
        boton.textContent = "Ver Mas";
    }
};

let noticia1 = document.querySelector("#noticia-1");

noticia1.addEventListener("click", function() {
    window.location = "noticia.html";
})