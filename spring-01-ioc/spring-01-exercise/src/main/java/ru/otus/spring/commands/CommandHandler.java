package ru.otus.spring.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.service.StudentsService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class CommandHandler {

  // Список всех команд
  private final Map<String, Command> commands;
  private StudentsService students;

  @Autowired
  public CommandHandler(List<Command> commands, StudentsService students) {
    // Преобразование команд в Map (<Название команд>, <Сама команда>). <Сама команда> пример: ADD, NEW ...
    this.commands = commands.stream()
            .collect(Collectors.toMap(Command::getName, cmd -> cmd));
    this.students = students;
  }

  public void handleCommands() {
    Scanner scn = new Scanner(System.in);
    while (true) {
      StringBuilder str = new StringBuilder("Enter command (<EXIT>");
      commands.forEach((key, value) -> str.append(", <" + value.getName() + ">"));
      System.out.println(str.toString() + "):");
      String cmd = scn.nextLine().trim().toUpperCase();
      if (cmd.equals("EXIT")) {
        System.out.println("Bye");
        return;
      }
      Command command = commands.get(cmd);
      if (command == null) {
        System.out.println("Command unknown");
        continue;
      }
      this.students = command.execute(scn, students);
    }
  }
}
