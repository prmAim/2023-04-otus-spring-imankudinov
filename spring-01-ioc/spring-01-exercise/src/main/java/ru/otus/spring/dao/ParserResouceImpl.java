package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;
import ru.otus.spring.service.LoadResource;

import java.util.ArrayList;
import java.util.List;
public class ParserResouceImpl implements ParserResouce {
  private final String _TRUE_ = "true";
  private final LoadResource loadResource;

  public ParserResouceImpl(LoadResource loadResource) {
    this.loadResource = loadResource;
  }

  public List<Question> parserResourceToQuestion(){
    List<Question> questions = new ArrayList<>();
    List<String> str = List.of(loadResource.loadFile().split("\\r\\n"));
    for (String line: str) {
      questions.add(parserStringToQuestion(line));
    }
    return questions;
  }

  private Question parserStringToQuestion(String line){
    //TODO:AnswersDaoImpl
    AnswersDao answersDao = new AnswersDaoImpl();
    Question question = new Question();

    String[] splitLev1 = line.split("[;]", 4);
    String[] splitAnswerText = splitLev1[1].split(",");
    String[] splitAnswerCorrect = splitLev1[2].split(",");
    for (int i = 0; i < splitAnswerText.length; i++) {
      answersDao.addAnswer(splitAnswerText[i], (splitAnswerCorrect[i].equals(_TRUE_))?true:false);
    }
    question.setQuestionText(splitLev1[0]);
    question.setAnswers(answersDao);
    try{

    } catch (ArrayIndexOutOfBoundsException ex){
      System.out.println(ex.getMessage() + "Такого индекса нет!");
    }
    return question;
  }

  public LoadResource getLoadResource() {
    return loadResource;
  }
}
