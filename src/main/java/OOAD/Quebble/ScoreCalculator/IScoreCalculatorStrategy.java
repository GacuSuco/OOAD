package OOAD.Quebble.ScoreCalculator;

public interface IScoreCalculatorStrategy {
    int calculateScore(int totalCorrectAnswers, long totalTimeToComplete, String checkword);
}
