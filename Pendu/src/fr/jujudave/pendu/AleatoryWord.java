package fr.jujudave.pendu;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.io.IOException;

public class AleatoryWord {

    static String randomWord;
    public void WordChoosing() throws IOException{

        String file = Files.readString(Paths.get("mot.txt"));
        String[] file2 = file.split("\r\n");
        Random random = new Random();
        int numberProposition = random.nextInt(file2.length);
        randomWord = file2[numberProposition];


    }

    public String getRandomWord(){
        return randomWord;
    };

}
