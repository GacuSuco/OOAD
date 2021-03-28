package OOAD.Quebble;

import OOAD.Quebble.DAO.Player.IPlayerDao;
import OOAD.Quebble.DAO.Player.PlayerDAO;
import OOAD.Quebble.Question.Question;

import java.util.ArrayList;

public class QuebbleFacadeController {
    private Userinterface userinterface = new Userinterface();
    private IPlayerDao playerDAO = new PlayerDAO();

    public int startQuiz(String username) {
        userinterface.showIntroQuiz();
        return playerDAO.getPlayer(username).startQuiz();
    }

    public boolean hasMoreQuestions(String username, int quizid) {
        return playerDAO.getPlayer(username).hasMoreQuestions(quizid);
    }

    public void getCurrentQuestion(String username, int quizid) {
        Question question = playerDAO.getPlayer(username).getCurrentQuestion(quizid);
        userinterface.showCurrentQuestion(question.toString());
    }

    public void answerQuestion(String answer, String username, int quizid) {
        playerDAO.getPlayer(username).answerQuestion(answer,quizid);
    }

    public void startCheckword(String username, int quizid) {
        ArrayList<Character> characters = playerDAO.getPlayer(username).startCheckword(quizid);
        userinterface.showStartCheckword(characters);
    }

    public void answerCheckword(String answer, String username, int quizid) {
        playerDAO.getPlayer(username).answerCheckword(answer,quizid);
    }

    public void endQuiz(String username, int quizid) {
        int score = playerDAO.getPlayer(username).endQuiz(quizid);
        userinterface.showEndResults(score);
    }
}
