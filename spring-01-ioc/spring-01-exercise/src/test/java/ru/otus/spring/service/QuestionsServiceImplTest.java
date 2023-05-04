package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.QuestionsDao;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class QuestionsServiceImpl.java")
class QuestionsServiceImplTest {

  @Mock
  private QuestionsService questionsService;

  @DisplayName("must return correct string all tests")
  @Test
  void printQuestionsAllTest() {
    questionsService.printQuestionsAll();

    verify(questionsService, times(1)).printQuestionsAll();
  }
}