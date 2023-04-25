package ru.otus.spring.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.dao.TestsOfStudentsDao;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.StudentsService;

import java.util.Scanner;

@Component
public class TestingCommand implements Command {

  private final TestsOfStudentsDao tests;

  @Autowired
  public TestingCommand(TestsOfStudentsDao tests) {
    this.tests = tests;
  }

  @Override
  public String getName() {
    return "TESTING";
  }

  @Override
  public StudentsService execute(Scanner scn, StudentsService students) {
    if (students.findByAll().findByAll().isEmpty()) {
      System.out.println("Please create a new Student");
      return students;
    }

    System.out.println("Check number student:");
    students.printStudentAll();
    long idStudent = scn.nextLong();
    if (idStudent < 1 || students.findByAll().findById(idStudent) == null) {
      System.out.println("The number student is not correct!");
      return students;
    }

    System.out.println("Check number test:");
    tests.findByAll().forEach((value) -> System.out.println(value.getNumberTest() + ")"));
    long idTest = scn.nextLong();
    if (tests.findById(idTest) == null || idTest < 1) {
      System.out.println("The number test is not correct!");
      return students;
    }

    Student student = students.testingStudent(idStudent, idTest);
    System.out.println("The mark of test is " + student.getMark() + "% " +
                       "The result testing is " + tests.resultRunTest(idTest, student.getMark()));
    return students;
  }
}
