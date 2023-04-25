package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionsDao {

  /**
   * Найти вопрос по номеру
   */
  Optional<Question> findById(Integer index);

  /**
   * Найти все вопросы
   */
  List<Question> findByAll();

  /**
   * Загрузить список вопросов
   */
  void loadQuestions();

  /**
   * Распечатоть все вопросы
   * @return
   */
  String printByAll();
}
