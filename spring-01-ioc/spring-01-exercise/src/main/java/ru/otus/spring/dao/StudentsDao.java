package ru.otus.spring.dao;

import ru.otus.spring.domain.Student;
import ru.otus.spring.domain.TestOfStudent;

import java.util.List;

public interface StudentsDao {

  /**
   * Добавить студента
   */
  void addStudent(String fio);

  /**
   * найти всех студентов
   */
  List<Student> findByAll();

  /**
   * найти студента по id
   */
  Student findById(long id);

  /**
   * найти студента по Фамилии+Имени+Отчеству
   */
  boolean findByFIO(String fio);

  /**
   *  записать результат теста, пройденого студентом
   */
  void setTestToStudent(TestOfStudent test, float mark, long studentId);
}
