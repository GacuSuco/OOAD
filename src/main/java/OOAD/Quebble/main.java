package OOAD.Quebble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        QuebbleFacadeController QFC = new QuebbleFacadeController();

        String username = "rustigeErik";
        int quizid = QFC.startQuiz(username);
        if(quizid != 0){
            while (QFC.hasMoreQuestions(username, quizid)) {
                QFC.getCurrentQuestion(username, quizid);
                QFC.answerQuestion(reader.readLine(), username, quizid);
            }
            QFC.startCheckword(username, quizid);
            QFC.answerCheckword(reader.readLine(), username, quizid);
            QFC.endQuiz(username, quizid);
        }
    }
}
