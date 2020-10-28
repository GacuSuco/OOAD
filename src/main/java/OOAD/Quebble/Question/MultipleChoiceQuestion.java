package OOAD.Quebble.Question;

import java.util.HashMap;

public class MultipleChoiceQuestion extends Question {

    private HashMap<String, QuestionAnswer> answers;

    public MultipleChoiceQuestion(String question, char rewardLetter, HashMap<String, QuestionAnswer> answers) {
        super(question, rewardLetter);
        this.answers = answers;
    }


    @Override
    public boolean isCorrectAnswer(String givenAnswer) {
        if (this.answers.containsKey(givenAnswer.toUpperCase())) {
            return this.answers.get(givenAnswer.toUpperCase()).isCorrectAnswer;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.question).append("\n\r");
        for (String answer : answers.keySet()) {
            stringBuilder.append(answer).append("\t");
            stringBuilder.append(answers.get(answer).answer).append("\n\r");
        }
        return stringBuilder.toString();
    }
}