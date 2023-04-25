package ru.otus.spring.commands;

import org.springframework.stereotype.Component;
import ru.otus.spring.service.StudentsService;

import java.util.Scanner;

@Component
public class ShowCommand implements Command {

  @Override
  public String getName() {
    return "SHOW";
  }

  @Override
  public StudentsService execute(Scanner scn, StudentsService students) {
    if (students.findByAll().findByAll().isEmpty()){
      System.out.println("Please create a new Student");
      return students;
    }
    students.printStudentAll();
    return students;
  }
}
