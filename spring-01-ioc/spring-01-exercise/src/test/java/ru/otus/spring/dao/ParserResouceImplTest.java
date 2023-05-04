package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.service.LoadResource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class ParserResouceImpl.java")
class ParserResouceImplTest {

  @Mock
  LoadResource loadResource;

  @DisplayName("must get list question")
  @Test
  void parserResourceToQuestionTest() {
    ParserResouce parserResouce = new ParserResouceImpl(loadResource);

    given(loadResource.loadFile()).willReturn("1*0=?;0,1;true,false;\n\n");

    assertThat(parserResouce.parserResourceToQuestion())
            .filteredOn(question -> question.getQuestionText().equals("1*0=?"))
            .hasSize(1);
  }
}