class Sound {

    sound;
    
    constructor(url) {
        let sound = new Audio(url);
        this.sound = sound;
    }
    
    reproducir()
    {
        this.sound.play()
    }
}