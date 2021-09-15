package com.sample;

import java.io.FileNotFoundException;

public class Parent {
  public void ping(int count){
    System.out.println("Inside Parent");
  }

  protected Parent foo(Parent p) throws Exception{
    System.out.println("Inside Parent Foo");
    return null;
  }
}
 class Child extends Parent {
  public void ping(Integer count){
    System.out.println("Inside Child");
  }
  public Child foo(Parent c) throws FileNotFoundException {
    System.out.println("Inside Child Foo");
    return null;
  }

  public static void main(String[] args) {
    Child child = new Child();
    Parent parent = new Parent();
    child.ping(78);
    try {
      Object p1=parent.foo(child);
      Child p2=child.foo(child);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}