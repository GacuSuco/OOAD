package OOAD.Quebble;

import OOAD.Quebble.Question.Question;

import java.util.ArrayList;

public class QuebbleFacadeController {
    private QuizExecution quizExecution;
    private Player player = new Player("rustige erick", 39);

    public boolean startQuiz() {
        // TODO: In een aparte laag zetten
        System.out.println("De quiz begint!");

        quizExecution = new QuizExecution(this.player);
        return quizExecution.startQuiz();
    }

    public boolean hasMoreQuestions() {
        return this.quizExecution.hasMoreQuestions();
    }

    public void getCurrentQuestion() {
        Question question = this.quizExecution.getCurrentQuestion();

        //TODO: In een aparte laag zetten
        System.out.println(question.toString());
    }

    public void answerQuestion(String answer) {
        this.quizExecution.answerQuestion(answer);
    }

    public void startCheckword() {
        ArrayList<Character> characters = this.quizExecution.startCheckword();
        System.out.println("U speelt nu voor het Controlewoord, Uw verdiende letters zijn - " + characters);
    }

    public void answerCheckword(String answer) {
        quizExecution.answerCheckword(answer);
    }

    public void endQuiz() {
        this.quizExecution.endQuiz();
    }
}
