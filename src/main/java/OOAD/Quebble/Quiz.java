package OOAD.Quebble;

import OOAD.Quebble.Question.Question;


import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int quizId;
    private int quizPrice;

    public Quiz(int quizId, int quizPrice, ArrayList<Question> questions) {
        this.quizId = quizId;
        this.quizPrice = quizPrice;
        this.questions = questions;
    }

    public int getQuizPrice() {
        return quizPrice;
    }
    public Question getQuestion(int index) {
        return questions.get(index);
    }
    public int getQuestionsSize() {
        return questions.size();
    }
}
