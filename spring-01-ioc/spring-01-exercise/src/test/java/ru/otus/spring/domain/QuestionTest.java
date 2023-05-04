package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.AnswersDao;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.BDDMockito.given;

@DisplayName("Class Question")
@ExtendWith(MockitoExtension.class)
class QuestionTest {

  @Mock
  private AnswersDao answers;

  @DisplayName("have to create class with constructor. Testing question text.")
  @Test
  void shouldHaveCorrectConstructorTest1() {
    Question actualQuestion = new Question("1+1=?", answers);

    assertThat(actualQuestion)
            .isNotNull()
            .hasFieldOrPropertyWithValue("questionText", "1+1=?");
  }

  @DisplayName("have to create class with constructor. Testing answers.")
  @Test
  void shouldHaveCorrectConstructorTest2() {
    Question actualQuestion = new Question("1+1=?", answers);

    given(answers.findByAll()).willReturn(new ArrayList<>(
            Arrays.asList(
                    new Answer("0", false),
                    new Answer("1", false),
                    new Answer("2", true)
            )));

    assertThat(actualQuestion.getAnswers().findByAll())
            .extracting("answer", "correctAnswer")
            .contains(tuple("0", false), tuple("1", false), tuple("2", true))
            .doesNotContain(tuple("3", true));
  }

  @Test
  void testToStringTest() {
    Question actualQuestion = new Question("1+0=?", answers);

    given(answers.findByAll()).willReturn(new ArrayList<>(
            Arrays.asList(
                    new Answer("0", false),
                    new Answer("1", true)
            )));

    assertThat(actualQuestion.toString())
            .as("The question: 1+0=?\n " +
                    "The Answer option 1: 0\n" +
                    "The Answer option 2: 1\n");
  }
}