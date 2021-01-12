package com.sample;

public class TestClass1<T extends TestClass1> {

  public static void main(String[] args) {
    m1(null);
  }
  public static void m1(Object o){
    System.out.println("o");
  }
  public static void m2(Object[] o){
    System.out.println("o[]");
  }
  public static void m2(String[] o){
    System.out.println("s");
  }
  public static void m2(Integer[] o){
    System.out.println("I");
  }
  public void print(){
    System.out.println("inside TestClass1");
  }
  public T getInstance(){
    return (T) this;
  }
}

class Subject extends TestClass1 {
  public void print(){
    System.out.println("inside Bar");
  }
}