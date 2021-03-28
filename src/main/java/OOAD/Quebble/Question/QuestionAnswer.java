package OOAD.Quebble.Question;

public class QuestionAnswer {
    private String answer;
    private boolean isCorrectly;

    public QuestionAnswer(String answer, boolean isCorrectAnswer) {
        this.answer = answer;
        this.isCorrectly = isCorrectAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrectly() {
        return isCorrectly;
    }
}
