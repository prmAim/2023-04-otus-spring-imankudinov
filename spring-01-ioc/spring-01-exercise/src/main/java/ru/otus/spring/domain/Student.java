package ru.otus.spring.domain;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private Long studentId;
  private String fio;
  private List<TestOfStudent> tests;
  private float mark;

  public Student(String fio) {
    this.fio = fio;
    tests = new ArrayList<>();
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getFio() {
    return fio;
  }

  public void setFio(String fio) {
    this.fio = fio;
  }

  public List<TestOfStudent> getTests() {
    return tests;
  }

  public void setTests(List<TestOfStudent> tests) {
    this.tests = tests;
  }

  public float getMark() {
    return mark;
  }

  public void setMark(float mark) {
    this.mark = mark;
  }
}
