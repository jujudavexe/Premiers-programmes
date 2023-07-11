package fr.jujudave.pendu;

import java.io.IOException;
import java.util.Scanner;

public class Game {


    public void PlayerPlay() throws IOException {

        WordDisplay wordDisplay = new WordDisplay();
        wordDisplay.WordDisplayRun();

        AleatoryWord aleatoryWord = new AleatoryWord();

        Scanner scanner = new Scanner(System.in);

        String wordAncient;
        int numberOfTurnsRemaining = 12;
        int i2;
        int charVerif = 0;
        for (i2 = 0; i2 < 12; i2++) {

            System.out.println("Entrez une lettre.");
            char playerInput = scanner.next().charAt(0);
            wordAncient = wordDisplay.getWordAttach();
            for (int searchLetter = 0; searchLetter < aleatoryWord.getRandomWord().length(); searchLetter++) {
                if (playerInput == aleatoryWord.getRandomWord().charAt(searchLetter)) {
                    wordDisplay.setWordAttach(wordDisplay.getWordAttach().substring(0, searchLetter) + playerInput + wordDisplay.getWordAttach().substring(searchLetter + 1));
                }


            }
            if (wordAncient.equalsIgnoreCase(wordDisplay.getWordAttach())){
                charVerif = 1;
            }
            if (charVerif == 1){
                numberOfTurnsRemaining--;

                charVerif = 0;
            } else {
                i2--;
            }
            System.out.println();
            System.out.println(wordDisplay.getWordAttach());


            if (wordDisplay.getWordAttach().equalsIgnoreCase(aleatoryWord.getRandomWord())) {
                break;
            } else {
                System.out.println();
                System.out.println("Il vous reste "+numberOfTurnsRemaining+" tours !");
                System.out.println();
            }

        }

        if (wordDisplay.getWordAttach().equalsIgnoreCase(aleatoryWord.getRandomWord())){
            System.out.println();
            System.out.println("Bravo, vous avez gagné !");
        } else if (i2 == 12) {
            System.out.println();
            System.out.println("Vous avez perdu, le mot était : "+aleatoryWord.getRandomWord());
        } else {
            System.out.println("ERREUR");
        }


    }


}
