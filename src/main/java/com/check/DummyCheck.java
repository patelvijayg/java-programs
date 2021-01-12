package com.check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class DummyCheck {

  public static void main(String[] args) {
    Integer ar[] = new Integer[]{4, 4, 4, 8, 8, 8, 8, 6, 6, 9, 2, 2};
    int ari[] = new int[0];

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Arrays.stream(ar).forEach(value -> map.compute(value, (k, v) -> v == null ? 1 : ++v));
    Arrays.sort(ar, (o1, o2) -> map.get(o1).compareTo(map.get(o2)));
    //Arrays.sort(ar, Comparator.comparing(map::get));
    System.out.println(Arrays.toString(ar));
    //list.forEach(System.out::print);
    System.exit(1);
    Function<Integer, Integer> fun = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer integer) {
        Integer r = map.get(integer);
        return r;
      }
    };

    Function<Integer, Integer> keyExtractor = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer integer) {
        return integer;
      }
    };

    Comparator com = Comparator.comparing(fun);
    Comparator c = Comparator.comparing(keyExtractor, com);

    //list.sort(c -> map.get(c));
    Comparator cc = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.get(o1).compareTo(map.get(o2));
      }
    };
    Arrays.sort(ar, (o1, o2) -> map.get(o1).compareTo(map.get(o2)));

    //list.forEach(System.out::print);
  }


}
