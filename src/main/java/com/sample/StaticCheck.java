package com.sample;

public class StaticCheck {

  public static void main(String[] args) {
    _Innter s = new _Innter();

    s.m1();
  }

  public static void m1(){
    System.out.println("st");
  }

  private final void m3(){
    System.out.println("st");
  }

}

class _Innter extends StaticCheck {
  public static int i =10;
  public static void m1(){
    System.out.println("_i");
  }
}