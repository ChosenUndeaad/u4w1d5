class Immagine extends ElementoMultimediale implements RegolazioneLuminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void show() {
        if (luminosita > 0) {
            System.out.print(titolo);
            for (int i = 0; i < luminosita; i++) {
                System.out.print("*");
            }
            System.out.println();
        } else {
            System.out.println(titolo + " (nessuna luminosità)");
        }
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) luminosita--;
    }

    public void esegui() {
        show();
    }
}
