class Saturacion extends Filter {

    constructor(width, height, ctx) {
        super(width, height, ctx);
    }

    drawRect() {
        for (let x = 0; x < this.width; x++) {
            for (let y = 0; y < this.height; y++) {

                // se instancia la clase que contiene los metodos para hacer las transformaciones de rgb a hsv y viceversa
                let formatter = new FormatColour();

                let r = this.getRed(this.imageData, x, y);
                let g = this.getGreen(this.imageData, x, y);
                let b = this.getBlue(this.imageData, x, y);
                
                /* 
                se transforman los valores de rgb a hsv
                se transforma el hsv a rgb para poder ser insertado
                */
               let hsl = formatter.rgbToHsl(r, g, b);
               hsl[1] = 1;
               let rgb = formatter.hslToRgb(hsl[0], hsl[1], hsl[2]);
                
                this.setPixel(this.imageData, x, y, rgb[0], rgb[1], rgb[2], 255);
            }
        }
    }
}