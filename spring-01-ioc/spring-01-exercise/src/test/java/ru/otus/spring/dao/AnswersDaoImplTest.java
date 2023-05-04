package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Class AnswersDaoImpl")
class AnswersDaoImplTest {

  @DisplayName("must check the correct answer")
  @Test
  void checkCorrectAnswerByIDTest() {
    AnswersDao answers = new AnswersDaoImpl();
    answers.addAnswer("is correct answer", true);
    answers.addAnswer("is not correct answer", false);

    assertThat(answers.checkCorrectAnswerByID(0))
            .isTrue();
  }

  @DisplayName("must add Answer")
  @Test
  void addAnswerTest() {
    AnswersDao answers = new AnswersDaoImpl();
    answers.addAnswer("is correct answer", true);

    assertThat(answers.findByAll())
            .extracting("answer", "correctAnswer")
            .contains(tuple("is correct answer", true))
            .isNotEmpty();
  }

  @DisplayName("must find all answers")
  @Test
  void findByAllTest() {
    AnswersDao answers = new AnswersDaoImpl();
    answers.addAnswer("is correct answer", true);
    answers.addAnswer("is not correct answer", false);

    assertThat(answers.findByAll())
            .extracting("answer", "correctAnswer")
            .contains(tuple("is correct answer", true), tuple("is not correct answer", false))
            .isNotEmpty();
  }
}