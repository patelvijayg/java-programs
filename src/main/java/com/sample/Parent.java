package com.sample;

import java.util.Comparator;

public class Parent {
  int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Parent(int id) {
    this.id = id;
  }

  public void ping(int count){
    System.out.println("Inside Parent");
  }
}

class Child extends Parent {


  public Child(int id) {
    super(id);

  }

  public void ping(Integer count){
    System.out.println("Inside Child");
  }

  public static void main(String[] args) {
    Parent p1 = new Parent(1);
    Parent p2 = new Parent(1);
    int i = new EmployeeComparator().compare(p1,p2);
    System.out.println(i);
  }
}

class EmployeeComparator implements Comparator<Parent>{

  @Override
  public int compare(Parent o1, Parent o2) {
    return o1.getId()-o2.getId();
  }
}