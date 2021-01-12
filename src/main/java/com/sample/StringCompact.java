package com.sample;

import java.io.PrintStream;

public class StringCompact
{
  public static void main(String[] s)
  {
    String input = "ABBBA00BBBBBB";
    System.out.println(getCompactString(input));
  }

  public static String getCompactString(String input)
  {
    char previous = '\000';
    int count = 0;
    StringBuffer sb = new StringBuffer();
    for (char c : input.toCharArray())
    {
      if ((c == previous) || (previous == 0))
      {
        count++;
      }
      else
      {
        sb.append(count);
        sb.append(previous);
        count = 1;
      }
      previous = c;
    }
    sb.append(count);
    sb.append(previous);
    return sb.toString().replace("1", "");
  }
}
