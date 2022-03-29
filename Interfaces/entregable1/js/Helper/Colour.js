
// Modulo que permite obtener el color actual seleccionado

export class Colour {

    size;
    colour;

    static getCurrentColour() {
        this.update();
        return this.colour;
    }
    
    static update() {
        this.size = document.querySelector("#coloursize").value;
        this.colour = document.querySelector("#favcolor").value;
    }

    static getColourSize() {
        this.update();
        return this.size;
    }

}