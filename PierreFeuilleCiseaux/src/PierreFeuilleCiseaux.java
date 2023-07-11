import java.util.Scanner;
import java.util.Random;

public class PierreFeuilleCiseaux {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choix = {"pierre", "feuille", "ciseaux"};

        System.out.println("Jouons à pierre-feuille-ciseaux !");

        while (true) {
            System.out.print("Choisissez pierre, feuille ou ciseaux : ");
            String choixUtilisateur = scanner.nextLine().toLowerCase();


            if (!choixUtilisateur.equals("pierre") && !choixUtilisateur.equals("feuille") && !choixUtilisateur.equals("ciseaux")) {
                System.out.println("Choix invalide. Veuillez choisir pierre, feuille ou ciseaux.");
                continue;
            }

            String choixOrdinateur = choix[random.nextInt(3)];

            System.out.println("L'ordinateur a choisi : " + choixOrdinateur);

            if (choixUtilisateur.equals(choixOrdinateur)) {
                System.out.println("Égalité !");
            } else if (choixUtilisateur.equals("pierre") && choixOrdinateur.equals("ciseaux") ||
                    choixUtilisateur.equals("feuille") && choixOrdinateur.equals("pierre") ||
                    choixUtilisateur.equals("ciseaux") && choixOrdinateur.equals("feuille")) {
                System.out.println("Vous avez gagné !");
            } else {
                System.out.println("L'ordinateur a gagné !");
            }

            System.out.print("Voulez-vous jouer à nouveau ? (Oui/Non) : ");

            if (!scanner.nextLine().equalsIgnoreCase("oui")) {
                break;
            }
        }

        System.out.println("Merci d'avoir joué !");
    }
}
