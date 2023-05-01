package ru.otus.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.domain.Person;
import ru.otus.spring.service.PersonService;
import ru.otus.spring.service.QuestionsService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Person ivan = context.getBean("personService", PersonService.class).getByName("Ivan");

        // Получите Person "Ivan"
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());

        QuestionsService questionsService = context.getBean("questionsService", QuestionsService.class);
        questionsService.printQuestionsAll();
    }
}
