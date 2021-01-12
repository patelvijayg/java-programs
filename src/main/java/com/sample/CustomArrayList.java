package com.sample;

import java.util.Arrays;

public class CustomArrayList<E> {
  private static final int DEFAULT_CAPACITY=10;
  private int size;
  private Object [] elementData={};

  public CustomArrayList(int capacity) {
    this.elementData= new Object[capacity];
  }
  public CustomArrayList(){
    this(DEFAULT_CAPACITY);
  }
  public E get(int index){
    if(index>=this.elementData.length) throw new ArrayIndexOutOfBoundsException();
    return (E) elementData[index];
  }
  public void add(E data){
    if(size==elementData.length){
      ensureCapacity();
    }
    this.elementData[size++]=data;
  }
  public void add(int index,E data){
    if(index>=this.elementData.length) throw new ArrayIndexOutOfBoundsException();
    if(size==elementData.length){
      ensureCapacity();
    }
    System.arraycopy(elementData,index,elementData,index+1,size-index);
    elementData[index]=data;
    size++;
  }
  private void ensureCapacity(){
      elementData = Arrays.copyOf(elementData,this.elementData.length*2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<size;i++){
        sb.append(elementData[i]+",");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    CustomArrayList<Integer> ar = new CustomArrayList<Integer>(10);
    ar.add(0);
    ar.add(1);
    ar.add(3);
    ar.add(4);
    ar.add(2,2);
   // System.out.println(ar.get(1));
    System.out.println(ar);
  }
}
