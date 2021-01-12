package com.sample;

public interface InterfaceWithStatic {
  class DefaultClass{
    public void publicMethod1(){
      System.out.println("public");
    }
    protected void protectedMethod1(){
      System.out.println("protected");
    }
  }
  public static class StaticClass{
    public void publicMethod1(){
      System.out.println("in statci public");
    }
    protected void protectedMethod1(){
      System.out.println("in static protected");
    }

  }

  static void staticMethod(){
    System.out.println("static method");
  }
}
