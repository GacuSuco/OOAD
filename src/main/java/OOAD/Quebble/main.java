package OOAD.Quebble;

import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        Player.getInstance().login("rustigeErick", "Welkom01");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        QuebbleFacadeController QFC = new QuebbleFacadeController();
        QFC.startQuiz();
        while (QFC.hasMoreQuestions()){
            QFC.getNextQuestion();
            QFC.answerQuestion(reader.readLine());
        }
        QFC.startCheckword();
        QFC.answerCheckword(reader.readLine());
        QFC.endQuiz();
    }
}
