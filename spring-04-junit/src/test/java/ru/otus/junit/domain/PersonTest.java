package ru.otus.junit.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс Person")
class PersonTest {

    @DisplayName("корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Person person = createPerson();

        assertThat(person)
                .hasFieldOrPropertyWithValue("age", 42)
                .matches(p -> p.getName().equals("Ivan"));
    }

    @DisplayName("должен")
    @Test
    void setAge(){
        Person person = createPerson(55);

        person.setAge(10);
        person.setName("Tolya");

        assertEquals(10, person.getAge());
        assertEquals("Tolya", person.getName());
    }

    @DisplayName("должен увеличивать возраст при вызове birthDay")
    @Test
    void birthDayTest() {
        Person person = createPerson();
        person.birthDay();

        assertThat(person.getAge()).isEqualTo(43);
    }

    private Person createPerson(){
        return new Person(42, "Ivan");
    }

    private Person createPerson(int age){
        return new Person(age, "Ivan");
    }
}
