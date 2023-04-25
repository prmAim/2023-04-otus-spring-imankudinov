package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.TestOfStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository("testsOfStudentsDao")
public class TestsOfStudentsDaoImpl implements TestsOfStudentsDao {
  private final Map<Long, TestOfStudent> tests;
  private final AtomicLong identity = new AtomicLong(0);

  @Autowired
  public TestsOfStudentsDaoImpl(@Value("${test.successfulPercentOfPassTest}") float successfulPercentOfPassTest,
                                QuestionsDao questions) {
    this.tests = new ConcurrentHashMap<>();
    createTests(successfulPercentOfPassTest, questions);
  }

  /**
   * создание списка тестов
   */
  private void createTests(float successfulPercentOfPassTest, QuestionsDao questions) {
    TestOfStudent test = new TestOfStudent(identity.incrementAndGet(), questions.findByAll(), successfulPercentOfPassTest);
    tests.put(test.getNumberTest(), test);
  }

  @Override
  public List<TestOfStudent> findByAll() {
    return new ArrayList<>(tests.values());
  }

  @Override
  public TestOfStudent findById(Long id){
    return tests.get(id);
  }

  @Override
  public boolean resultRunTest(Long idTest, float mark) {
    return this.findById(idTest).getSuccessfulPercentOfPassTest() <= mark;
  }
}
