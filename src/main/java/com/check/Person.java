package com.check;

public class Person {
  final Age firstAge;
  final Age secondAge;
  Person(Age firstAge){
    this.firstAge = firstAge;
    this.secondAge = new Age();
  }
  static class Age {
    int year = 10;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  static class Man extends Person {
    @Override
    public Object clone()  {
      return new Man(firstAge);
    }

    public Man(Age age) {
      super(age);
    }

    public static void main(String[] args) {

      Age age = new Age();
      Man man1 = new Man(age);
// Bar bar2 = new Bar();
      Man man2 = (Man) man1.clone();
      System.out.println(man1.firstAge.year);
      System.out.println(man2.firstAge.year);

      System.out.println(man1.secondAge.year);
      System.out.println(man2.secondAge.year);

      man1.secondAge.year = 30;
      age.year = 100;

      System.out.println(man2.firstAge.year);
      System.out.println(man1.firstAge.year);

      System.out.println(man2.secondAge.year);
      System.out.println(man1.secondAge.year);
    }
  }
}