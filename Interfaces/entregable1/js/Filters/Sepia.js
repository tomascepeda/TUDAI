class Sepia extends Filter {
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

                // se calculan los tonos sepia para los valores de rgb
                let tr = r * 0.393 + g * 0.769 + b * 0.189;
                let tg = r * 0.349 + g * 0.686 + b * 0.168;
                let tb = r * 0.272 + g * 0.534 + b * 0.131;

                if (tr > 255)
                    r = 255;
                else
                    r = tr;
                if (tg > 255)
                    g = 255;
                else
                    g = tg;
                if (tb > 255)
                    b = 255;
                else
                    b = tb;

                this.setPixel(this.imageData, x, y, r, g, b, a);
            }
        }
    }
}