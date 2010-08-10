package com.googlecode.concurrentlinkedhashmap.caches;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A non-thread safe bounded map. Operates in LRU or FIFO mode.
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
class UnsafeMap<K, V> extends LinkedHashMap<K, V> {
  private static final long serialVersionUID = 1L;
  private final int capacity;

  /**
   * @param accessOrder The eviction policy: true=LRU, false=FIFO.
   * @param capacity    The maximum capacity of the map.
   */
  public UnsafeMap(boolean accessOrder, int capacity) {
    super(capacity, 0.75f, accessOrder);
    this.capacity = capacity;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  }
}