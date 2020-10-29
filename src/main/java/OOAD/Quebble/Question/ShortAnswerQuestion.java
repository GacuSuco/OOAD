package OOAD.Quebble.Question;

import java.util.ArrayList;

public class ShortAnswerQuestion extends Question {
    private ArrayList<QuestionAnswer> answers;

    public ShortAnswerQuestion(String question, char rewardLetter, ArrayList<QuestionAnswer> answers) {
        super(question, rewardLetter);
        this.answers = answers;
    }

    @Override
    public boolean isCorrectAnswer(String givenAnswer) {
        for (int i = 0; i < answers.size(); i++) {
            if (givenAnswer.equals(answers.get(i).answer)) {
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