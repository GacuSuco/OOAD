package OOAD.Quebble;

import OOAD.Quebble.Question.Question;

import java.util.ArrayList;

public class Player {
    private ArrayList<QuizExecution> quizExecutions;

    private String username;
    private int credit;

    public Player(String username, int credit,ArrayList<QuizExecution> quizExecutions) {
        this.username = username;
        this.credit = credit;
        this.quizExecutions = quizExecutions != null ? quizExecutions : new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }
    public int getCredit(){
        return this.credit;
    }
    public QuizExecution getQuizExecution(int quizId){
        for (QuizExecution qe : quizExecutions) {
            if(qe.getQuizId() == quizId){
                return qe;
            }
        }
        return null;
    }

    public void substractBalance(int givenBalance) {
        this.credit -= givenBalance;
    }
    public boolean hasSufficientBalance(int givenBalance){
        return this.credit > givenBalance;
    }

    public int startQuiz(){
        int quizid = 0;
        if (getCredit() >= 40){
            substractBalance(40);

            QuizExecution quizExecution = new QuizExecution();
            quizid = quizExecution.startQuiz(this.getUsername());

            this.quizExecutions.add(quizExecution);
        }
        return quizid;
    }
    public boolean hasMoreQuestions(int quizid) {
        return getQuizExecution(quizid).hasMoreQuestions();
    }
    public Question getCurrentQuestion(int quizid) {
        return getQuizExecution(quizid).getCurrentQuestion();
    }
    public void answerQuestion(String answer, int quizid) {
        getQuizExecution(quizid).answerQuestion(answer);
    }
    public ArrayList<Character> startCheckword(int quizid) {
        return getQuizExecution(quizid).startCheckword();
    }
    public void answerCheckword(String answer, int quizid) {
        getQuizExecution(quizid).answerCheckword(answer);
    }
    public int endQuiz(int quizid) {
        return getQuizExecution(quizid).endQuiz(getUsername());
    }
}
