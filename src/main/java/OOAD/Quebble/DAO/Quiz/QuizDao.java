package OOAD.Quebble.DAO.Quiz;

import OOAD.Quebble.Question.MultipleChoiceQuestion;
import OOAD.Quebble.Question.Question;
import OOAD.Quebble.Question.QuestionAnswer;
import OOAD.Quebble.Question.ShortAnswerQuestion;
import OOAD.Quebble.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class QuizDao implements IQuizDao {
    public Quiz getLeastPlayedQuizFromPLayer(String username) {
        HashMap<String, QuestionAnswer> qa;
        ArrayList<Question> questions = new ArrayList<>();

        String qs = "Wat is de hoofdstad van Peru?";
        char rl = 'L';
        qa = new HashMap<>();
        qa.put("A", new QuestionAnswer("Arequipa", false));
        qa.put("B", new QuestionAnswer("Caracas", false));
        qa.put("C", new QuestionAnswer("Lima", true));
        qa.put("D", new QuestionAnswer("Santiago", false));
        questions.add(new MultipleChoiceQuestion(qs, rl, qa));

        qs = "Hoe heet het officieuze landenkampioenschap tennis voor mannen?";
        rl = 'D';
        qa = new HashMap<>();
        qa.put("A", new QuestionAnswer("Davis Cup", true));
        qa.put("B", new QuestionAnswer("Diamond League", false));
        qa.put("C", new QuestionAnswer("Fed Cup", false));
        qa.put("D", new QuestionAnswer("Nations League", false));
        questions.add(new MultipleChoiceQuestion(qs, rl, qa));

        qs = "Wat is de voornaam van de schepper van Miss Marple en Hercule Poirot?";
        rl = 'A';
        qa = new HashMap<>();
        qa.put("A", new QuestionAnswer("Ruth", false));
        qa.put("B", new QuestionAnswer("Emmy", false));
        qa.put("C", new QuestionAnswer("Joanne", false));
        qa.put("D", new QuestionAnswer("Agatha", true));
        questions.add(new MultipleChoiceQuestion(qs, rl, qa));

        qs = "Welke van de volgende Engelse voetbalclub is afkomstig uit Liverpool?";
        rl = 'E';
        qa = new HashMap<>();
        qa.put("A", new QuestionAnswer("Arsenal", false));
        qa.put("B", new QuestionAnswer("Chelsea", false));
        qa.put("C", new QuestionAnswer("Everton", true));
        qa.put("D", new QuestionAnswer("Tottenham Hotspur", false));
        questions.add(new MultipleChoiceQuestion(qs, rl, qa));

        qs = "Wat is de hoofdstad van het Franse departement Vaucluse die we kennen uit een heel bekend liedje over een brug?";
        rl = 'A';
        questions.add(new ShortAnswerQuestion(qs, rl, new ArrayList<>(Arrays.asList(new QuestionAnswer("Avignon", true)))));

        qs = "Welke band stond in 2008 in de hitparade met de song Viva La Vida?";
        rl = 'C';
        questions.add(new ShortAnswerQuestion(qs, rl, new ArrayList<>(Arrays.asList(new QuestionAnswer("Coldplay", true)))));

        qs = "Wat is de bijnaam van de Conservatieve Partij in Engeland?";
        rl = 'T';
        questions.add(new ShortAnswerQuestion(qs, rl, new ArrayList<>(Arrays.asList(new QuestionAnswer("Tory", true), new QuestionAnswer("Tories", true), new QuestionAnswer("The Tories", true)))));

        qs = "Wat stad ligt in twee continenten?";
        rl = 'I';
        questions.add(new ShortAnswerQuestion(qs, rl, new ArrayList<>(Arrays.asList(new QuestionAnswer("Instanboel", true), new QuestionAnswer("Instanbul", true)))));

        return new Quiz(1337, questions);
    }

    public void UpdatePlayedQuizzes(String username, Quiz playedQuiz, int score) {
        //TODO: Update naar db dat quiz gespeeld is.
    }
}
