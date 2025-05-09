import java.util.Scanner;

public class LettoreMultimediale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Elemento " + (i + 1));
            int tipo = -1;
            while (tipo < 1 || tipo > 3) {
                System.out.print("Tipo (1=Immagine, 2=Audio, 3=Video): ");
                try {
                    tipo = Integer.parseInt(scanner.nextLine());
                    if (tipo < 1 || tipo > 3) {
                        System.out.println("Tipo non valido. Riprova.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input non valido. Inserisci un numero valido.");
                }
            }

            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();

            switch (tipo) {
                case 1:
                    System.out.print("Luminosità: ");
                    int lum = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Immagine(titolo, lum);
                    break;
                case 2:
                    System.out.print("Durata: ");
                    int durataA = Integer.parseInt(scanner.nextLine());
                    System.out.print("Volume: ");
                    int volA = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new RegistrazioneAudio(titolo, durataA, volA);
                    break;
                case 3:
                    System.out.print("Durata: ");
                    int durataV = Integer.parseInt(scanner.nextLine());
                    System.out.print("Volume: ");
                    int volV = Integer.parseInt(scanner.nextLine());
                    System.out.print("Luminosità: ");
                    int lumV = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Video(titolo, durataV, volV, lumV);
                    break;
            }
        }

        int scelta;
        do {
            System.out.print("\nScegli elemento da eseguire (1-5, 0 per uscire): ");
            scelta = Integer.parseInt(scanner.nextLine());
            if (scelta >= 1 && scelta <= 5) {
                elementi[scelta - 1].esegui();
            } else if (scelta != 0) {
                System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 0);

        scanner.close();
    }
}

interface Riproducibile {
    void play();
}

interface RegolazioneVolume {
    void alzaVolume();
    void abbassaVolume();
}

interface RegolazioneLuminosita {
    void aumentaLuminosita();
    void diminuisciLuminosita();
}

abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public abstract void esegui();
}

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
