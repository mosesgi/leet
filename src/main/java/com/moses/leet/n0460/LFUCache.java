package com.moses.leet.n0460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    //O(1) solution with LinkedHashSet
    private int capacity;
    private int min;
    private Map<Integer, Integer> keyMap;
    private Map<Integer, Integer> countMap; //count as value
    private Map<Integer, LinkedHashSet<Integer>> minMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        minMap = new HashMap<>();
    }

    public int get(int key) {
        if(capacity == 0 || !keyMap.containsKey(key)){
            return -1;
        }
        int oldCnt = countMap.get(key);
        minMap.get(oldCnt).remove(key);
        if(min == oldCnt && minMap.get(oldCnt).size() == 0){
            min++;
            minMap.remove(oldCnt);
        }

        int newCnt = oldCnt + 1;
        countMap.put(key, newCnt);       //count++
        if(!minMap.containsKey(newCnt)){
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            set.add(key);
            minMap.put(newCnt, set);
        }else{
            minMap.get(newCnt).add(key);
        }
        return keyMap.get(key);
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(keyMap.containsKey(key)){
            get(key);
            keyMap.put(key, value);
            return;
        }

        if(keyMap.size() == capacity){
            int toDelete = minMap.get(min).iterator().next();
            minMap.get(min).remove(toDelete);
            if(minMap.get(min).size() == 0){
                minMap.remove(min);
            }
            keyMap.remove(toDelete);
            countMap.remove(toDelete);
        }
        keyMap.put(key, value);
        countMap.put(key, 1);
        if(!minMap.containsKey(1)){
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            set.add(key);
            minMap.put(1, set);
        } else {
            minMap.get(1).add(key);
        }
        min=1;
    }



    // TreeSet O(NlogN)
//    int capacity;
//    int currSize;
//    Map<Integer, Element> mainMap;
//    TreeSet<Element> set;
//    static long time = 0;
//
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        currSize = 0;
//        mainMap = new HashMap<>();
//        set = new TreeSet<>();
//    }
//
//    public int get(int key) {
//        if(capacity == 0 || !mainMap.containsKey(key)){
//            return -1;
//        }
//        Element ele = mainMap.get(key);
//        set.remove(ele);
//        ele.freq++;
//        ele.lastUsedTime = time++;
//        set.add(ele);
//        return ele.value;
//    }
//
//    public void put(int key, int value) {
//        if(capacity == 0){
//            return;
//        }
//        if(mainMap.containsKey(key)){
//            Element ele = mainMap.get(key);
//            set.remove(ele);
//            ele.value = value;
//            ele.lastUsedTime = time++;
//            ele.freq++;
//            set.add(ele);
//            return;
//        }
//        if(currSize == capacity){
//            Element ele = set.pollFirst();
//
//            Element va = mainMap.remove(ele.key);
//            currSize--;
//        }
//        Element ele = new Element(key, value);
//        boolean added = set.add(ele);
//        mainMap.put(key, ele);
//        currSize++;
//    }
//
//    class Element implements Comparable<Element>{
//        int key;
//        int value;
//        int freq;
//        long lastUsedTime;
//
//        Element(int key, int value){
//            this.key = key;
//            this.value = value;
//            this.lastUsedTime = time++;
//        }
//
//        public int compareTo(Element o1){
//            if(freq != o1.freq){
//                return freq - o1.freq;
//            }
//            if(lastUsedTime < o1.lastUsedTime){
//                return -1;
//            }else if(lastUsedTime > o1.lastUsedTime){
//                return 1;
//            }else {
//                return 0;
//            }
//        }
//
//        @Override
//        public int hashCode(){
//            return 31*key;
//        }
//
//        @Override
//        public boolean equals(Object o){
//            Element e = (Element)o;
//            return e.key == this.key && e.value == this.value;
//        }
//    }

    public static void main(String[] args) {
        LFUCache c;
        c = new LFUCache(2);
        c.put(1,1);
        c.put(2,2);
        System.out.println(c.get(1));
        c.put(3,3);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        c.put(4,4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }
}
