package com.sample;

public class ExceptionWithFinal {

  public static void main(String[] args) {
    System.out.println("final message=" + riskyAction("hello1"));
  }

  public static String riskyAction(String greeting) {
    try {
      if (greeting.equals("hello")) {
        System.out.println(greeting + " from try block");
      } else {
        throw new Exception();
      }
      return getMessage();
    } catch (Exception e) {
      System.out.println(greeting + " from catch block");
      return "returning from catch block";
    } finally {
      System.out.println("print finally");
      return "returning from finally block";
      //This return statement overwrite the other return statement
    }
  }

  private static String getMessage() {
    System.out.println("getMessage called");
    return "return from getMessage";
  }
}
