package com.sample;

public  enum  EnumCheck {
  One{

    int i;
    @Override
    public String toString() {
      return "one" + i;
    }
    @Override
    public  String chk(){
      System.out.println("chk One");
      this.i=10;
      return "";
    }

  },TWO;
  public  String chk(){
    System.out.println("chk main");
    return "";
  }

  public static void main(String[] args) {

    System.out.println(One.chk()    );
    System.out.println(One.toString()    );
  }
}
