package com.check;

import java.io.FileNotFoundException;

public class CheckOverride {

  public static void main(String[] args) {
    Base b = new SubClass();

    try {
      Integer i = 20;
      b.getint(i);
    } catch (Exception e) {
      e.printStackTrace();
    }
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
  protected Object myOverRide() throws FileNotFoundException {
    System.out.println("SubClass");
    return new Integer(1);
  }
  public void getint(Integer ii){
    int i =10;
    System.out.println("SubClass");
  }
}
