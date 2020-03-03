package com.moses.leet.n0380;

import java.util.*;

public class InsertDeleteGetRandom {
    class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random r;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            r = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            int pos = map.get(val);
            //swap element with last one.
            if(pos == list.size()-1){
                list.remove(list.size()-1);
                map.remove(val);
                return true;
            }
            int lastVal = list.get(list.size()-1);
            list.set(pos, lastVal);
            list.remove(list.size()-1);
            map.put(lastVal, pos);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = r.nextInt(list.size());
            return list.get(index);
        }
    }
}
