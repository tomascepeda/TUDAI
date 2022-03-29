class ScreenConfig
{

    tamFicha;
    marginTop;
    tamTamblero;

    static calcularTamaños()
    {
        if (screen.width > 1366) 
            this.tamFicha = 70;
        else
           this.tamFicha = 50;
        this.marginTop = this.tamFicha*1.5;
        this.tamTamblero = this.tamFicha * 8;
    }
    static getTamFicha()
    {
        return this.tamFicha;
    }
    static getMarginTop()
    {
        return this.marginTop;
    }
    static getRadio()
    {
        return this.getTamFicha() - (this.getTamFicha() * 0.15);
    }

}