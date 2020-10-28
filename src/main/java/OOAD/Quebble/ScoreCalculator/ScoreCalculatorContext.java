package OOAD.Quebble.ScoreCalculator;

public class ScoreCalculatorContext {
    IScoreCalculator scoreCalculator;

    public ScoreCalculatorContext(IScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public IScoreCalculator getScoreCalculator() {
        return scoreCalculator;
    }
}
