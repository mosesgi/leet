package com.moses.leet.n0720;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap {
    class MyHashMap {
        int cap = 10000;
        List<int[]>[] container;
        /** Initialize your data structure here. */
        public MyHashMap() {
            container = new List[cap];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int pos = key%cap;
            if(container[pos] == null || container[pos].isEmpty()){
                int[] entry = new int[]{key, value};
                List<int[]> list = new LinkedList<>();
                list.add(entry);
                container[pos] = list;
            }else{
                boolean exist = false;
                for(int[] entry : container[pos]){
                    if(entry[0] == key){
                        exist = true;
                        entry[1] = value;
                    }
                }
                if(!exist){
                    container[pos].add(new int[]{key, value});
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int pos = key%cap;
            if(container[pos] == null || container[pos].isEmpty()){
                return -1;
            }
            for(int[] entry:container[pos]){
                if(entry[0] == key){
                    return entry[1];
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int pos = key%cap;
            if(container[pos] == null || container[pos].isEmpty()){
                return;
            }
            Iterator<int[]> iter = container[pos].iterator();
            while(iter.hasNext()){
                int[] cur = iter.next();
                if(cur[0] == key){
                    iter.remove();
                    return;
                }
            }
        }
    }
}
