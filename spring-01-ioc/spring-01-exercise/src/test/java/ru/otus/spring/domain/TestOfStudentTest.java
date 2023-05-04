package ru.otus.spring.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.AnswersDao;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class TestOfStudent")
class TestOfStudentTest {

  @Mock
  AnswersDao answers;

  @DisplayName("have to create class with constructor")
  @Test
  void shouldHaveCorrectConstructorTest() {
    TestOfStudent test = new TestOfStudent(5L, new ArrayList<>(
            Arrays.asList(new Question("1*1=?", answers)
                    , new Question("1+0=?", answers)
            ))
            , 20.0f);

    assertThat(test)
            .isNotNull()
            .extracting("numberTest", "successfulPercentOfPassTest")
            .contains(5L, 20.0f)
            .doesNotContain(1L, 25.0f)
            .doesNotContain(0L, 19.9F)
            .isNotEmpty();
  }

  @DisplayName("must get correct the list of tests")
  @Test
  void getListTestsTest() {
    TestOfStudent test = new TestOfStudent(2L, new ArrayList<>(
            Arrays.asList(new Question("1-1=?", answers)
                    , new Question("1*0=?", answers)
            ))
            , 80.0f);

    assertThat(test.getQuestionList())
            .filteredOn("questionText", in("1-1=?", "1*0=?"))
            .hasSize(2);
  }
}