package com.comp1;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong {
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    Thread ping = new Thread(new PrintPingPong(lock,"Ping"));
    Thread pong = new Thread(new PrintPingPong(lock,"Pong"));
    ping.start();
    pong.start();
    try {
      ping.join();
      pong.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
class PrintPingPong implements Runnable{
  String message="Ping";
  Lock lock ;

  public PrintPingPong(Lock lock,String message) {
    this.lock = lock;
    this.message=message;
  }

  @Override
  public void run() {
    int i=0;
    while(i<10) {
      synchronized (lock) {

        lock.notifyAll();
        System.out.println(message);
        try {
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        i++;
      }
    }
  }
}