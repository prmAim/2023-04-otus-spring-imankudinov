package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class TestsOfStudentsDaoImpl.java")
class TestsOfStudentsDaoImplTest {

  @Mock
  private AnswersDao answersDao;
  @Mock
  private QuestionsDao questions;

  @DisplayName("must find all tests")
  @Test
  void findByAllTest() {
    given(questions.findByAll()).willReturn(
            new ArrayList<>(Arrays.asList(
                    new Question("1*1=?", answersDao)
                    , new Question("1/1=?", answersDao)
            ))
    );

    TestsOfStudentsDao actualTests = new TestsOfStudentsDaoImpl(75.0f, questions);

    assertThat(actualTests.findByAll())
            .filteredOn(test -> test.getQuestionList().size() == 2)
            .hasSize(1);
  }

  @DisplayName("must find test by id of test")
  @Test
  void findByIdTest() {
    given(questions.findByAll()).willReturn(
            new ArrayList<>(Arrays.asList(
                    new Question("1*1=?", answersDao)
                    , new Question("1/1=?", answersDao)
            ))
    );

    TestsOfStudentsDao actualTests = new TestsOfStudentsDaoImpl(75.0f, questions);

    assertThat(actualTests.findById(1L))
            .hasFieldOrPropertyWithValue("numberTest", 1L)
            .isNotNull();
  }

  @DisplayName("must result false, because put bad mark")
  @Test
  void resultRunTestTest() {
    given(questions.findByAll()).willReturn(
            new ArrayList<>(Arrays.asList(
                    new Question("1*1=?", answersDao)
                    , new Question("1/1=?", answersDao)
            ))
    );

    TestsOfStudentsDao actualTests = new TestsOfStudentsDaoImpl(75.0f, questions);

    assertThat(actualTests.resultRunTest(1L, 60.0f))
            .isFalse();
  }
}