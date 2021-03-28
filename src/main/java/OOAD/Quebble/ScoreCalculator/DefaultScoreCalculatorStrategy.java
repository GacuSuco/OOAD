package OOAD.Quebble.ScoreCalculator;

public class DefaultScoreCalculatorStrategy implements IScoreCalculatorStrategy {
    private static final int POINTS_PER_CORRECT_ANSWER = 625;
    private static final int POINTS_PER_LETTER = 250;
    private static final int TIME_TO_COMPLETE = 260000;

    @Override
    public int calculateScore(int totalCorrectAnswers, long totalTimeToComplete, String checkword) {
        int score = 0;

        score += totalCorrectAnswers * POINTS_PER_CORRECT_ANSWER;
        score += checkword.length() * POINTS_PER_LETTER;
        score += (TIME_TO_COMPLETE - totalTimeToComplete) / 1000;

        return score;
    }
}
