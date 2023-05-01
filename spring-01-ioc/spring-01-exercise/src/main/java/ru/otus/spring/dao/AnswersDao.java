package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;

import java.util.List;

public interface AnswersDao {

  /**
   * Проверка указан ли правильно ответ на вопрос
   */
  boolean checkCorrectAnswer(Answer answer);

  /**
   * Добавление ответов
   */
  void addAnswer(String answer, boolean correctAnswer);

  /**
   * Получить весь список ответов
   * @return
   */
  List<Answer> findByAll();

}
