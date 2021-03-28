package OOAD.Quebble;

import OOAD.Quebble.Question.Question;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int quizId;

    public Quiz(int quizId, ArrayList<Question> questions) {
        this.quizId = quizId;
        this.questions = questions;
    }

    public int getQuizId() {
        return this.quizId;
    }
    public Question getQuestion(int index) {
        return questions.get(index);
    }
    public int getQuestionsSize() {
        return questions.size();
    }


}
