package com.moses.leet.n0400;

import java.util.*;

public class InsertDeleteGetRandomDuplicateAllow {
    class RandomizedCollection {
        Map<Integer, Set<Integer>> map;
        Random r;
        List<Integer> list = new ArrayList<>();
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            r = new Random();
            list = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            list.add(val);
            if(!map.containsKey(val)){
                Set<Integer> pos = new HashSet<>();
                pos.add(list.size()-1);
                map.put(val, pos);
                return true;
            }
            map.get(val).add(list.size()-1);
            return false;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            Set<Integer> pos = map.get(val);
            if(list.get(list.size()-1) == val){
                pos.remove(list.size()-1);
                if(pos.size() == 0){
                    map.remove(val);
                }
                list.remove(list.size()-1);
                return true;
            }
            Iterator<Integer> iter = pos.iterator();
            Integer po = iter.next();
            if(po != list.size()-1){
                //switch element with last element in List
                Integer lastKey = list.get(list.size()-1);
                list.set(po, lastKey);
                Set<Integer> replaced = map.get(lastKey);
                replaced.remove(list.size()-1);
                replaced.add(po);
            }
            list.remove(list.size()-1);
            iter.remove();
            if(pos.size() == 0){
                map.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int i = r.nextInt(list.size());
            return list.get(i);
        }
    }


}
