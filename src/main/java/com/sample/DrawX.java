package com.sample;

import java.io.PrintStream;

public class DrawX
{
  public static void main(String[] args)
  {
    int MAX_CHAR = 8;

    int preCount = 0;int postCount = 0;
    char preChar = '\\';char postChar = '/';
    int line = 1;
    for (int middleSpace = MAX_CHAR; line <= MAX_CHAR; middleSpace -= 2)
    {
      if (line <= 4)
      {
        preCount = line - 1;
        postCount = middleSpace - 2;
      }
      else
      {
        preCount = MAX_CHAR - line;
        postCount = Math.abs(middleSpace);
        preChar = '/';
        postChar = '\\';
      }
      String preSpace = getRepeated(" ", preCount);
      String postSpace = getRepeated(" ", postCount);
      System.out.print(preSpace + preChar + postSpace + postChar);
      System.out.print("\n");line++;
    }
  }

  public static String getRepeated(String c, int n)
  {
    if (n < 0) {
      n = 0;
    }
    return new String(new char[n]).replace("\000", c);
  }
}
