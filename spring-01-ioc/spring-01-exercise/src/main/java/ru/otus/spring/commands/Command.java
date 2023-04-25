package ru.otus.spring.commands;

import ru.otus.spring.service.StudentsService;

import java.util.Scanner;

public interface Command {

  /**
   * Имя команды
   */
  String getName();

  /**
   * Выполнение команды
   */
  StudentsService execute(Scanner scn, StudentsService students);
}
