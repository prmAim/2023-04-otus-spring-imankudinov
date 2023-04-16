package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.dao.QuestionsDao;

class QuestionsServiceTest {

  @Test
  void printQuestionsAllTest() {
    String str = "Вопрос 1: Есть ли жизнь на марсе?";
    QuestionsDao questionsMock = Mockito.mock(QuestionsDao.class);
    Mockito.when(questionsMock.printByAll()).thenReturn(str);

    QuestionsService questionsService1 = new QuestionsServiceImpl(questionsMock);
    questionsService1.printQuestionsAll();
  }
}