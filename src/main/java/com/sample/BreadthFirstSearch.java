package com.sample;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearch {

  static class Node {

    String data;

    @Override
    public String toString() {
      return "Node{" +
          "data='" + data + '\'' +
          '}';
    }

    List<Node> adjacents;

    public Node(String data) {
      this.data = data;
    }

    public String getData() {
      return data;
    }

    public void setData(String data) {
      this.data = data;
    }

    public List<Node> getAdjacents() {
      return adjacents;
    }

    public void setAdjacents(List<Node> adjacents) {
      this.adjacents = adjacents;
    }

    public Node(String data, List<Node> adjacents) {
      this.data = data;
      this.adjacents = adjacents;
    }
  }

  public static void main(String[] args) {
    /*
        / B - E
    A <
        \ C - D - F

     */
    Node a = new Node("A");
    Node b = new Node("B");
    Node c = new Node("C");
    Node d = new Node("D");
    Node e = new Node("E");
    Node f = new Node("F");

    a.setAdjacents(Arrays.asList(b, c));
    b.setAdjacents(Arrays.asList(a, e));
    c.setAdjacents(Arrays.asList(a, d));
    d.setAdjacents(Arrays.asList(c, f));
    e.setAdjacents(Arrays.asList(d));
    f.setAdjacents(Arrays.asList(d));

    Queue<Node> queue = new ArrayDeque<>();
    Set<Node> seen = new HashSet<Node>();

    queue.add(a);
    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      if (!seen.contains(curr)) {
        seen.add(curr);
        System.out.println(curr);
      }
      for (Node adj : curr.getAdjacents()) {
        if (!seen.contains(adj)) {
          queue.add(adj);
        }
      }

    }

  }
}
