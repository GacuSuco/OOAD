package OOAD.Quebble;

import java.util.ArrayList;

public class Userinterface {
    public void showIntroQuiz(){
        System.out.println("De quiz gaat beginnen.");
    }

    public void showCurrentQuestion(String question){
        System.out.println(question);
    }

    public void showStartCheckword(ArrayList<Character> characters){
        System.out.println("U speelt nu voor het Controlewoord, Uw verdiende letters zijn - " + characters);
    }

    public void showEndResults(int score){
        System.out.println("De quiz is gespeeld. Score:" + score);
    }

}
