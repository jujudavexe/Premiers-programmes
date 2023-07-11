package fr.jujudave.pendu;

import java.io.IOException;

public class WordDisplay {

    private String wordAttach = "";
    int underscoreNumber = 0;

    public void WordDisplayRun() throws IOException {
        AleatoryWord aleatoryWord = new AleatoryWord(); aleatoryWord.WordChoosing();
        underscoreNumber = aleatoryWord.getRandomWord().length();

        for(int i = 0; i != underscoreNumber; i++){
            wordAttach = wordAttach + "_";
        }
        System.out.println(wordAttach);
    }

    public String getWordAttach(){
        return wordAttach;
    }

    public void setWordAttach(String setterWordAttach){
        this.wordAttach = setterWordAttach;
    }
}
