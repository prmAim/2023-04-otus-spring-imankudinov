package ru.otus.spring.dao;


import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionsDaoImpl implements QuestionsDao {
  private List<Question> questions;
  private ParserResouce parserResouce;

  public QuestionsDaoImpl(ParserResouce parserResouce) {
    questions = new ArrayList<>();
    this.parserResouce = parserResouce;
  }

  @Override
  public Optional<Question> findById(Integer index) {
    return Optional.ofNullable(questions.get(index));
  }

  @Override
  public List<Question> findByAll() {
    return questions;
  }

  @Override
  public boolean checkAnswer(Integer index, Answer answer) {
    this.findById(index).get().getAnswers().checkCorrectAnswer(answer);
    return false;
  }

  @Override
  public void loadQuestions() {
    questions = parserResouce.parserResourceToQuestion();
  }

  @Override
  public String printByAll() {
    StringBuilder strBuilder = new StringBuilder("Список вопросов:\n");
    for (int i = 0; i < questions.size(); i++) {
      strBuilder.append("Вопрос " + (i + 1) + ") ");
      strBuilder.append(questions.get(i).toString());
      strBuilder.append("\n");
    }
    return strBuilder.toString();
  }

  public ParserResouce getParserResouce() {
    return parserResouce;
  }

  public void setParserResouce(ParserResouce parserResouce) {
    this.parserResouce = parserResouce;
  }
}
