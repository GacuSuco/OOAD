package OOAD.Quebble.Checkword;

import java.util.ArrayList;

public class Checkword {
    private IDictionary dictionary;
    private ArrayList<Character> earnedLetters;
    private String givenCheckword = "";

    public Checkword (){
        this.givenCheckword = "";
        this.earnedLetters = new ArrayList<>();
    }

    public void addEarnedLetter(char letter){
        this.earnedLetters.add(letter);
    }
    public ArrayList<Character> getEarnedLetters(){
        return this.earnedLetters;
    }
    public void validateCheckword(String givenCheckword){
        if (this.hasValidLetters(givenCheckword)){
            dictionary = new DefaultDictionary();
            if(dictionary.validateWord(givenCheckword)){
                this.setGivenCheckword(givenCheckword);
            }
        }
    }
    public boolean hasValidLetters(String givenWord){
        givenWord = givenWord.toUpperCase();
        ArrayList<Character> cha = earnedLetters;

        if (givenWord.length() > 0 && givenWord.length() <= cha.size()){
            for (int i = 0; i < givenWord.length(); i++){
                if (!cha.remove(Character.valueOf(givenWord.charAt(i)))){
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public void setGivenCheckword(String givenCheckword){
        this.givenCheckword = givenCheckword;
    }
    public String getGivenCheckword() {
        return givenCheckword;
    }
}
