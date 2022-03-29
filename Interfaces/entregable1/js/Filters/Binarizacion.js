class Binarizacion extends Filter {

    constructor(width, height, ctx, intensidad) {
        super(width, height, ctx);
        this.intensidad = intensidad; // valor por el cual se decide si el pixel se pintara de blanco o negro
    }

    drawRect() {
        /*
        se obtiene los valores de rgb del pixel
        se calcula el promedio de los valores de rgb
        si el promedio es mayor a la intensidad el pixel se setea de color blanco
        en caso contrario, se setea de color negro
        */
        for (let x = 0; x < this.width; x++) {
            for (let y = 0; y < this.height; y++) {
                let r = this.getRed(this.imageData, x, y);
                let g = this.getGreen(this.imageData, x, y);
                let b = this.getBlue(this.imageData, x, y);
                let a = 255;
                let prom = ((r + g + b) / 3);
                if(prom > this.intensidad)
                    prom = 255;
                else
                    prom = 0;
                this.setPixel(this.imageData, x, y, prom, prom, prom, a);
            }
        }
    }
}