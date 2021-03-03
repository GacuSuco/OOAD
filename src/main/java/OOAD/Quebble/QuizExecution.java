package OOAD.Quebble;

import OOAD.Quebble.Checkword.Checkword;
import OOAD.Quebble.DAO.IQuizDao;
import OOAD.Quebble.DAO.QuizDao;
import OOAD.Quebble.Question.Question;
import OOAD.Quebble.ScoreCalculator.DefaultScoreCalculator;
import OOAD.Quebble.ScoreCalculator.ScoreCalculatorContext;

import java.util.ArrayList;

public class QuizExecution {
    private IQuizDao quizDao = new QuizDao();
    private ScoreCalculatorContext ScoreCalculatorContext;
    private Checkword checkword;
    private ArrayList<GivenAnswer> givenAnswers;
    private Quiz quiz;

    private int questionIndex;
    private int totalCorrectlyAnswered;
    private long timestamp;
    private Player player;

    public QuizExecution (Player player){
        this.questionIndex = 0;
        this.totalCorrectlyAnswered = 0;
        this.givenAnswers = new ArrayList<GivenAnswer>();

        this.player = player;

        this.ScoreCalculatorContext = new ScoreCalculatorContext(new DefaultScoreCalculator());
    }

    public boolean startQuiz() {
        String username = player.getUsername();
        quiz = quizDao.getLeastPlayedQuizFromPLayer(username);

        int quizprice = this.quiz.getQuizPrice();
        boolean sufficientBalance = player.hasSufficientBalance(quizprice);

        if (sufficientBalance) {
            player.substractBalance(quizprice);
            this.timestamp = System.currentTimeMillis();
        }
        return sufficientBalance;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public Question getCurrentQuestion() {
        return getQuestion(this.getQuestionIndex());
    }

    public Question getQuestion(int index) {
        return this.quiz.getQuestion(index);
    }

    public boolean hasMoreQuestions() {
        return this.getQuestionIndex() < quiz.getQuestionsSize();
    }

    public void answerQuestion(String answer){
        Question question = getCurrentQuestion();
        givenAnswers.add(new GivenAnswer(question, answer));
        this.questionIndex++;
    }

    public ArrayList<Character> startCheckword() {
        this.checkword = new Checkword();
        for (int i = 0; i < givenAnswers.size(); i++){
            boolean isCorrectly = givenAnswers.get(i).isCorrectlyAnswered();
            if (isCorrectly){
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

    public void endQuiz(){
        int score = this.calculateScore();
        //TODO: Dit naar buitenste laag brengen.
        System.out.println("De quiz is gespeeld. Score:" + score);

        String username = player.getUsername();
        quizDao.UpdatePlayedQuizzes(username, quiz, score);
    }

    private int calculateScore() {
        return this.ScoreCalculatorContext.getScoreCalculator().calculateScore(this.totalCorrectlyAnswered, this.timestamp, this.checkword.getGivenCheckword());
    }
}
