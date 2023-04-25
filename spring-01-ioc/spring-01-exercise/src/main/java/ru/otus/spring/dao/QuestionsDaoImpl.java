package ru.otus.spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Question;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("questionsDao")
public class QuestionsDaoImpl implements QuestionsDao {
  private List<Question> questions;
  private final ParserResouce parserResouce;

  @Autowired
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

  @PostConstruct
  @Override
  public void loadQuestions() {
    questions = parserResouce.parserResourceToQuestion();
  }

  @Override
  public String printByAll() {
    StringBuilder strBuilder = new StringBuilder("The questions:\n");
    for (int i = 0; i < questions.size(); i++) {
      strBuilder.append("The question " + (i + 1) + ") ");
      strBuilder.append(questions.get(i).toString());
      strBuilder.append("\n");
    }
    return strBuilder.toString();
  }
}
