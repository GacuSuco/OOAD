package OOAD.Quebble;

import OOAD.Quebble.Question.Question;

public class GivenAnswer {
    private Question question;
    private String answer;

    public GivenAnswer (Question question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public boolean isCorrectlyAnswered(){
        return this.question.isCorrectAnswer(this.answer);
    }



}
