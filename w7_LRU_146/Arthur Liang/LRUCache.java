package com.project;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("参数错误");
        }
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();

    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            return -1;
        } else {
            this.map.remove(key);
            this.map.put(key, value);
            return value.intValue();
        }
    }

    public synchronized void put(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        }
        this.map.put(key, value);
        int size = this.map.size();
        while (true) {
            if (size <= this.capacity || size == 0) {
                break;
            }
            Map.Entry<Integer, Integer> toEvict = map.entrySet().iterator().next();
            int k = toEvict.getKey();
            this.map.remove(k);
            size--;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        if (cache.get(1) != 1) {
            System.out.println("unPass");
        }

        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        if (cache.get(2) != -1) {
            System.out.println("unPass");
        }
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        if (cache.get(1) != -1) {
            System.out.println("unPass");
        }
        if (cache.get(1) != -1) {
            System.out.println("unPass");
        }
        if (cache.get(3) != 3) {
            System.out.println("unPass");
        }
        if (cache.get(4) != 4) {
            System.out.println("unPass");
        }
    }
}
