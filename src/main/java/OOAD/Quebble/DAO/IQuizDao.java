package OOAD.Quebble.DAO;

import OOAD.Quebble.Quiz;

public interface IQuizDao {
    Quiz getLeastPlayedQuizFromPLayer(String username);
    void UpdatePlayedQuizzes(String username, Quiz playedQuiz);
}
