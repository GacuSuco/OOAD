package OOAD.Quebble.Question;

import java.util.HashMap;

public class MultipleChoiceQuestion extends Question {
    private HashMap<String, QuestionAnswer> questionAnswers;

    public MultipleChoiceQuestion(String question, char rewardLetter, HashMap<String, QuestionAnswer> questionAnswers) {
        super(question, rewardLetter);
        this.questionAnswers = questionAnswers;
    }

    @Override
    public boolean isCorrectAnswer(String givenAnswer) {
        if (this.questionAnswers.containsKey(givenAnswer.toUpperCase())) {
            return this.questionAnswers.get(givenAnswer.toUpperCase()).isCorrectly();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.question).append("\n\r");
        for (String answer : questionAnswers.keySet()) {
            stringBuilder.append(answer).append("\t");
            stringBuilder.append(questionAnswers.get(answer).getAnswer()).append("\n\r");
        }
        return stringBuilder.toString();
    }
}