package com.check;

interface NewInterface {

  interface dd{

  }
  // static method
  static void hello()
  {
    System.out.println("Hello, New Static Method Here");

  }

  class testing{

  }

  // Public and abstract method of Interface
  public  void  overrideMethod(String str);
}

// Implementation Class
public class InterfaceDemo implements NewInterface {

  public static void main(String[] args)
  {
    InterfaceDemo interfaceDemo = new InterfaceDemo();

    // Calling the static method of interface
    NewInterface.hello();
    NewInterface.testing c =null;
    // Calling the abstract method of interface
    interfaceDemo.overrideMethod("Hello, Override Method here");
  }

  // Implementing interface method
  public synchronized void  test(){

  }
  @Override
  public synchronized void overrideMethod(String str)
  {
    System.out.println(str);
  }
}
