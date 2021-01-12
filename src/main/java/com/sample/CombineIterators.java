package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CombineIterators<E> {

  private Comparator comparator;
  public CombineIterators(Comparator<E> comparator) {
    this.comparator=comparator;
  }

  public CombineIterators() {
  }

  private int compareElement(E e1, E e2){
    if(this.comparator != null){
      return this.comparator.compare(e1,e1);
    }
    else {
      Comparable c1=(Comparable) e1;
      return c1.compareTo(e2);
    }

  }
  public Iterator<E> combine(Iterator<E> it1, Iterator<E> it2) {
    List<E> result = new ArrayList<E>();
    E b1 = it1.hasNext() ? it1.next() : null;
    E b2 = it2.hasNext() ? it2.next() : null;

    while (b1 != null && b2 != null) {
      if (compareElement(b1,b2) > 0) {
        result.add(b2);
        b2 = it2.hasNext() ? it2.next() : null;
      } else {
        result.add(b1);
        b1 = it1.hasNext() ? it1.next() : null;
      }
    }
    while (b1 != null) {
      result.add(b1);
      b1 = it1.hasNext() ? it1.next() : null;
    }
    while (b2 != null) {
      result.add(b2);
      b2 = it2.hasNext() ? it2.next() : null;
    }

    return result.iterator();
  }

  public static void main(String[] args) {
    List<Integer> lst1 = Arrays.asList(1, 3, 5, 7);
    List<Integer> lst2 = Arrays.asList(2, 4, 6, 8);

    Comparator<Integer> cc1 = (o1, o2) -> o1-o2;
    CombineIterators<Integer> c1 = new CombineIterators<>(cc1);
    Iterator lst3 = c1.combine(lst1.iterator(), lst2.iterator());
    while (lst3.hasNext()) {
      System.out.println(lst3.next());
    }
  }
}
