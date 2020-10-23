import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private ArrayList<GivenAnswer> givenAnswers;

    private int quizId;
    private int quizPrice;
    private int questionIndex;
    private int totalCorrectlyAnswered;

    private long timestamp;

    public Quiz (){
    }

    public void setupQuiz(){

    }
    public int getQuizPrice() {
        return quizPrice;
    }
    public Question getQuestion(int index){
        return questions[i];
    }



}
