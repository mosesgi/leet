package com.moses.leet.n0720;

public class DesignHashSet {
    class MyHashSet {
        int[] ary;
        /** Initialize your data structure here. */
        public MyHashSet() {
            ary = new int[1000001];
        }

        public void add(int key) {
            if(ary[key] >0){
                return;
            }
            ary[key]=1;
        }

        public void remove(int key) {
            if(ary[key]==0){
                return;
            }
            ary[key] = 0;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return ary[key]==1;
        }
    }
}
