class Blur extends Filter {

    constructor(width, height, ctx, intensidad) {
        super(width, height, ctx);
        this.copia = ctx.createImageData(this.width, this.height); // se crea la variable copia como una imageData nueva, esta guardara los valores rgb del difuminado
        this.intensidad = intensidad; // multiplicador que indica la distancia x e y (partiendo del pixel actual) de pixeles que se seleccionaran en la seleccion de la sub-matriz
        //mientras este varie, varian las distancias tanto en x como en y de pixeles a la redonda del pixel actual
    }

    drawRect() {
        for (let x = 0; x < this.width; x++) {
            for (let y = 0; y < this.height; y++) {

                // estos arreglos guardaran los valores de rgb de los vecinos del pixel actual
                let rn = [];
                let gn = [];
                let bn = [];

                // estos bucles recorren la sub-matriz de vecinos del pixel ubicado en x, y
                for (let i = x - 1; i < x + this.intensidad; i++) {
                    for (let j = y - 1; j < y + this.intensidad; j++) {
                        if ((i > 0 && i < this.width) && (j > 0 && j < this.height)) {
                            // se insertan en los arreglos los valores del pixel ubicado en i, j 
                            rn.push(this.getRed(this.imageData, i, j));
                            gn.push(this.getGreen(this.imageData, i, j));
                            bn.push(this.getBlue(this.imageData, i, j));
                        }
                    }
                }

                /*
                se calcula el promedio de valores rgb
                se insertan los resultados en una copia para evitar sobreescribir la matriz original que necesita el valor original 
                del pixel actual para continuar los calculos de los pixeles vecinos
                */

                let divisor = rn.length;
                let suma_r = 0;
                let suma_g = 0;
                let suma_b = 0;

                for (let k = 0; k < divisor; k++) {
                    suma_r += rn[k];
                    suma_g += gn[k];
                    suma_b += bn[k];
                }

                let r = suma_r / divisor;
                let g = suma_g / divisor;
                let b = suma_b / divisor;
                let a = 255;

                this.setPixel(this.copia, x, y, r, g, b, a);
            }
        }
    }

    getImageData() {
        // se evita hacer calculos innecesarios ya que con valores < 1 el difuminado no se aplica
        if (this.intensidad == 1)
            this.intensidad++;
        if (this.intensidad <= 0)
            return this.imageData;
        this.drawRect();
        return this.copia;
    }
}