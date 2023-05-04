package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.TestOfStudent;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class StudentsDaoImpl.java")
class StudentsDaoImplTest {

  @Mock
  AnswersDao answersDao;

  @DisplayName("must add class Student in list")
  @Test
  void addStudentTest() {
    StudentsDao actualStudents = new StudentsDaoImpl();

    actualStudents.addStudent("Jerry");

    assertThat(actualStudents.findByAll())
            .filteredOn(student -> student.getFio().equals("Jerry"))
            .hasSize(1);
  }

  @DisplayName("must find all classes Student")
  @Test
  void findByAllTest() {
    StudentsDao actualStudents = new StudentsDaoImpl();

    actualStudents.addStudent("Tom");
    actualStudents.addStudent("Jerry");

    assertThat(actualStudents.findByAll())
            .extracting("fio")
            .contains("Tom", "Jerry")
            .doesNotContain("Masha")
            .isNotEmpty()
            .isNotNull();
  }

  @DisplayName("must find class Student by id of Student")
  @Test
  void findByIdTest() {
    StudentsDao actualStudents = new StudentsDaoImpl();

    actualStudents.addStudent("Tom");
    actualStudents.addStudent("Jerry");

    assertThat(actualStudents.findById(1))
            .hasFieldOrPropertyWithValue("fio", "Tom")
            .isNotNull();
  }

  @DisplayName("must return true, when add this student ")
  @Test
  void findByFIOTest() {
    StudentsDao actualStudents = new StudentsDaoImpl();

    actualStudents.addStudent("Jerry");

    assertThat(actualStudents.findByFIO("Jerry"))
            .isTrue();
    assertThat(actualStudents.findByFIO("Tom"))
            .isFalse();
  }

  @DisplayName("must add the Test correct")
  @Test
  void setTestToStudentTest() {
    TestOfStudent expectedTest = new TestOfStudent(1L
            , new ArrayList<>(Arrays.asList(new Question("1/1=?", answersDao)))
            , 75.0f);

    StudentsDao actualStudents = new StudentsDaoImpl();
    actualStudents.addStudent("Jerry");

    actualStudents.setTestToStudent(expectedTest, 80.0f, 1L);

    assertThat(actualStudents.findById(1L).getTests())
            .filteredOn(test -> test.equals(expectedTest))
            .hasSize(1);
  }
}