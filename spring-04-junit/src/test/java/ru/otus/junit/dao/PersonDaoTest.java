package ru.otus.junit.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.junit.domain.Person;

import static org.assertj.core.api.Assertions.*;

class PersonDaoTest {

  @Test
  void getByNameTest() {
    PersonDao personDao = createPersonDao();
    Person pettyEtalon = new Person(10, "Petty");

    Throwable throwable = catchThrowable(() -> {
      personDao.save(pettyEtalon);
      personDao.getByName("Kolay");
    });

    assertThat(throwable)
            .isInstanceOf(PersonNotFoundException.class)
            .hasMessageContaining("The name of person Kolay is not found");
  }

  @Test
  void getAllTest() {
    PersonDao personDao = createPersonDao();
    Person igor = new Person(10, "Igor");
    Person sasha = new Person(20, "Sasha");
    personDao.save(igor);
    personDao.save(sasha);

    assertThat(personDao.getAll())
            .isNotNull()
            .isNotEmpty()
            .contains(igor)
            .contains(sasha);
  }

  @Test
  void deleteByName() {
  }

  @DisplayName("Add Person class in List PersonDao")
  @Test
  void saveTest() {
    PersonDao personDao = createPersonDao();
    Person igor = new Person(10, "Igor");
    personDao.save(igor);

    assertThat(personDao.getAll())
            .isNotNull()
            .isNotEmpty()
            .doesNotContainNull()
            .contains(igor);
  }

  private PersonDao createPersonDao() {
    return new PersonDaoImpl();
  }
}