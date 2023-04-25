package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionsDao;

@Service("questionsService")
public class QuestionsServiceImpl implements QuestionsService {

  private final QuestionsDao questions;

  @Autowired
  public QuestionsServiceImpl(QuestionsDao questions) {
    this.questions = questions;
  }

  @Override
  public void printQuestionsAll() {
    System.out.println(questions.printByAll());
  }
}
