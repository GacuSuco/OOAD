package OOAD.Quebble.Question;

import java.util.ArrayList;

public class ShortAnswerQuestion extends Question {
    private ArrayList<String> answers;

    public ShortAnswerQuestion(String question, char rewardLetter, ArrayList<String> answers) {
        super(question, rewardLetter);
        this.answers = answers;
    }

    @Override
    public boolean isCorrectAnswer(String givenAnswer) {
        return this.answers.contains(givenAnswer);
    }

    @Override
    public String toString() {
        return this.question + "\n\r";
    }
}