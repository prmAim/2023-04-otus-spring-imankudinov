package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.AnswersDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class Student")
class StudentTest {

  @Mock
  private AnswersDao answersDao;

  @DisplayName("have to create class with constructor")
  @Test
  void shouldHaveCorrectConstructorTest() {
    Student student = new Student("Ali Petty");
    student.setStudentId(1L);
    student.setMark(75);

    assertThat(student)
            .extracting("studentId", "fio", "mark")
            .contains(1L, "Ali Petty", 75.0f)
            .isNotNull()
            .isNotEmpty();
  }

  @DisplayName("must get correct the list of tests")
  @Test
  void getListTestsTest() {
    List<TestOfStudent> tests = new ArrayList<>(
            Arrays.asList(
                    new TestOfStudent(1L
                            , List.of(new Question("1*1=?", answersDao)
                                     ,new Question("1+1=?", answersDao))
                            , 70.0f)
            ));

    Student actualStudent = new Student("Ali Petty");
    actualStudent.setTests(tests);

    assertThat(actualStudent.getTests())
            .filteredOn(test -> test.getQuestionList().size() > 1)
            .hasSize(1);
  }
}