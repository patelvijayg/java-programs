package com.sample;

import java.util.Arrays;

public class CustomHashMap<K,V> {
  static class Entry<K,V>{
    K key;
    V value;
    Entry<K,V> next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
      this.next=null;
    }
  }
  private static final  int INIT_CAPACITY=10;
  private int capacity;
  private int size=0;
  private Entry<K,V>[] elementData;

  public CustomHashMap() {
  this(INIT_CAPACITY);
  }

  public CustomHashMap(int capacity) {
    elementData=new Entry[capacity];
    this.capacity=capacity;
  }
  public void remove(K key) {
    int hashKey=hashCode(key);
    Entry<K,V> current = elementData[hashKey];
    Entry<K,V> previous = null;

    while (current!=null) {
      if(current.key.equals(key)){
        if(previous==null){
          elementData[hashKey]=current.next;
          size--;
          return;
        }
       previous.next=current.next;
      }
      previous=current;
      current=current.next;
    }
  }

  public boolean put(K key, V value){
      Entry<K,V> data = new Entry<>(key,value);
      int hashKey=hashCode(key);
      ensureCapacity();
      if(elementData[hashKey]==null){

        elementData[hashKey]=data;
        size++;
        return true;
      }else {
        Entry<K,V> current = elementData[hashKey];
        Entry<K,V> previous = null;
        while (current!=null){
          if(current.key.equals(data.key)){
            current.value=value;
            return false;
          }
          previous=current;
          current=current.next;
        }
        if (previous!=null) previous.next=data;
        size++;
        return true;

      }
  }
  public V get(K key){
    if(key!=null){
      int hashKey=hashCode(key);
      if(elementData[hashKey]!=null){
        Entry<K,V> current = elementData[hashKey];
        while(current!=null){
          if(current.key.equals(key)){
            return current.value;
          }
          current=current.next;
        }
      }
    }
    return null;
  }
  public void ensureCapacity(){
    if(size > capacity){
      Entry<K,V>[] temp;
      temp=Arrays.copyOf(elementData,capacity);
      capacity=capacity*2;
      size=0;
      elementData=new Entry[capacity];
      for(Entry<K,V> e: temp){
        while(e!=null){
          put(e.key,e.value);
          e=e.next;
        }
      }
    }
  }
  public void display(){
    System.out.print("[");
    for(Entry e: elementData){
      while(e!=null){
        System.out.print(e.key+":"+e.value+" , ");
        e=e.next;
      }
    }
    System.out.println("]");
  }
  public int size(){
    return this.size;
  }
  public int hashCode(K key){
    return key.hashCode()% this.capacity;
  }

  public static void main(String[] args) {
    CustomHashMap<Integer,Integer> hs =new CustomHashMap<>(10);
    hs.put(1,5);
    hs.put(11,60);
    hs.put(21,40);
    hs.put(31,60);
    hs.display();
    hs.put(2,60);
    hs.put(3,60);
    hs.put(5,60);
    hs.display();
    hs.remove(11);
    hs.display();
    System.out.println(hs.get(11));
    System.out.println(hs.size());
  }
}
