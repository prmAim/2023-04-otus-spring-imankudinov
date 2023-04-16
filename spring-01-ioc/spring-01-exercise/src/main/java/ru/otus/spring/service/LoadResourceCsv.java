package ru.otus.spring.service;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LoadResourceCsv implements LoadResource{
  private final String fileName;

  public LoadResourceCsv(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String loadFile(){
    // getResourceAsStream = Java позволяет извлекать файловые ресурсы, хранящиеся внутри JAR, вместе с скомпилированными классами.
    try (InputStream resource = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
      if (resource == null){
        throw new IllegalArgumentException("Нет такого файла" + fileName);
      }
      return new String(resource.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }



}
