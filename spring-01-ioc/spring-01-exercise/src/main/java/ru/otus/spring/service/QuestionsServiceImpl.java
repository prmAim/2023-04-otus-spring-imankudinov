package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionsDao;

public class QuestionsServiceImpl implements QuestionsService {

  private final QuestionsDao questions;

  public QuestionsServiceImpl(QuestionsDao questions) {
    this.questions = questions;
  }

  @Override
  public void printQuestionsAll() {
    System.out.println(questions.printByAll());
  }
}
