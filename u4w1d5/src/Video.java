class Video extends ElementoMultimediale implements Riproducibile, RegolazioneVolume, RegolazioneLuminosita {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void play() {
        if (volume > 0 || luminosita > 0) {
            for (int i = 0; i < durata; i++) {
                System.out.print(titolo);
                for (int j = 0; j < volume; j++) {
                    System.out.print("!");
                }
                for (int k = 0; k < luminosita; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else {
            System.out.println(titolo + " (nessun suono o luminosità)");
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if (volume > 0) volume--;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) luminosita--;
    }

    public void esegui() {
        play();
    }
}
