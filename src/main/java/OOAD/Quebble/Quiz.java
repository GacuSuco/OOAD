package OOAD.Quebble;

import OOAD.Quebble.Checkword.Checkword;
import OOAD.Quebble.Question.Question;
import OOAD.Quebble.ScoreCalculator.DefaultScoreCalculator;
import OOAD.Quebble.ScoreCalculator.IScoreCalculator;

import java.util.ArrayList;

public class Quiz {
    private IScoreCalculator ScoreCalculator;
    private Checkword checkword;
    private ArrayList<Question> questions;
    private ArrayList<GivenAnswer> givenAnswers;

    private int quizId;
    private int quizPrice;
    private int questionIndex;
    private int totalCorrectlyAnswered;

    private long timestamp;

    public Quiz (int quizId, int quizPrice, ArrayList<Question> questions){
        this.quizId = quizId;
        this.quizPrice = quizPrice;
        this.questions = questions;
    }

    public void setupQuiz(){
        this.questionIndex = 0;
        this.totalCorrectlyAnswered = 0;
        this.givenAnswers = new ArrayList<GivenAnswer>();
        this.checkword = new Checkword();

        this.timestamp = System.currentTimeMillis();
    }
    public int getQuizPrice() {
        return quizPrice;
    }
    public Question getQuestion(int index){
        return questions.get(index);
    }
    public Question getNextQuestion(){
        return getQuestion(questionIndex);
    }
    public void answerQuestion(String answer){
        Question question = this.getQuestion(this.questionIndex);
        givenAnswers.add(new GivenAnswer(question, answer));
        this.questionIndex++;
    }

    public boolean hasMoreQuestions() {
        return this.questionIndex < this.questions.size();
    }

    public ArrayList<Character> startCheckword() {
        for (int i = 0; i < givenAnswers.size(); i++) {
            boolean isCorrectly = givenAnswers.get(i).isCorrectlyAnswered();
            if (isCorrectly){
                char letter = questions.get(i).getRewardLetter();
                checkword.addEarnedLetter(letter);
                totalCorrectlyAnswered++;
            }
        }
        return checkword.getEarnedLetters();
    }
    public void answerCheckword(String answer){
        this.timestamp = System.currentTimeMillis() - timestamp;
        this.checkword.validateCheckword(answer);
    }
    public int calculateScore(){
        this.ScoreCalculator = new DefaultScoreCalculator();

        return this.ScoreCalculator.calculateScore(this.totalCorrectlyAnswered, this.timestamp, this.checkword.getGivenCheckword());
    }
}
