package com.leet.others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    private HashMap<Integer, Integer> valueMap;
    private Deque<Integer> valueSeque;
    private int capacity;
    private int size;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        valueMap = new HashMap<>(capacity);
        // 速度差不多
        valueSeque = new LinkedList<>();
//        valueSeque = new ArrayDeque<>();

    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            valueSeque.remove(key);
            valueSeque.addFirst(key);
            return valueMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!valueMap.containsKey(key)) {
            if (size == capacity){
                Integer last = valueSeque.removeLast();
                valueMap.remove(last);
            } else {
                size++;
            }
        }
        // move key to first
        valueSeque.remove(key);
        valueSeque.addFirst(key);
        valueMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        int i1 = lruCache.get(1);
        int i2 = lruCache.get(2);
        System.out.println(i1);
        System.out.println(i2);
    }
}
