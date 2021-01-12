package com.sample;

import java.io.PrintStream;
import java.util.Arrays;

public class MergeSort
{
  public static void main(String[] args)
  {
    int[] arr = { 10, 12, 11, 13, 5, 6, 7 };
    System.out.println(Arrays.toString(arr));
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] a, int lower, int higher)
  {
    if (lower == higher) {
      return;
    }
    int mid = (higher + lower) / 2;
    sort(a, lower, mid);
    sort(a, mid + 1, higher);
    merge(a, lower, mid, higher);
  }

  public static void merge(int[] arr, int beg, int mid, int end)
  {
    int llen = mid - beg + 1;
    int rlen = end - mid;
    int[] larr = new int[llen];
    int[] rarr = new int[rlen];
    for (int i = 0; i < llen; i++) {
      larr[i] = arr[(beg + i)];
    }
    for (int i = 0; i < rlen; i++) {
      rarr[i] = arr[(mid + 1 + i)];
    }
    int lindex = 0;int rindex = 0;int k = beg;
    while ((lindex < llen) && (rindex < rlen))
    {
      if (larr[lindex] <= rarr[rindex])
      {
        arr[k] = larr[lindex];
        lindex++;
      }
      else
      {
        arr[k] = rarr[rindex];
        rindex++;
      }
      k++;
    }
    while (lindex < llen)
    {
      arr[k] = larr[lindex];
      lindex++;
      k++;
    }
    while (rindex < rlen)
    {
      arr[k] = rarr[rindex];
      rindex++;
      k++;
    }
  }

  static void merge2(int[] arr, int beg, int mid, int end)
  {
    int l = mid - beg + 1;
    int r = end - mid;
    int[] LeftArray = new int[l];
    int[] RightArray = new int[r];
    for (int i = 0; i < l; i++) {
      LeftArray[i] = arr[(beg + i)];
    }
    for (int j = 0; j < r; j++) {
      RightArray[j] = arr[(mid + 1 + j)];
    }
    int i = 0;int j = 0;
    int k = beg;
    while ((i < l) && (j < r))
    {
      if (LeftArray[i] <= RightArray[j])
      {
        arr[k] = LeftArray[i];
        i++;
      }
      else
      {
        arr[k] = RightArray[j];
        j++;
      }
      k++;
    }
    while (i < l)
    {
      arr[k] = LeftArray[i];
      i++;
      k++;
    }
    while (j < r)
    {
      arr[k] = RightArray[j];
      j++;
      k++;
    }
  }
}
