package JustePrix;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Random random = new Random();
    private Player player;

    public void start() {
        int randomNumber = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonne chance " + player.getPseudo() + " !");

        int writedNumber;

        do {
            System.out.println("Entrez un chiffre.");
            writedNumber = scanner.nextInt();
            if (writedNumber > 100) {
                System.out.println("Érreur, votre nombre ne doit pas dépasser 100 !");
                continue;
            }

            if (writedNumber < randomNumber) {
                System.out.println("Le nombre aléatoire est plus grand.");
            } else {
                System.out.println("Le nombre aléatoire est plus petit.");
            }

        } while (writedNumber != randomNumber);
        System.out.println("Bien joué tu as trouvé le bon chiffre !\n");

        System.out.println("Voulez vous rejouer? (y/n)");
        String reponse = scanner.next();
        if(reponse.equals("y")){
            start();
        }
    }
}
