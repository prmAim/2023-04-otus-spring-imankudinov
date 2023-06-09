package ru.otus.junit.service;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.junit.dao.PersonDao;
import ru.otus.junit.domain.Person;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonDao personDao;
    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void getByName() {
        // TODO: используйте eq() mapper вместо any()
        given(personDao.getByName(any()))
                .willReturn(new Person(10, "Ivan"));

        assertThat(personService.getByName("Ivan"))
                .isNotNull(); // TODO: сравните с помощью equals
    }

    @Test
    void getAllTest(){
        Person ivan = new Person(10, "Ivan");
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(ivan);
        given(personDao.getAll())
                .willReturn(listPerson);

        assertThat(personService.getAll())
                .doesNotContainNull()
                .isNotEmpty()
                .containsAll(listPerson);

    }
}
