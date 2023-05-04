package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class Answer")
class AnswerTest {

  @DisplayName("must to return the correct answer")
  @Test
  void isCorrectAnswerTest() {
    Answer isNotCorrectAnswer = new Answer("НЕверный ответ", false);

    assertThat(isNotCorrectAnswer.isCorrectAnswer())
                    .isEqualTo(false);
  }

  @DisplayName("have to create class with constructor")
  @Test
  void shouldHaveCorrectConstructorTest() {
    Answer actualAnswer = new Answer("Is correct answer", true);

    assertThat(actualAnswer)
            .extracting("answer", "correctAnswer")
            .contains("Is correct answer", true)
            .doesNotContain("Is not correct answer", false);

  }
}