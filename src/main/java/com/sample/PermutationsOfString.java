package com.sample;

public class PermutationsOfString {

  public static void main(String[] args) {
    String input = "1234";
    getPermutations(input);
  }

  public static void getPermutations(String s) {
    getPermutations("",s);
  }

  public static void getPermutations(String previous, String remains) {
    if (remains.isEmpty()) {
      System.out.println(previous);
      return;
    }
    for (int i=0; i<remains.length();i++){
      char c = remains.charAt(i);
      String current=previous+c;
      String rest = new StringBuilder(remains).deleteCharAt(i).toString();
      getPermutations(current,rest);
    }

  }
}