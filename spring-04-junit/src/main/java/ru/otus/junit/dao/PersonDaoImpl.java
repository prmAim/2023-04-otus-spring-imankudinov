package ru.otus.junit.dao;

import ru.otus.junit.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

  private List<Person> persons;

  public PersonDaoImpl() {
    this.persons = new ArrayList<>();
  }

  @Override
  public Person getByName(String name) throws PersonNotFoundException {
    for (Person person : persons) {
      if (person.getName().equals(name)) {
        return person;
      }
    }
    throw new PersonNotFoundException("The name of person " + name + " is not found!");
  }

  @Override
  public List<Person> getAll() {
    return persons;
  }

  @Override
  public void deleteByName(String name) throws PersonNotFoundException {
    // TODO: реализовать удаление по имени (по технике Test-First)
    // TODO: да, этот метод может бросать Exception, и это нужно покрыть другим тестом
  }

  @Override
  public void save(Person person) {
    persons.removeIf(person1 -> person1.getName().equals(person.getName()));
    persons.add(person);
  }
}
