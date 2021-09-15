package com.check;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class CheckOverride {

  public static void main(String[] args) {
    String abc=riskyAction("test");
    System.out.println("abc="+abc);

    Base b = new SubClass();

    try {
      Integer i = 20;
      b.getint(i);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static String riskyAction(String greeting){
    try{
      if(greeting.equals("hello")){
        System.out.println(greeting + " from try block");
      }else{
        throw new Exception();
      }
      return m2();
    }catch(Exception e){
      System.out.println(greeting + " from catch block");
      return m3();
    }finally{
      return "returning from finally block";
    }
  }
  public static String m2(){
    System.out.println("called m2");
    return "m2";
  }
  public static String m3(){
    System.out.println("called m3");
    return "m3";
  }
}

class Base{
  protected Object myOverRide() throws Exception{
    System.out.println("Base");
    return new Integer(0);
  }
  public void getint(int ii){
    Integer i = 20;
    System.out.println("Base");
  }
}

class SubClass extends Base {

  @Override
  protected Object myOverRide()  {
    System.out.println("SubClass");
    return new Integer(1);
  }
  public void getint(Integer ii){
    int i =10;
    System.out.println("SubClass");
  }


}
