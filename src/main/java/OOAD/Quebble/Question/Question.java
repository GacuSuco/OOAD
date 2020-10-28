package OOAD.Quebble.Question;

public abstract class Question {
    protected String question;
    private char rewardLetter;

    public Question(String question, char rewardLetter) {
        this.question = question;
        this.rewardLetter = rewardLetter;
    }

    public abstract boolean isCorrectAnswer(String givenAnswer);

    public char getRewardLetter() {
        return this.rewardLetter;
    }

    public abstract String toString();
}
