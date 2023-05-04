package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class PersonDaoSimple")
class PersonDaoSimpleTest {

  @DisplayName("must get class PersonDao")
  @Test
  void findByNameTest() {
    PersonDao personDao = new PersonDaoSimple();

    assertThat(personDao.findByName("Lena"))
            .isNotNull()
            .hasFieldOrPropertyWithValue("name", "Lena");
  }
}