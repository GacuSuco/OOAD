package OOAD.Quebble;

import OOAD.Quebble.DAO.Player.IPlayerDao;
import OOAD.Quebble.DAO.Player.PlayerDAO;
import OOAD.Quebble.Question.Question;

import java.util.ArrayList;

public class QuebbleFacadeController {
    private UserInterface userinterface = new UserInterface();
    private IPlayerDao playerDao = new PlayerDAO();

    public int startQuiz(String username) {
        userinterface.showIntroQuiz();
        return playerDao.getPlayer(username).startQuiz();
    }

    public boolean hasMoreQuestions(String username, int quizid) {
        return playerDao.getPlayer(username).hasMoreQuestions(quizid);
    }

    public void getCurrentQuestion(String username, int quizid) {
        Question question = playerDao.getPlayer(username).getCurrentQuestion(quizid);
        userinterface.showCurrentQuestion(question);
    }

    public void answerQuestion(String username, int quizid, String answer) {
        playerDao.getPlayer(username).answerQuestion(quizid, answer);
    }

    public void startCheckword(String username, int quizid) {
        ArrayList<Character> earnedletters = playerDao.getPlayer(username).startCheckword(quizid);
        userinterface.showStartCheckword(earnedletters);
    }

    public void answerCheckword(String username, int quizid, String answer) {
        playerDao.getPlayer(username).answerCheckword(quizid, answer);
    }

    public void endQuiz(String username, int quizid) {
        int score = playerDao.getPlayer(username).endQuiz(quizid);
        userinterface.showEndResults(score);
    }
}
