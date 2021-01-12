package com.sample;

import java.io.PrintStream;

public class CustomLinkedList
{
  transient int count = 0;
  transient int position = -1;
  Node head;

  static class Node
  {
    int data;
    Node next;

    public Node(int data)
    {
      this.data = data;
      this.next = null;
    }

    public String toString()
    {
      return String.valueOf(this.data);
    }
  }

  public void remove()
  {
    Node prev = this.head;
    Node next = this.head.next;
    while ((next != null) &&
        (next.next != null))
    {
      prev = next;
      next = next.next;
    }
    this.count -= 1;
    prev.next = null;
  }

  public void add(int data)
  {
    Node n = new Node(data);
    if (this.head == null)
    {
      this.head = n;
      this.count += 1;
      return;
    }
    Node prev = this.head;
    Node next = this.head.next;
    while (next != null)
    {
      prev = next;
      next = next.next;
    }
    prev.next = n;
    this.count += 1;
  }

  public Node next()
  {
    if ((this.position == -1) && (this.count == 0)) {
      return null;
    }
    Node n = this.head;
    for (int i = -1; i < this.position; i++) {
      n = n.next;
    }
    this.position += 1;
    return n;
  }

  public static void main(String[] args)
  {
    CustomLinkedList l = new CustomLinkedList();

    l.add(1);
    l.add(2);
    l.add(3);
    l.remove();
    System.out.println(l.count);
    l.add(4);
    System.out.println(l.count);
    System.out.println(l.next());
    System.out.println(l.next());
    System.out.println(l.next());
    System.out.println(l.next());
  }
}
