package com.sample;

public class PalindromeString {

  public static void main(String[] args) {
    String input = "12aqbciolloicbqa121";
    String result="";
    for(int i=0;i<input.length();i++){

      String large=findPalindromWithParameter(input,i,i);
      if(large.length()>result.length())
      {result=large;}
      //for even length
      large=findPalindromWithParameter(input,i,i+1);
      if(large.length()>result.length())
      {result=large;}
    }
    System.out.println(result);
  }

  static String findPalindromWithParameter(String str, int left, int right){

    if(left>right) return null;
    while(left>=0 && right <str.length() && str.charAt(left)==str.charAt(right) ){
      left--; right++;
    }
    return str.substring(left+1,right);
  }
}
