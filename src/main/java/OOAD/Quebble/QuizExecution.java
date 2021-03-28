package OOAD.Quebble;

import OOAD.Quebble.Checkword.Checkword;
import OOAD.Quebble.DAO.Quiz.IQuizDao;
import OOAD.Quebble.DAO.Quiz.QuizDao;
import OOAD.Quebble.Question.Question;
import OOAD.Quebble.ScoreCalculator.DefaultScoreCalculatorStrategy;
import OOAD.Quebble.ScoreCalculator.ScoreCalculator;

import java.util.ArrayList;

public class QuizExecution {
    private IQuizDao quizDao = new QuizDao();
    private ScoreCalculator scoreCalculator;
    private ArrayList<GivenAnswer> givenAnswers;
    private Checkword checkword;
    private Quiz quiz;

    private int questionIndex;
    private int totalCorrectlyAnswered;
    private long timestamp;

    public QuizExecution() {
        this.questionIndex = 0;
        this.totalCorrectlyAnswered = 0;
        this.givenAnswers = new ArrayList<>();
        this.scoreCalculator = new ScoreCalculator();
        this.scoreCalculator.setScoreCalculatorStrategy(new DefaultScoreCalculatorStrategy());
    }

    public int getQuizId() {
        return quiz.getQuizId();
    }
    public int getQuestionIndex() {
        return questionIndex;
    }
    public Question getQuestion(int index) {
        return this.quiz.getQuestion(index);
    }

    public int startQuiz(String username) {
        quiz = quizDao.getLeastPlayedQuizFromPLayer(username);
        timestamp = System.currentTimeMillis();
        return getQuizId();
    }
    public boolean hasMoreQuestions() {
        return this.getQuestionIndex() < quiz.getQuestionsSize();
    }
    public Question getCurrentQuestion() {
        return getQuestion(this.getQuestionIndex());
    }
    public void answerQuestion(String answer) {
        Question question = getCurrentQuestion();
        givenAnswers.add(new GivenAnswer(question, answer));
        this.questionIndex++;
    }
    public ArrayList<Character> startCheckword() {
        this.checkword = new Checkword();
        for (int i = 0; i < givenAnswers.size(); i++) {
            boolean isCorrectly = givenAnswers.get(i).isCorrectlyAnswered();
            if (isCorrectly) {
                char letter = givenAnswers.get(i).getRewardLetter();
                checkword.addEarnedLetter(letter);
                this.totalCorrectlyAnswered++;
            }
        }
        return checkword.getEarnedLetters();
    }
    public void answerCheckword(String answer) {
        this.timestamp = System.currentTimeMillis() - timestamp;
        this.checkword.validateCheckword(answer);
    }
    public int endQuiz(String username) {
        int score = this.calculateScore();
        quizDao.UpdatePlayedQuizzes(username, quiz, score);
        return score;
    }

    private int calculateScore() {
        return this.scoreCalculator.calculateScore(this.totalCorrectlyAnswered, this.timestamp, this.checkword.getGivenCheckword());
    }
}
