package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Class LoadResourceCsv.java")
class LoadResourceCsvTest {

  @DisplayName("must return string of file <questionsTest.csv>")
  @Test
  void loadFileTest() {
    LoadResourceCsv actualResource = new LoadResourceCsv("questionsTest.csv");

    assertThat(actualResource.loadFile())
            .isEqualTo("1+1=?;0,1,2,4;false,false,true,false;\r\n")
            .isNotEmpty();
  }
}