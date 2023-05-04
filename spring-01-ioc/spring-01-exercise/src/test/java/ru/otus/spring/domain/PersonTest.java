package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class Person")
class PersonTest {

  @DisplayName("have to create class with constructor")
  @Test
  void shouldHaveCorrectConstructorTest() {
    Person actualPerson = new Person("Petty", 22);

    assertThat(actualPerson)
            .extracting("name", "age")
            .contains("Petty", 22)
            .doesNotContain("Alex", 10);

  }
}