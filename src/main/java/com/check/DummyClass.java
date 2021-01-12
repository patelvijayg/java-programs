package com.check;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class DummyClass<T> {
    public static void main(String[] args) {
      //DummyClass.main(null);
      int[] ar={ 1,2,3,4,5,6,7};
      List<Integer> l1= new ArrayList<>();
      for(int i=1;i<=10;i++) l1.add(i);
      Collections.swap(l1,2,4);
      //l1.forEach(System.out::println);

      Set<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return 0;
        }
      });
      treeSet.add(3);
      treeSet.add(1);
      treeSet.add(2);
      System.out.println(treeSet);

    }
    static <T> T[] pickTwo(T a, T b, T c) {

      switch(ThreadLocalRandom.current().nextInt(3)) {
        case 0:
          T[] arr = toArray(a, b);
          System.out.println(arr.getClass());
          return arr;
        case 1:
          T[] arr1 = toArray(a, c);
          System.out.println(arr1.getClass());
          return arr1;
        case 2:
          T[] arr3 = toArray(b, c);
          System.out.println(arr3.getClass());
          return arr3;
      }
      return null;
    }

    static <T> T[] toArray(T... args) {
      System.out.println("args"+args.getClass());
      System.out.println("args"+args[0].getClass());
      return (T[])args;
    }
  }

class Dummy2{
  public static void main(String[] args) {
    String[] attributes = pickTwo("Good", "Fast", "Cheap");
  }
  static String[] pickTwo(String a, String b, String c) {

    switch(ThreadLocalRandom.current().nextInt(3)) {
      case 0:
        String[] arr = toArray(a, b);
        return arr;
      case 1:
        String[] arr1 = toArray(a, c);
        return arr1;
      case 2:
        String[] arr3 = toArray(b, c);
        return arr3;
    }
    return null;
  }

  static  String[] toArray(String... args) {
    System.out.println("args"+args.getClass());
    return args;
  }
}

  class Dummy3<T>{
    public <T> T[] pickTwo(T a, T b, T c) {

      switch(ThreadLocalRandom.current().nextInt(3)) {
        case 0:
          T[] arr = toArray(a, b);
          System.out.println(arr.getClass());
          return arr;
        case 1:
          T[] arr1 = toArray(a, c);
          System.out.println(arr1.getClass());
          return arr1;
        case 2:
          T[] arr3 = toArray(b, c);
          System.out.println(arr3.getClass());
          return arr3;
      }
      return null;
    }
    public  <T> T[] toArray(T... args) {
      System.out.println("args"+args.getClass());
      System.out.println("args"+args[0].getClass());
      return (T[])args;
    }
  }

  class Dummy4{

  static String subArray(int[] arr, int sum){
    StringBuilder sb =new StringBuilder();
    //StringBuilder nums = new StringBuilder();
    for( int i=0; i<arr.length;i++){
      int curr_sum=0;
      StringBuilder nums = new StringBuilder("{");
      for ( int j=i; j<arr.length;j++){
          nums.append(arr[j]+",");
          curr_sum=curr_sum+arr[j];
        if(curr_sum==sum){
          nums.deleteCharAt(nums.length()-1);
          nums.append("}");
          sb.append( nums.toString() + "\n");
         // break;
        }
      }
    }
    return sb.toString();

  }

  }
