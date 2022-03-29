class Grises extends Filter {

    constructor(width, height, ctx, intensidad) {
        super(width, height, ctx);
        this.intensidad = intensidad; // aclara u oscurece el pixel
    }

    drawRect() {
        for (let x = 0; x < this.width; x++) {
            for (let y = 0; y < this.height; y++) {
                let r = this.getRed(this.imageData, x, y);
                let g = this.getGreen(this.imageData, x, y);
                let b = this.getBlue(this.imageData, x, y);
                let a = 255;
                // el promedio varia segun la intensidad de la escala de grises
                let gris = ((r + g + b) / this.intensidad);
                this.setPixel(this.imageData, x, y, gris, gris, gris, a);
            }
        }
    }
}
