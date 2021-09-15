package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SampleStream {

  public static void main(String[] args) {

  }
  public static void negatePredicate(){
    int[] numbers = {1,2,3,5,7,8,9};
    List<Integer> ll= IntStream.of(numbers).boxed().collect(Collectors.toList());
    List<Integer> l4= Arrays.stream(numbers).boxed().collect(Collectors.toList());
    //ArrayList<Integer> l1= (ArrayList) IntStream.range(1,10).boxed().filter(i-> !ll.contains(i)).collect(Collectors.toList());
    ArrayList<Integer> l1= (ArrayList) IntStream.range(1,10).boxed().filter(((Predicate<Integer>)(ll::contains)).negate()).collect(Collectors.toList());
    System.out.println(l1);

    List<Integer> l2= Arrays.asList(1,2,3,4,5,6,7);
    int[] l3 = l2.stream().mapToInt(i->i).toArray();

  }

  public static void joinStream(){
    Map<Integer,String> emp = new HashMap<>();
    emp.put(1,"One");
    emp.put(11,"One");
    emp.put(2,"Two");
    emp.put(4,"Four");

    Map<String,String> dept = new HashMap<>();
    dept.put("One","DeptOne");
    dept.put("Two","DeptTwo");
    dept.put("Three","DeptThree");
    dept.put("Four","DeptFour");


  }
}
