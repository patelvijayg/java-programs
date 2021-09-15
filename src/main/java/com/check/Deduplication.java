package com.check;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Deduplication {

  public static void main(String[] args) {
    TreeSet<Student> t= new TreeSet<>();
    t.add(new Student("a",1,10));
    t.add(new Student("b",1,20));
    t.add(new Student("c",1,5));
    List<Student> studentList= Arrays.asList(
        new Student("a",1,10)
        ,new Student("b",1,10)
        ,new Student("c",1,10)
        ,new Student("a",1,5)
        ,new Student("a",1,15)
        ,new Student("a",1,10)
        ,new Student("b",1,11)
        ,new Student("b",1,10)
    );
    studentList.stream().distinct().forEach(s-> System.out.println(s.toString()));

  }
}

class Student implements Comparable {
private String name;
private Integer rollNo;
private Integer percentage;

  public Student(String name, Integer rollNo, Integer percentage) {
    this.name = name;
    this.rollNo = rollNo;
    this.percentage = percentage;
  }

  @Override
  public boolean equals(Object o) {
    Student student = (Student) o;
    if(name.equals(student.name) && rollNo.equals(student.rollNo)) {
      if(percentage>student.percentage)
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (rollNo != null ? rollNo.hashCode() : 0);
    System.out.println("hascode called");
    return result;
  }

  @Override
  public String toString() {
    return "{" +
        "name='" + name + '\'' +
        ", rollNo=" + rollNo +
        ", percentage=" + percentage +
        '}';
  }

  @Override
  public int compareTo(Object o) {
        return this.percentage.compareTo(((Student) o).percentage);
  }
}