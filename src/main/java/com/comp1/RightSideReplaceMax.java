package com.comp1;

import java.util.Arrays;

public class RightSideReplaceMax {

  //{16, 17, 4, 3, 5, 2} to {17, 5, 5, 5, 2, -1}.
  public static void main(String[] args) {
    Integer i1=1025;
    String s1=i1.toString();
    System.out.println(Integer.valueOf(s1.replace("0","5")));
  }

  public static void replaceMax(){

    int[] input = {16, 17, 4, 3, 5, 2};
    for (int i = 0; i < input.length - 1; i++) {
      input[i] = getMax(i, input);
    }
    input[input.length - 1] = -1;
    System.out.println(Arrays.toString(input));

  }
  public static int getMax(int pos, int[] arr) {
    if (pos > arr.length - 1) {
      return -1;
    }
    int max = arr[pos + 1];
    for (int i = pos + 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

}
