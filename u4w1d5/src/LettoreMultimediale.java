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
