package ru.otus.spring.domain;

public class Answer {

  private String answer;
  private boolean correctAnswer;

  public Answer() {}

  public Answer(String answer, boolean correctAnswer) {
    this.answer = answer;
    this.correctAnswer = correctAnswer;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public boolean isCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(boolean correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  @Override
  public String toString() {
    return answer;
  }
}
