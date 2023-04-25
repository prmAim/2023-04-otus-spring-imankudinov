package ru.otus.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.commands.CommandHandler;
import ru.otus.spring.domain.Person;
import ru.otus.spring.service.PersonService;

@ComponentScan("ru.otus.spring")
@PropertySource("classpath:application.properties")
public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
    Person ivan = context.getBean("personService", PersonService.class).getByName("Ivan");

    // Получите Person "Ivan"
    System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());

    //  QuestionsService questionsService = context.getBean("questionsService", QuestionsService.class);
    //  questionsService.printQuestionsAll();

    CommandHandler commandHandler = context.getBean(CommandHandler.class);
    // выполнение команд (реализованых ниже) через Spring (packet <commands>)
    commandHandler.handleCommands();
  }
}
