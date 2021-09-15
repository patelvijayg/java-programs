package com.comp1;

public class EnumAbstract {

  public static void main(String[] args) {
    Prahar subah=Prahar.SAVERA;
    Prahar dopar=Prahar.DOPAR;
    Prahar sham=Prahar.SANDHYA;
    System.out.println(subah.greet());
    System.out.println(subah.defaultGreet());
  }
  public static String getGreet(Prahar prahar){
    return prahar.greet();
  }
}
enum Prahar{
  SAVERA{
    @Override
    public String greet() {
      return "good morning";
    }
  },
  DOPAR{
    @Override
    public String greet() {
      return "good noon";
    }
  },
  SANDHYA{
    @Override
    public String greet() {
      return "shubh ratri";
    }
  };
  public abstract String greet();
  public String defaultGreet(){return "Hellow";};
}
