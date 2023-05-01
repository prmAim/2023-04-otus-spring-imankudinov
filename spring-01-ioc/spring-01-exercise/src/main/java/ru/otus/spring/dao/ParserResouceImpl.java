package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.LoadResource;

import java.util.ArrayList;
import java.util.List;

@Repository("parserResouce")
public class ParserResouceImpl implements ParserResouce {
    private final String _TRUE_ = "true";
    private final LoadResource loadResource;

    @Autowired
    public ParserResouceImpl(LoadResource loadResource) {
        this.loadResource = loadResource;
    }

    public List<Question> parserResourceToQuestion() {
        List<Question> questions = new ArrayList<>();
        List<String> str = List.of(loadResource.loadFile().split("\\r\\n"));
        for (String line : str) {
            questions.add(parserStringToQuestion(line));
        }
        return questions;
    }

    private Question parserStringToQuestion(String line) {
        //TODO:AnswersDaoImpl
        AnswersDao answersDao = new AnswersDaoImpl();
        Question question = new Question("",answersDao);
        try {
            String[] splitLev1 = line.split("[;]", 4);
            String[] splitAnswerText = splitLev1[1].split(",");
            String[] splitAnswerCorrect = splitLev1[2].split(",");
            for (int i = 0; i < splitAnswerText.length; i++) {
                answersDao.addAnswer(splitAnswerText[i], (splitAnswerCorrect[i].equals(_TRUE_)) ? true : false);
            }
            question.setQuestionText(splitLev1[0]);
            question.setAnswers(answersDao);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage() + " There is no such index!");
        }
        return question;
    }

    public LoadResource getLoadResource() {
        return loadResource;
    }
}
