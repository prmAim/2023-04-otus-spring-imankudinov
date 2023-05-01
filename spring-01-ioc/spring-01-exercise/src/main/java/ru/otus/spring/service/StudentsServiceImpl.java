package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.StudentsDao;
import ru.otus.spring.dao.TestsOfStudentsDao;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.Student;
import java.util.Scanner;

@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {

  private final StudentsDao students;
  private final TestsOfStudentsDao tests;

  @Autowired
  public StudentsServiceImpl(StudentsDao students, TestsOfStudentsDao tests) {
    this.students = students;
    this.tests = tests;
  }

  @Override
  public void printStudentAll() {
    StringBuilder stringBuilder = new StringBuilder();
    students.findByAll().forEach((student) -> {
      stringBuilder.append("Student " + student.getStudentId() + ") " + student.getFio() + "\n");
      student.getTests().forEach(test -> {
        stringBuilder.append("Test " + test.getNumberTest() + ") " + student.getMark() + "\n");
      });
    });
    System.out.println(stringBuilder);
  }

  @Override
  public Student testingStudent(long idStudent, long idTest) throws IndexOutOfBoundsException {
    int scopeMark = 0;
    Scanner scn = new Scanner(System.in);
    for (Question question : tests.findById(idTest).getQuestionList()) {
      System.out.print(question.toString() + "You answer:");
      int idAnswersOfStudent = scn.nextInt() - 1;
      if (idAnswersOfStudent < question.getAnswers().findByAll().size() && idAnswersOfStudent >= 0 &&
              question.getAnswers().findByAll().get(idAnswersOfStudent).isCorrectAnswer()){
        scopeMark++;
      }
    }
    students.setTestToStudent(tests.findById(idTest),
            (float) (scopeMark * 100.0 / tests.findById(idTest).getQuestionList().size()),
            idStudent);
    return students.findById(idStudent);
  }

  @Override
  public void addStudent(String fio) {
    students.addStudent(fio);
  }

  @Override
  public StudentsDao findByAll() {
    return students;
  }
}
