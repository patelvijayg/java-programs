package com.sample;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CustomCache<K, V> {

  public static void main(String[] args) {
    CustomCache<Integer, Integer> cc = new CustomCache<>();
    cc.add(1, null);
    cc.add(2, 20, 2000l);
    cc.add(3, 30, 12000l);
    cc.add(4, 20, 22000l);

    new Thread(()->{
    for (int i = 0; i < 15; i++) {
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
      }
      cc.display();
      System.out.println("-----");
    }}).start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    cc.remove(4);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    cc.clear();
  }

  private Map<K, CustomValue> cache = new HashMap<>();

  private class CustomValue {

    private V value;
    private Long timeExpiry;

    public CustomValue(V value, Long timeExpiry) {
      this.value = value;
      this.timeExpiry = timeExpiry;
    }

    public boolean isExpired() {
      return System.currentTimeMillis() > this.timeExpiry;
    }
  }

  private static final Long DEFAULT_EXPRITY = 5000L;

  public void clear(){
    this.cache.clear();
  }
  public void remove(K key){
    this.cache.remove(key);
  }


  public void add(K k, V v) {
    add(k, v, DEFAULT_EXPRITY);
  }

  public void add(K key, V value, Long timeExpiry) {
    CustomValue data = new CustomValue(value, System.currentTimeMillis() + timeExpiry);
    cache.put(key, data);
  }

  public void display() {
    for (Map.Entry<K, CustomValue> e : cache.entrySet()) {
      System.out.println(e.getKey() + " :: " + e.getValue().value);
    }
  }

  public V get(K key) {
    return cache.get(key).value;
  }

  public CustomCache() {

    Thread cleanerThread = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted()) {
        try {
          Thread.sleep(100);
          cache.entrySet().removeIf(e -> e.getValue().isExpired());

        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {

        }
      }
    });
    cleanerThread.setDaemon(true);
    cleanerThread.start();

  }
//m1.entrySet().removeIf(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get).map(CacheObject::isExpired).orElse(false));
}
