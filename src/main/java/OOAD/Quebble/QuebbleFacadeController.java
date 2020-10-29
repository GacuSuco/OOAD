package OOAD.Quebble;

import OOAD.Quebble.DAO.QuizDao;
import OOAD.Quebble.Question.Question;

import java.util.ArrayList;

public class QuebbleFacadeController {
    private QuizDao quizDao = new QuizDao();
    private Quiz quiz;

    public void startQuiz() {
        System.out.println("De quiz begint!");

        String username = Player.getInstance().getUsername();
        this.quiz = quizDao.getLeastPlayedQuizFromPLayer(username);

        int quizprice = this.quiz.getQuizPrice();

        if (Player.getInstance().hasSufficientBalance(quizprice)) {
            Player.getInstance().substractBalance(quizprice);
            this.quiz.setupQuiz();
        }
    }

    public boolean hasMoreQuestions() {
        return this.quiz.hasMoreQuestions();
    }

    public void getNextQuestion() {
        Question q = this.quiz.getNextQuestion();
        System.out.println(q.toString());
    }

    public void answerQuestion(String answer) {
        this.quiz.answerQuestion(answer);
    }

    public void startCheckword() {
        ArrayList<Character> characters = this.quiz.startCheckword();
        System.out.println("U speelt nu voor het Controlewoord, Uw verdiende letters zijn - " + characters);
    }

    public void answerCheckword(String answer) {
        quiz.answerCheckword(answer);
    }

    public void endQuiz() {
        int score = this.quiz.calculateScore();
        System.out.println("De quiz is gespeeld. Score:" + score);

        String username = Player.getInstance().getUsername();
        quizDao.UpdatePlayedQuizzes(username, quiz);

    }
}
