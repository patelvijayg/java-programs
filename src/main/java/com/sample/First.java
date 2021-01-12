package com.sample;

import com.sun.deploy.util.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class First implements InterfaceWithStatic {

  public static void main(String[] args) {

    System.out.println(3*0.1 == 0.3);
    List<Integer> ii = new ArrayList<>();
    ii.add(1);
    System.out.println(ii.hashCode());
    ii.add(2);
    System.out.println(ii.hashCode());
    ii.remove(1);

    System.out.println(ii.hashCode());
    ii.add(2);
    System.out.println(ii.hashCode());
    System.out.println(Integer.valueOf(500) == Integer.valueOf(500));
    Integer x = 1000;
    Integer y = 1000;
    System.out.println(x==y);

    Set<Integer> i= IntStream.range(1,10).boxed().collect(Collectors.toSet());


    List<Integer> s =new ArrayList<>();
      s.add(0);
      s.add(1);
      s.add(2);
      s.add(3);
      s.add(5);
      s.add(6);
      s.add(4,4);
  }



}
