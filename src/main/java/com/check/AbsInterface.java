package com.check;

public class AbsInterface {

  public static void main(String[] args) {


  }
  interface i1{
    void m1();
    default public void m2(){
      System.out.println("i1");
    }
  }
  static abstract class a1{
    abstract public void m2();
     public void m1(){
       System.out.println("a1");
     }
  }

}
