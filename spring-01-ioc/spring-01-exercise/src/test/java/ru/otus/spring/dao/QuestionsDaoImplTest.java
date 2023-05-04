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
import static org.assertj.core.api.filter.InFilter.in;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class QuestionsDaoImpl.java")
class QuestionsDaoImplTest {

  @Mock
  ParserResouce parserResouce;

  @Mock
  AnswersDao answersDao;

  @DisplayName("must find class Question by the id")
  @Test
  void findByIdTest() {
    Question expectedQuestion = new Question("1*0=?", answersDao);
    Question question2 = new Question("1+1=?", answersDao);

    given(parserResouce.parserResourceToQuestion()).willReturn(new ArrayList<>(
            Arrays.asList(question2, expectedQuestion)
    ));

    QuestionsDaoImpl actualQuestions = new QuestionsDaoImpl(parserResouce);
    actualQuestions.loadQuestions();

    assertThat(actualQuestions.findById(1))
            .hasValue(expectedQuestion)
            .isNotEqualTo(question2)
            .isNotNull();
  }

  @DisplayName("must find all classes Question")
  @Test
  void findByAllTest() {
    Question question = new Question("1*0=?", answersDao);
    Question question2 = new Question("1+1=?", answersDao);

    given(parserResouce.parserResourceToQuestion()).willReturn(new ArrayList<>(
            Arrays.asList(question, question2)
    ));

    QuestionsDaoImpl actualQuestions = new QuestionsDaoImpl(parserResouce);
    actualQuestions.loadQuestions();

    assertThat(actualQuestions.findByAll())
            .filteredOn("questionText", in("1*0=?", "1+1=?"))
            .hasSize(2);
  }

  @DisplayName("must return text the list of questions")
  @Test
  void printByAllTest() {
    Question question = new Question("1*0=?", answersDao);
    Question question2 = new Question("1+1=?", answersDao);

    given(parserResouce.parserResourceToQuestion()).willReturn(new ArrayList<>(
            Arrays.asList(question, question2)
    ));

    QuestionsDaoImpl actualQuestions = new QuestionsDaoImpl(parserResouce);
    actualQuestions.loadQuestions();

    assertThat(actualQuestions.printByAll())
            .as("The questions:\n" +
                    "The question 1) 1*0=?\n" +
                    "The question 2) 1+1=?\n")
            .isNotEmpty()
            .isNotNull();
  }
}