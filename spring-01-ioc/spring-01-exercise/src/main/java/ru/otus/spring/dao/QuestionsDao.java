package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
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
   * Проверить ответ на вопрос
   */
  boolean checkAnswer(Integer index, Answer answer);

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
