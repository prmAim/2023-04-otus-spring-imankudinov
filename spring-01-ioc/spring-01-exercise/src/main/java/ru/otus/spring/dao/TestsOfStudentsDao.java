package ru.otus.spring.dao;

import ru.otus.spring.domain.TestOfStudent;

import java.util.List;

public interface TestsOfStudentsDao {
  /**
   * Получить весь список тестов
   */
  List<TestOfStudent> findByAll();

  /**
   * Найти тест по ИД
   */
  TestOfStudent findById(Long id);

  /**
   * Пройден ли тест
   */
  boolean resultRunTest(Long idTest, float mark);
}
