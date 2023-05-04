package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class PersonServiceImpl.java")
class PersonServiceImplTest {

  @Mock
  private PersonDao personDao;

  @DisplayName("must find class Person by name")
  @Test
  void getByNameTest() {
    PersonServiceImpl actualPersonService = new PersonServiceImpl(personDao);

    given(personDao.findByName("Petty")).willReturn(new Person("Petty", 22));

    assertThat(actualPersonService.getByName("Petty"))
            .extracting("name", "age")
            .contains("Petty", 22)
            .doesNotContain("Olya", 18)
            .hasSize(2);
  }
}