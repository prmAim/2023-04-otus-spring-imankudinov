package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

import java.util.List;

public interface ParserResouce {
  /**
   * разложить данные по вопросам
   */
  List<Question> parserResourceToQuestion();
}
