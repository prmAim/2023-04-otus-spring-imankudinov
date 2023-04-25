package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service("loadResource")
public class LoadResourceCsv implements LoadResource {
  private final String fileName;

  @Autowired
    public LoadResourceCsv(@Value(value = "${csv.context-path}") String fileName) {
        this.fileName = fileName;
    }

  @Override
  public String loadFile() {
    // getResourceAsStream = Java позволяет извлекать файловые ресурсы, хранящиеся внутри JAR, вместе с скомпилированными классами.
    try (InputStream resource = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
      if (resource == null) {
        throw new IllegalArgumentException("The file is not found: " + fileName);
      }
      return new String(resource.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
