package ru.otus.spring.service;

import ru.otus.spring.dao.StudentsDao;
import ru.otus.spring.domain.Student;

public interface StudentsService {

  /**
   * Распечатать всех студентов
   */
  void printStudentAll();

  /**
   * Тестирование студента
   */
  Student testingStudent(long idStudent, long idTest);

  /**
   * Добавить студентов
   */
  void addStudent(String fio);

  /**
   * Найти всех студентов
   */
  StudentsDao findByAll();
}
