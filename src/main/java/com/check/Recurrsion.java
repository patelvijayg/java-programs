package com.check;

public class Recurrsion {

  public static void main(String[] args) {
    String input = null;
    String output=reverse("",input);
    System.out.println(output);
    System.out.println(tailRecursion(input));
  }
  public static String reverse(String curr, String remaining){
    if(remaining == null || remaining.equals("")) return "";
    if(remaining.length()==1) return remaining+curr;
    curr =  remaining.substring(0,1)+curr ;
    remaining=remaining.substring(1);
    return reverse(curr,remaining);
  }
  public static String tailRecursion(String input){

    if (input == null || input.length()<=1 ) return input;
    return tailRecursion(input.substring(1))+input.substring(0,1);
  }
}
