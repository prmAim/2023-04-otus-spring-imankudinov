package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Student;
import ru.otus.spring.domain.TestOfStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository("studentsDao")
public class StudentsDaoImpl implements StudentsDao {

  private final Map<Long, Student> students;

  private final AtomicLong identity = new AtomicLong(0);

  public StudentsDaoImpl() {
    students = new ConcurrentHashMap<>();
  }

  @Override
  public void addStudent(String fio) {
    if (!this.findByFIO(fio)){
      Student student = new Student(fio);
      student.setStudentId(identity.incrementAndGet());
      students.put(student.getStudentId(), student);
    }
  }

  @Override
  public List<Student> findByAll() {
    return new ArrayList<>(students.values());
  }

  @Override
  public Student findById(long id) throws IndexOutOfBoundsException{
    return students.get(id);
  }

  @Override
  public boolean findByFIO(String fio) {
    for (Student student : students.values()) {
      if (student.getFio().equals(fio)){
        return true;
      }
    }
    return false;
  }

  @Override
  public void setTestToStudent(TestOfStudent test, float mark, long studentId) {
    if (this.findById(studentId) == null){
      throw new IndexOutOfBoundsException("The number " + studentId + " student is not correct!");
    }
    Student student = this.findById(studentId);
    student.getTests().add(test);
    student.setMark(mark);
  }
}
