package com.sample;

import java.io.PrintStream;

public class ReverseLinkedList
{
  private Node head;

  static class Node
  {
    int data;
    Node next;

    Node(int data)
    {
      this.data = data;
      this.next = null;
    }
  }

  void reverse()
  {
    Node current = this.head;
    Node prev = null;
    Node next = null;
    while (current != null)
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    this.head = prev;
  }

  void push(int n)
  {
    if (this.head == null)
    {
      this.head = new Node(n);
      return;
    }
    Node next = this.head.next;
    Node prev = this.head;
    while (next != null)
    {
      prev = next;
      next = next.next;
    }
    prev.next = new Node(n);
  }

  void printList()
  {
    Node n = this.head;
    while (n != null)
    {
      System.out.println(n.data);
      n = n.next;
    }
  }

  public static void main(String[] args)
  {
    ReverseLinkedList r = new ReverseLinkedList();
    r.push(1);
    r.push(2);
    r.push(3);

    r.printList();
    r.reverse();
    r.printList();
  }
}
