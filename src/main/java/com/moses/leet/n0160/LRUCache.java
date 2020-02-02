package com.moses.leet.n0160;

import java.util.*;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cnt;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cnt = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        refreshNode(n);
        return n.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            refreshNode(n);
            return;
        }
        if(cnt == capacity){
            Node h = head;
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            map.remove(h.key);
            cnt--;
            if(cnt == 0){
                tail = null;
            }
        }
        Node node = new Node(key, value);
        if(cnt == 0){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        cnt++;
        map.put(key, node);
    }

    private void refreshNode(Node n) {
        if(cnt == 1){
            return;
        }
        if(n==tail){
            return;
        }
        if(n==head){
            head = head.next;
            head.prev = null;
            tail.next = n;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            tail.next = n;
        }
        n.prev = tail;
        n.next = null;
        tail = n;
    }

    class Node{
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache c2 = new LRUCache(3);
        c2.put(1, 1);
        c2.put(2, 2);
        c2.put(3, 3);
        c2.put(4, 4);
        System.out.println(c2.get(4));      //4
        System.out.println(c2.get(3));      //3
        System.out.println(c2.get(2));      //2
        System.out.println(c2.get(1));      //-1
        c2.put(5, 5);
        System.out.println(c2.get(1));
        System.out.println(c2.get(2));
        System.out.println(c2.get(3));
        System.out.println(c2.get(4));
        System.out.println(c2.get(5));

        System.out.println();


        LRUCache c1 = new LRUCache(2);
        c1.put(2, 1);
        c1.put(1, 1);
        c1.put(2, 3);
        c1.put(4, 1);
        System.out.println(c1.get(1));      //-1
        System.out.println(c1.get(2));      //3

        System.out.println();


        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }




















//    private Map<Integer, Integer> map;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>();
//        set = new LinkedHashSet<>();    //or use LinkedHashMap itself, hasSet can be removed. This is cheating.
//        cnt = 0;
//    }
//
//    public int get(int key) {
//        if(map.containsKey(key)){
//            set.remove(key);
//            set.add(key);
//            return map.get(key);
//        } else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        if(!map.containsKey(key)){
//            if(cnt == capacity){
//                Iterator<Integer> iter = set.iterator();
//                map.remove(iter.next());
//                iter.remove();
//                cnt--;
//            }
//            cnt++;
//            set.add(key);
//        } else {
//            set.remove(key);
//            set.add(key);
//        }
//        map.put(key, value);
//    }

}
