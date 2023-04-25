package ru.otus.spring.commands;

import org.springframework.stereotype.Component;
import ru.otus.spring.service.StudentsService;

import java.util.Scanner;

/**
 * Команда на добавление продукта в корзину
 */
@Component
public class AddStudentCommand implements Command {

  @Override
  public String getName() {
    return "ADD STUDENT";
  }

  @Override
  public StudentsService execute(Scanner scn, StudentsService students) {
    StringBuilder stringBuilder = new StringBuilder();
    System.out.print("Surname student: ");
    stringBuilder.append(scn.nextLine());
    stringBuilder.append(" ");
    System.out.print("Name student: ");
    stringBuilder.append(scn.nextLine());
    students.addStudent(stringBuilder.toString());
    return students;
  }
}
