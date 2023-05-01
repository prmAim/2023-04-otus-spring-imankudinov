package ru.otus.spring.domain;

import java.util.List;

public class TestOfStudent {

  private Long numberTest;
  private List<Question> questionList;
  private float successfulPercentOfPassTest;

  public TestOfStudent(Long numberTest, List<Question> questionList, float successfulPercentOfPassTest) {
    this.numberTest = numberTest;
    this.questionList = questionList;
    this.successfulPercentOfPassTest = successfulPercentOfPassTest;
  }

  public Long getNumberTest() {
    return numberTest;
  }

  public void setNumberTest(Long numberTest) {
    this.numberTest = numberTest;
  }

  public List<Question> getQuestionList() {
    return questionList;
  }

  public void setQuestionList(List<Question> questionList) {
    this.questionList = questionList;
  }

  public float getSuccessfulPercentOfPassTest() {
    return successfulPercentOfPassTest;
  }

  public void setSuccessfulPercentOfPassTest(float successfulPercentOfPassTest) {
    this.successfulPercentOfPassTest = successfulPercentOfPassTest;
  }
}
