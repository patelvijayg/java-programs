package com.sample;



import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSortedByValue {

  public static void main(String[] args) {
    Map<Integer, Integer> m1 = new HashMap<>();
    m1.put(1, 10);
    m1.put(2, 7);
    m1.put(3, 5);
    m1.put(4, 1);
//    m1.entrySet().removeIf(e->e.getKey()<2);
    m1.put(5,1);


    Map<Integer,Integer> m2 = m1.entrySet().stream().sorted(Entry.<Integer, Integer>comparingByValue()).collect(Collectors.toMap(Entry::getKey,Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));

    m2.forEach( (e1,e2)->System.out.println(e1.toString()+""+e2.toString()));
    System.out.println("----");
    List<Entry<Integer, Integer>> kv = new ArrayList(m1.entrySet());

    Collections.sort(kv, Entry.comparingByValue());
    Map<Integer, Integer> lh = new LinkedHashMap<>();
    for (Entry<Integer, Integer> e : kv) {
      lh.put(e.getKey(), e.getValue());
    }
    lh.forEach((k, v) -> System.out.println(k + " " + v));


    Map<Integer, Integer> lh2 = m1.entrySet().stream().sorted(Entry.<Integer, Integer>comparingByValue().reversed()).collect(
        Collectors.toMap(Entry::getKey,
            Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    lh2.forEach((k, v) -> System.out.println(k + " " + v));
  }
}
