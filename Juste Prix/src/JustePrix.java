package JustePrix;

import java.util.Scanner;

public class JustePrix {
    public static void main(String[] args) {

        System.out.println("Salut a toi ! Commence par entrer ton pseudo");
        Scanner scanner = new Scanner(System.in);
        String writedPseudo = scanner.next();

        Player myPlayer = new Player();
        myPlayer.setPseudo(writedPseudo);

        System.out.println("Début de la partie ...");
        Game game = new Game();
        game.setPlayer(myPlayer);

        game.start();


    }

}
