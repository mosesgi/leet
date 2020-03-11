package com.moses.leet.n0440;

import java.util.*;

public class AllOneDataStructure {
    //Got the idea by myself. HashMap + Double linked list. Too complex to implement.
    class AllOne {
        Element head, tail;
        Map<String, Integer> mainMap;
        Map<Integer, Element> valElementMap;

        /** Initialize your data structure here. */
        public AllOne() {
            mainMap = new HashMap<>();
            valElementMap = new HashMap<>();
            head = new Element(0, "");
            tail = new Element(Integer.MAX_VALUE, "");
            head.next = tail;
            tail.prev = head;
        }

        public void print(){
            Element next = head.next;
            while(next != tail){
                System.out.print("[val=" + next.value + ", set=" + Arrays.toString(next.keys.toArray()) + "], ");
                next = next.next;
            }
            System.out.println();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
//            if(mainMap.isEmpty()){
//                Element ele = new Element(1, key);
//                ele.keys.add(key);
//                valElementMap.put(1, ele);
//                head.next = ele; ele.prev = head;
//                tail.prev = ele; ele.next = tail;
//                mainMap.put(key, 1);
//                return;
//            }
            boolean exist = mainMap.containsKey(key);
            int curr = mainMap.getOrDefault(key, 0);
            mainMap.put(key, curr+1);

            //if not exist, add key in 1 Element
            //if exist, remove from curr Element, add key in curr+1 Element.
            Element currElem = head;
            if(exist){
                Element ele = valElementMap.get(curr);
                currElem = ele.removeKey(key);
                if(ele != currElem){
                    valElementMap.remove(curr);
                }
            }
            Element nextElem = currElem.next;
            if(nextElem.value != curr+1){   //增长之后的Element肯定是之前的Element后面一个. 如果不存在就新创建加入链表
                Element ele = new Element(curr+1, key);
                currElem.next = ele; ele.prev = currElem;
                nextElem.prev = ele; ele.next = nextElem;
                valElementMap.put(curr+1, ele);
            }else{
                nextElem.keys.add(key);
            }
            print();
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if(!mainMap.containsKey(key)){
                return;
            }
            int curr = mainMap.get(key);
            boolean needAdd = true;
            if(curr == 1){
                mainMap.remove(key);
                needAdd = false;
                //remove from currElement
            }else {
                //decrease 1
                mainMap.put(key, curr-1);
                //remove from currElement, add to curr-1 Element
            }
            //remove from currElement
            Element ele = valElementMap.get(curr);
            Element currentElem = ele.removeKey(key);   //current Or previousElement if ele is deleted.
            if(needAdd){
                if(ele == currentElem){
                    //Element not removed
                    Element prev = ele.prev;
                    if(prev.value != curr-1){
                        Element newEle = new Element(curr-1, key);
                        prev.next = newEle; newEle.prev = prev;
                        ele.prev = newEle; newEle.next = ele;
                        valElementMap.put(curr-1, newEle);
                    }else {
                        prev.keys.add(key);
                    }
                } else {
                    valElementMap.remove(curr);
                    //ele removed.
                    if(currentElem.value == curr-1){
                        currentElem.keys.add(key);
                    }else{
                        Element newEle = new Element(curr-1, key);
                        Element next = currentElem.next;
                        currentElem.next = newEle; newEle.prev = currentElem;
                        next.prev = newEle; newEle.next = next;
                        valElementMap.put(curr-1, newEle);
                    }
                }
            }
            print();
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            Element max = tail.prev;
            return max.keys.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            Element min = head.next;
            return min.keys.iterator().next();
        }

        class Element{
            Set<String> keys;
            int value;
            Element prev;
            Element next;

            Element(int value, String key){
                this.value = value;
                keys = new HashSet<>();
                keys.add(key);
            }

            Element removeKey(String key){
                keys.remove(key);
                if(keys.isEmpty()){
                    prev.next = next;
                    next.prev = prev;
                    return prev;
                }
                return this;
            }

        }
    }

    public static void main(String[] args) {
        AllOneDataStructure outer = new AllOneDataStructure();
        AllOne in = outer.new AllOne();

        in.inc("hello");
        in.inc("world");
        in.inc("hello");
        in.dec("world");
        in.inc("hello");
        in.inc("leet");
        in.dec("hello");
        in.dec("hello");
        in.dec("hello");
        System.out.println(in.getMaxKey());

//        in.inc("a");
//        in.inc("b");
//        in.inc("b");
//        in.inc("b");
//        in.inc("b");
//        in.inc("b");
//        in.dec("b");
//        in.dec("b");
//        System.out.println(in.getMaxKey());
//        System.out.println(in.getMinKey());


//        in.inc("a");
//        in.inc("b");
//        in.inc("a");
//        in.inc("a");
//        in.inc("c");
//        in.inc("b");
//        System.out.println(in.getMinKey());
//        System.out.println(in.getMaxKey());
//        in.dec("a");
//        System.out.println(in.getMinKey());
//        System.out.println(in.getMaxKey());
//        in.dec("c");
//        System.out.println(in.getMinKey());
//        System.out.println(in.getMaxKey());
    }
}
