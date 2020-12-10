package com.aaron.ren.leet20200913;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(4);

        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.get(1);
        cache.put(5,5);

        System.out.println(cache);
    }

    private LinkedHashMap<Integer,Integer>  cache;

    private  int capacity;
    public LRUCache(int capacity) {

        //todo  这个方法中 要了解这些都是啥
        cache=new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };


    }

    public int get(int key) {
         //这个方法又是啥
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key,value);
    }
}
