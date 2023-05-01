package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Answer;

import java.util.ArrayList;
import java.util.List;

@Repository("answersDao")
public class AnswersDaoImpl implements AnswersDao {
  private List<Answer> answers;

  public AnswersDaoImpl() {
    answers = new ArrayList<>();
  }

  @Override
  public boolean checkCorrectAnswerByID(int answerId) {
    return answers.get(answerId).isCorrectAnswer();
  }

  @Override
  public void addAnswer(String answer, boolean correctAnswer) {
    answers.add(new Answer(answer, correctAnswer));
  }

  @Override
  public List<Answer> findByAll() {
    return answers;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("The option answers: \n");
    for (int i = 0; i < answers.size(); i++) {
      str.append((i + 1) + " " + answers.get(i).toString());
      str.append("\n");
    }
    return str.toString();
  }
}
