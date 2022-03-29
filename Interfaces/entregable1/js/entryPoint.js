
import { Colour } from './Helper/Colour.js';

document.addEventListener("DOMContentLoaded", () => {

    "use strict";

    let canvas = document.querySelector("#canvas-js");
    let ctx = canvas.getContext('2d');
    checkResolution();
    clearCanvas();

    let x = 0;
    let y = 0;
    let dibujando = false;

    // chequea la resolucion de pantalla para ajustar el tamaño del canvas
    function checkResolution() {
        if (screen.width > 1366) {
            canvas.width = 1780;
            canvas.height = 868;
            canvas.style.width = "1780px";
            canvas.style.height = "868px";
            document.querySelector(".tools").style.height = "868px";
            let navTxt = document.querySelectorAll(".nav-txt");
            for (let i = 0; i < navTxt.length; i++) {
                navTxt[i].classList.remove("nav-txt");
                navTxt[i].style.marginTop = "10px";
                navTxt[i].style.marginLeft = "50px";
                navTxt[i].style.marginRight = "50px";
            }
        }
    }

    // herramientas

    /*
    al hacer click en el boton del lapiz se realizan las siguientes acciones:
    se activan los metodos de dibujo
    se cambia el icono del cursor cuando esta encima del canvas
    se muestran los inputs para cambiar el color y tamaño del trazo
    se cambia el maximo valor que puede recibir el input del tamaño a 30px
    se auto setean los valores de los inputs en color negro y tamaño 1px
    se recuadra con rojo el boton del lapiz para indicar que esta seleccionado
    */
    let lapiz = document.querySelector("#lapizBtn");
    lapiz.addEventListener("click", () => {
        addDrawEventsListeners();
        canvas.classList.remove("canvas-goma");
        canvas.classList.remove("canvas-init");
        canvas.classList.add("canvas-lapiz");
        let color = document.querySelector("#favcolor");
        let size = document.querySelector("#coloursize");
        color.classList.remove("display-none");
        size.classList.remove("display-none");
        color.value = "#000000";
        size.max = 30;
        size.value = 1;
        color.disabled = false;
        size.disabled = false;
        goma.classList.remove("current-selected-button");
        lapiz.classList.add("current-selected-button");
        document.querySelector("#txt-colr").classList.remove("display-none");
        document.querySelector("#txt-tam").classList.remove("display-none");
    });

    /*
    al hacer click en el boton de la goma se realizan las siguientes acciones:
    se activan los metodos de dibujo
    se cambia el icono del cursor cuando esta encima del canvas
    se muestra el input para cambiar el tamaño del trazo
    se cambia el maximo valor que puede recibir el input del tamaño a 100px
    se auto setean los valores de los inputs en color blanco y tamaño 100px
    se oculta el input de cambio de color del trazo
    se recuadra con rojo el boton de la goma para indicar que esta seleccionado
    */
    let goma = document.querySelector("#gomaBtn");
    goma.addEventListener("click", () => {
        addDrawEventsListeners();
        canvas.classList.remove("canvas-init");
        canvas.classList.remove("canvas-lapiz");
        canvas.classList.add("canvas-goma");
        let color = document.querySelector("#favcolor");
        let size = document.querySelector("#coloursize");
        color.classList.add("display-none");
        size.classList.remove("display-none");
        color.value = "#FFFFFF";
        size.max = 100;
        size.value = 100;
        color.disabled = true;
        size.disabled = false;
        lapiz.classList.remove("current-selected-button");
        goma.classList.add("current-selected-button");
        document.querySelector("#txt-colr").classList.add("display-none");
        document.querySelector("#txt-tam").classList.remove("display-none");
    });

    // eventos de dibujo
    function addDrawEventsListeners() {
        let position = canvas.getBoundingClientRect();
        
        canvas.addEventListener('mousedown', (e) => {
            position = canvas.getBoundingClientRect();
            x = e.clientX - position.left;
            y = e.clientY - position.top;
            dibujando = true;
        });

        canvas.addEventListener('mousemove', (e) => {
            position = canvas.getBoundingClientRect();
            if (dibujando === true) {
                draw(x, y, e.clientX - position.left, e.clientY - position.top);
                x = e.clientX - position.left;
                y = e.clientY - position.top;
            }
        });

        canvas.addEventListener('mouseup', (e) => {
            position = canvas.getBoundingClientRect();
            if (dibujando === true) {
                draw(x, y, e.clientX - position.left, e.clientY - position.top);
                x = 0;
                y = 0;
                dibujando = false;
            }
        });

        window.addEventListener('scroll', () => {
            position = canvas.getBoundingClientRect();
        });

        window.addEventListener('resize', () => {
            position = canvas.getBoundingClientRect();
        });
    }

    /*
    se obtienen los valores actuales de los inputs de color y tamaño del trazo
    se dibuja en el canvas el trazo de x1, y1 a x2, y2
    */
    function draw(x1, y1, x2, y2) {
        ctx.beginPath();
        ctx.strokeStyle = Colour.getCurrentColour();
        ctx.lineWidth = Colour.getColourSize();
        ctx.moveTo(x1, y1);
        ctx.lineTo(x2, y2);
        ctx.stroke();
        ctx.closePath();
    }

    // Carga de imagen
    // al hacer click en el boton importar se auto clickea el input type file para la carga de imagen, este esta oculto para mejorar la interfaz visual
    document.querySelector("#btn-subir-img").addEventListener("click", () => {
        document.querySelector("#subir-img").click();
    });

    let inputFile = document.querySelector("#subir-img");
    let image = new Image();

    inputFile.addEventListener("change", (e) => {

        clearCanvas();
        image.src = URL.createObjectURL(e.target.files[0]);

        image.onload = () => {
            let hRatio = canvas.width / image.width;
            let vRatio = canvas.height / image.height;
            let ratio = Math.min(hRatio, vRatio);
            let centerShift_x = (canvas.width - image.width * ratio) / 2;
            let centerShift_y = (canvas.height - image.height * ratio) / 2;
            ctx.drawImage(image, 0, 0, image.width, image.height,
                centerShift_x, centerShift_y, image.width * ratio, image.height * ratio);
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        }
    });

    let imageData = null; // variable global, guarda la imagen del canvas para poder cambiar los filtros sin sobreescribirlos

    // descarga de imagen
    document.querySelector("#download").addEventListener("click", () => {
        let link = document.createElement('a');
        link.href = canvas.toDataURL();
        link.download = 'draw.png';
        link.click();
    });

    function clearCanvas() {
        ctx.fillStyle = '#FFFFFF';
        ctx.fillRect(0, 0, canvas.width, canvas.height);
    }

    // FILTROS

    let inputIntensidad = document.querySelector("#intensidad");
    let liIntensidad = document.querySelector("#li-intensidad");
    let intensidad = inputIntensidad.value;
    let lastSelected = null;

    // al variar el input de intensidad se actualiza el filtro, si el filtro no cambia de intensidad no se actualiza
    inputIntensidad.addEventListener("change", () => {
        intensidad = inputIntensidad.value;
        if (lastSelected != null)
            lastSelected.click();
    });

    // resetear - lienzo en blanco
    document.querySelector("#reset").addEventListener("click", () => {
        liIntensidad.classList.add("display-none");
        lastSelected = null;
        URL.revokeObjectURL(image.src);
        clearCanvas();
    });

    /*
    los eventListener de los filtros funcionan de manera similar:
    se guarda en la variable lastSelected el filtro seleccionado actualmente
    si el filtro puede aumentar su intensidad se muestra el input, en caso contrario se oculta
    si no se inserto una imagen se setea el imageData con lo que el canvas tenga en ese momento
    se instancia una clase del filtro, esta contiene la logica para calcularlo
    la intensidad se modifica en cada filtro para poder calcularlo correctamente 
    se aplica el filtro al canvas, insertando el imageData modificado por la clase del filtro
    */

    // escala de grises
    let grises = document.querySelector("#grises");
    grises.addEventListener("click", () => {
        lastSelected = grises;
        liIntensidad.classList.remove("display-none");
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Grises(canvas.width, canvas.height, ctx, Math.round(intensidad / 30));
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

    // binarizacion
    let binarizacion = document.querySelector("#blanco-negro");
    binarizacion.addEventListener("click", () => {
        lastSelected = binarizacion;
        liIntensidad.classList.remove("display-none");
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Binarizacion(canvas.width, canvas.height, ctx, intensidad);
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

    // brillo
    let brillo = document.querySelector("#brillo");
    brillo.addEventListener("click", () => {
        lastSelected = brillo;
        liIntensidad.classList.remove("display-none");
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Brillo(canvas.width, canvas.height, ctx, Math.round(intensidad / 1));
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

    // difuminado
    let blur = document.querySelector("#blur");
    blur.addEventListener("click", () => {
        lastSelected = blur;
        liIntensidad.classList.remove("display-none");
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Blur(canvas.width, canvas.height, ctx, Math.round(intensidad / 30));
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

    // sepia
    document.querySelector("#sepia").addEventListener("click", () => {
        lastSelected = null;
        liIntensidad.classList.add("display-none");
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Sepia(canvas.width, canvas.height, ctx);
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

    // negativo
    document.querySelector("#negativo").addEventListener("click", () => {
        lastSelected = null;
        liIntensidad.classList.add("display-none");
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Negativo(canvas.width, canvas.height, ctx);
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

    //saturacion
    let saturacion = document.querySelector("#saturacion");
    saturacion.addEventListener("click", () => {
        lastSelected = saturacion;
        if (imageData == null)
            imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        ctx.putImageData(imageData, 0, 0);
        let filtro = new Saturacion(canvas.width, canvas.height, ctx);
        ctx.putImageData(filtro.getImageData(), 0, 0);
    });

});
