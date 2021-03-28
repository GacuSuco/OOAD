package OOAD.Quebble.Question;

import java.util.ArrayList;

public class ShortAnswerQuestion extends Question {
    private ArrayList<QuestionAnswer> questionAnswers;

    public ShortAnswerQuestion(String question, char rewardLetter, ArrayList<QuestionAnswer> questionAnswers) {
        super(question, rewardLetter);
        this.questionAnswers = questionAnswers;
    }

    @Override
    public boolean isCorrectAnswer(String givenAnswer) {
        for (QuestionAnswer answer : questionAnswers) {
            if (answer.getAnswer().equalsIgnoreCase(givenAnswer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.question + "\n\r";
    }
}