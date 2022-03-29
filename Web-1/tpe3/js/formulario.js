"use strict";

let cantImg = 6;

function getRandom(cantImg) {
    return Math.floor((Math.random() * cantImg) + 1);
}

let imagenNro;

getImg();

function getImg() {
    imagenNro = getRandom(cantImg);
    let imgCaptcha = document.querySelector("#foto-captcha");
    imgCaptcha.src = "captchas/" + imagenNro + ".jpg";
    document.querySelector("#cambiar-img").addEventListener("click", getImg);
}

function validar(event) {
    event.preventDefault();
    let inputValidar = document.querySelector("#validar-cap");
    let divValidado = document.querySelector("#div-validado");
    let load = document.querySelector("#cargar");

    switch (imagenNro) {

        case 1: if ((inputValidar.value) == "qmwco") {
            siValida(inputValidar, divValidado, load);
        } else { noValida(inputValidar, load); } break;

        case 2: if ((inputValidar.value) == "qeuzh3u") {
            siValida(inputValidar, divValidado, load);
        } else { noValida(inputValidar, load); } break;

        case 3: if ((inputValidar.value) == "znazbg") {
            siValida(inputValidar, divValidado, load);
        } else { noValida(inputValidar, load); } break;

        case 4: if ((inputValidar.value) == "mtr55d8e") {
            siValida(inputValidar, divValidado, load);
        } else { noValida(inputValidar, load); } break;

        case 5: if ((inputValidar.value) == "khxmz") {
            siValida(inputValidar, divValidado, load);
        } else { noValida(inputValidar, load); } break;

        case 6: if ((inputValidar.value) == "jucani") {
            siValida(inputValidar, divValidado, load);
        } else { noValida(inputValidar, load); } break;

    }

}

function noValida(inputValidar, load) {
    inputValidar.classList.toggle("super-invisible");
    load.classList.toggle("super-invisible");
    setTimeout(() => {
        load.classList.toggle("super-invisible");
        inputValidar.classList.toggle("super-invisible");
    }, 1600);
    inputValidar.value = "";
    inputValidar.placeholder = "Sin Coincidencias, Intente Nuevamente";
}

function siValida(inputValidar, divValidado, load) {
    load.classList.toggle("super-invisible");
    inputValidar.classList.toggle("super-invisible");
    setTimeout(() => {
        divValidado.classList.toggle("super-invisible");
        load.classList.toggle("super-invisible");
        setTimeout(() => {
            addAlArreglo(divValidado, inputValidar);
        }, 1000);
    }, 1600);
}

let botonEnviar = document.querySelector("#boton-send");
botonEnviar.addEventListener("click", (event) => validar(event));

function addAlArreglo(divValidado, inputValidar) {

    let tds = document.querySelectorAll("input");
    let vacio;
    for (let i = 1; i <= 4; i++) {
        if (tds[i].value == "") {
            vacio = true;
            tds[i].placeholder = "¡COMPLETA ESTE CAMPO!";
            break;
        } else {
            vacio = false;
        }
    }
    if (!vacio) {
        let objeto = {
            "nombre": tds[1].value,
            "apellido": tds[2].value,
            "telefono": tds[3].value,
            "edad": tds[4].value
        };
        divValidado.classList.toggle("super-invisible");
        inputValidar.classList.toggle("super-invisible");
        getImg();
        postPostulante(objeto); //api
    } else {
        divValidado.classList.toggle("super-invisible");
        inputValidar.classList.toggle("super-invisible");
        inputValidar.placeholder = "Revise los campos";
    }
};

document.querySelector("#resaltados").addEventListener("click", async function() {
    
    let coleccion = await getColeccion();
    let personas = document.querySelectorAll("#removible");
    for (let i = 0; i < coleccion.postulantes.length; i++) {
        if (coleccion.postulantes[i].thing.edad >= 18) {
            let datos = personas[i].querySelectorAll("td");
            for (let j = 0; j < datos.length; j++) {
                datos[j].classList.toggle("resaltado");
            };
        };
    };
});

document.querySelector("#cargar3elem").addEventListener("click", () => {
    for (let i = 0; i < 3; i++) {
        let objeto = {
            "nombre": "auto-generated",
            "apellido": "auto-generated",
            "telefono": Math.floor((Math.random() * 9999999999) + 1),
            "edad": Math.floor((Math.random() * 99) + 1)
        };
        postPostulante(objeto); //api
    };
});

let tablaPostulantes = document.querySelector(".postulantes");

document.addEventListener("DOMContentLoaded", () => {
    getPostulantes();
});

document.querySelector("#vaciar-tabla").addEventListener("click", async function(){
    let removes = tablaPostulantes.querySelectorAll("#removible");
    for (let i = 0; i < removes.length; i++) {
        removes[i].remove();
    }

    let coleccion = await getColeccion();

    for(let s = 0; s < coleccion.postulantes.length; s++){
        let id = coleccion.postulantes[s]._id;
        fetch(url + grupo + coleccion + "/" +id, {
            method: "DELETE",
            mode: 'cors',
        }).then(function (r) {
            if (!r.ok) {
                console.log("error")
            }
            return r.json()
        })
            .then(function (json) {
                console.log(json);
            })
            .catch(function (e) {
                console.log(e)
            })
    }

});

function insetarJsonTabla(json) {

    for (let i = 0; i < json.postulantes.length; i++) {

        let tr = document.createElement("tr")
        let td = document.createElement("td");
        let td2 = document.createElement("td");
        let td3 = document.createElement("td");
        let td4 = document.createElement("td");
        let td5 = document.createElement("td");

        td.innerHTML = json.postulantes[i].thing.nombre;
        td2.innerHTML = json.postulantes[i].thing.apellido;
        td3.innerHTML = json.postulantes[i].thing.telefono;
        td4.innerHTML = json.postulantes[i].thing.edad;
        
        let botonEliminar = document.createElement("button");
        botonEliminar.classList.add("boton-cap");
        botonEliminar.innerHTML = "Eliminar";
        td5.appendChild(botonEliminar);
        botonEliminar.addEventListener("click", () => { eliminar(json, i) });
        
        let botonEditar = document.createElement("button");
        botonEditar.classList.add("boton-cap");
        botonEditar.innerHTML = "Editar";
        td5.appendChild(botonEditar);
        botonEditar.addEventListener("click", () => { modificar(json, i, botonEditar, botonEnviar) });
        
        let botonEnviar = document.createElement("button");
        botonEnviar.classList.add("boton-cap");
        botonEnviar.classList.add("super-invisible");
        botonEnviar.innerHTML = "Enviar";
        td5.appendChild(botonEnviar);

        tr.appendChild(td);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.id = "removible";
        tablaPostulantes.appendChild(tr);
    }
}

function eliminar(arreglo, posicion) {

    let identificador = arreglo.postulantes[posicion]._id;
    let tr = tablaPostulantes.querySelectorAll("#removible")[posicion];

    fetch(url + grupo + coleccion + "/" + identificador, {
        method: "DELETE",
        mode: 'cors',
    }).then(function (r) {
        if (!r.ok) {
            console.log("error")
        }
        return r.json()
    })
        .then(function (json) {
            console.log(json);
            tr.remove();
        })
        .catch(function (e) {
            console.log(e)
        })

};

function modificar(arreglo, posicion, b1, b2) {

    let identificador = arreglo.postulantes[posicion]._id;
    let tr = tablaPostulantes.querySelectorAll("#removible")[posicion];
    let tds = tr.querySelectorAll("td");
    for (let i = 0; i < tds.length - 1; i++) {
        tds[i].innerHTML = "<input class='boton-cap'>";
    }
    let inputs = tr.querySelectorAll("input");
    b1.classList.add("super-invisible");
    b2.classList.remove("super-invisible");
    b2.addEventListener("click", ()=>{
        let objeto = {
            "nombre": inputs[0].value,
            "apellido": inputs[1].value,
            "telefono": inputs[2].value,
            "edad": inputs[3].value
        };
        putPostulante(objeto, identificador);
    });
}

// API

let url = 'https://web-unicen.herokuapp.com/api/groups/';
let grupo = '025tomascepedayarielmarano/';
let coleccion = 'postulantes';

async function postPostulante(json) {
    try {
        let objeto = { "thing": json };
        let enviar = await fetch(url + grupo + coleccion, {
            "method": "POST",
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(objeto)
        });
        console.log("Objeto Enviado");
        location.reload();
    }
    catch {
        console.log = "Error";
    }
};

async function putPostulante(json, identificador) {
    try {
        let objeto = { "thing": json };
        let enviar = await fetch(url + grupo + coleccion + "/" + identificador, {
            "method": "PUT",
            "headers": { "Content-Type": "application/json" },
            "body": JSON.stringify(objeto)
        });
        console.log("Objeto Enviado");
        location.reload();
    }
    catch {
        console.log = "Error";
    }
};

function getPostulantes() {
    fetch(url + grupo + coleccion, {
        method: "GET",
        mode: 'cors',
    }).then(function (r) {
        if (!r.ok) {
            console.log("error")
        }
        return r.json()
    })
        .then(function (json) {
            console.log(json);
            insetarJsonTabla(json);
        })
        .catch(function (e) {
            console.log(e)
        })
};

async function getColeccion() {
    let r = await fetch(url + grupo + coleccion);
    let json = await r.json();
    return json;
}