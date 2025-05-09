class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile, RegolazioneVolume {
    private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void play() {
        if (volume > 0) {
            for (int i = 0; i < durata; i++) {
                System.out.print(titolo);
                for (int j = 0; j < volume; j++) {
                    System.out.print("!");
                }
                System.out.println();
            }
        } else {
            System.out.println(titolo + " (volume 0, niente suono)");
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if (volume > 0) volume--;
    }

    public void esegui() {
        play();
    }
}
