package OOAD.Quebble.ScoreCalculator;

public interface IScoreCalculator {
    int calculateScore(int totalCorrectAnswers, long totalTimeToComplete, String checkword);
}
