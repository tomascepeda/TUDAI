"use strict";

let botonLogin = document.querySelector(".boton-brow");

let user = "null";

botonLogin.addEventListener("click", function(){
    let texto = document.querySelector(".buscador-h").value;
    if (texto != ""){
        user = texto;
        document.querySelector(".buscador-h").classList.add("super-invisible");
        document.querySelector(".boton-brow").classList.add("super-invisible");
        document.querySelector("#nombre-usuario").innerHTML = user;
        document.querySelector(".usuario-header").classList.toggle("super-invisible");
    } else {
        user = "null";
    }
});

let boton = document.querySelector("#btn-comentar");

boton.addEventListener("click", function() {
    let inputComentario = document.querySelector("#comment-input");
    if ((user != "null") && (inputComentario.value != "")){    
        let lista = document.querySelector("#lista");
        let nodoHijo = document.createElement("li");
        let comentario = inputComentario.value;
        lista.appendChild(nodoHijo);
        nodoHijo.classList.add("texto-lista-comen");
        let imagen = document.createElement("img");
        imagen.src = "imagenes/desconocidos.png";
        nodoHijo.appendChild(imagen);
        let texto = document.createTextNode(user +": "+ comentario);
        nodoHijo.appendChild(texto);
    } else {
        if(user == "null"){
            inputComentario.value = "";
            inputComentario.placeholder = "Primero debe Iniciar Sesion";
        }
    }
    inputComentario.value = "";
});

let botonOrdenar = document.querySelector("#cambio-orden-lista");

botonOrdenar.addEventListener("click", function(){
    let lista = document.querySelector("#lista");
    if (lista.classList.contains("ordenar-reverse")){
        //
        botonOrdenar.innerHTML = "Ordenar por: Mas recientes primero";
        lista.classList.remove("ordenar-reverse");
    } else {
        botonOrdenar.innerHTML = "Ordenar por: Mas antiguos primero";
        lista.classList.add("ordenar-reverse");
    }   
});