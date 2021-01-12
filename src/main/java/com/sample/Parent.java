package com.sample;

import java.io.FileNotFoundException;

public class Parent {
  public void ping(int count){
    System.out.println("Inside Parent");
  }

  protected Parent foo() throws Exception{
    System.out.println("Inside Parent Foo");
    return null;
  }
}
 class Child extends Parent {
  public void ping(Integer count){
    System.out.println("Inside Child");
  }
  public Child foo() throws FileNotFoundException {
    System.out.println("Inside Child Foo");
    return null;
  }

  public static void main(String[] args) {
    Child child = new Child();
    Parent parent = new Child();
    child.ping(78);
    try {
      parent.foo();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}