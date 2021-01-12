package com.sample;

import java.io.PrintStream;
import java.util.Collection;

public class PrimeNumber
{
  public static void main(String[] args)
  {
    int range = 1;
    for (int i = 1; i <= range; i++) {
      if (isPrime(i)) {
        System.out.println(i);
      }
    }
  }

  public static boolean isPrime(int n)
  {
    if (n > 3)
    {
      if ((n % 2 == 0) || (n % 3 == 0)) {
        return false;
      }
      for (int i = 3; i <= n / 2; i += 2) {
        if (n % i == 0) {
          return false;
        }
      }
    }
    return true;
  }


}
