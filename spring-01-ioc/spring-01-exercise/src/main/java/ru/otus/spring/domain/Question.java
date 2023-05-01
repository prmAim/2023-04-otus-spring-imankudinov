package ru.otus.spring.domain;

import ru.otus.spring.dao.AnswersDao;

public class Question {

  private String questionText;
  private AnswersDao answers;

  public Question() {
  }

  public Question(String questionText, AnswersDao answers) {
    this.answers = answers;
    this.questionText = questionText;
  }

  public AnswersDao getAnswers() {
    return answers;
  }

  public void setAnswers(AnswersDao answers) {
    this.answers = answers;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("The question: " + questionText + "\n");
    for (int i = 0; i < answers.findByAll().size(); i++) {
      str.append("The Answer option " + (i + 1) + ": ");
      str.append(answers.findByAll().get(i).toString());
      str.append("\n");
    }
    return str.toString();
  }
}
