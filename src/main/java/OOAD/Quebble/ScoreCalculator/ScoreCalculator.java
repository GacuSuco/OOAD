package OOAD.Quebble.ScoreCalculator;

public class ScoreCalculator {
    private IScoreCalculatorStrategy scoreCalculatorStrategy;

    public ScoreCalculator() {}

    public IScoreCalculatorStrategy getScoreCalculatorStrategy() {
        return scoreCalculatorStrategy;
    }
    public void setScoreCalculatorStrategy(IScoreCalculatorStrategy scoreCalculatorStrategy) {
        this.scoreCalculatorStrategy = scoreCalculatorStrategy;
    }

    public int calculateScore(int totalCorrectlyAnswered, long timestamp, String givenCheckword) {
        return getScoreCalculatorStrategy().calculateScore(totalCorrectlyAnswered, timestamp, givenCheckword);
    }
}
