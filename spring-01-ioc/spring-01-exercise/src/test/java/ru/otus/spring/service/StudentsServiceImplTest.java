package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.StudentsDao;
import ru.otus.spring.dao.TestsOfStudentsDao;
import ru.otus.spring.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class StudentsServiceImpl.java")
class StudentsServiceImplTest {
  @Mock
  private StudentsDao studentsDao;
  @Mock
  private TestsOfStudentsDao tests;

  @DisplayName("must add correct Student to Map")
  @Test
  void addStudent() {
    StudentsServiceImpl studentsService = new StudentsServiceImpl(studentsDao, tests);

    studentsService.addStudent("Ivan");

    given(studentsDao.findByFIO(any())).willReturn(true);

    assertThat(studentsService.findByAll().findByFIO("Ivan"))
            .isTrue();
  }

  @DisplayName("must find all students")
  @Test
  void findByAll() {
    StudentsServiceImpl studentsService = new StudentsServiceImpl(studentsDao, tests);

    given(studentsDao.findByAll()).willReturn(new ArrayList<>(Arrays.asList(
            new Student("Ilya")
            ,new Student("Dobinya")
            ,new Student("Alex")
    )));

    assertThat(studentsService.findByAll().findByAll())
            .filteredOn("fio", in("Ilya", "Dobinya", "Alex"))
            .hasSize(3);
  }
}