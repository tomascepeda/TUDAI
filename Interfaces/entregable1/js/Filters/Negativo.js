class Negativo extends Filter {

    constructor(width, height, ctx) {
        super(width, height, ctx);
    }

    drawRect() {
        for (let x = 0; x < this.width; x++) {
            for (let y = 0; y < this.height; y++) {
                let r = this.getRed(this.imageData, x, y);
                let g = this.getGreen(this.imageData, x, y);
                let b = this.getBlue(this.imageData, x, y);
                let a = 255;
                
                // restando 255 a los valores de rgb se obtiene el color negativo del pixel
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                this.setPixel(this.imageData, x, y, r, g, b, a);
            }
        }
    }
}