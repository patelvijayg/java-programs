package com.sample;

public class DrawNumberTriangle {

  public static void main(String[] args) {
    for(int i=1,j=5,k=-1; i<7; i++,j--,k=k+2){
      System.out.print( getRepeated( " ",j));
      System.out.print(i);
      System.out.print( getRepeated( " ",k));
      if(i>1) System.out.print(i);
      System.out.println("");
    }
    System.out.print( getRepeated( "7",11));
  }
  public static String getChar2(char c,int n){
    StringBuilder sb =new StringBuilder();
    for(int i=0;i<=n; i++){
      sb.append(c);
    }
    return sb.toString();
  }

  public static String getRepeated(String c,int n){
    if (n<0) n=0;
    return new String(new char[n]).replace("\0", c);
  }
}
