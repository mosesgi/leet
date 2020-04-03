package com.moses.leet.n0680;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    class MapSum {
        Map<String, Integer> map;
        Map<String, Integer> origin;
        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
            origin = new HashMap<>();
        }

        public void insert(String key, int val) {
            int originValue = 0;
            if(origin.containsKey(key)){
                originValue = origin.get(key);
            }
            origin.put(key, val);
            for(int i=1; i<=key.length(); i++){
                String sub = key.substring(0, i);
                map.put(sub, map.getOrDefault(sub, 0) + val - originValue);
            }
        }

        public int sum(String prefix) {
            if(!map.containsKey(prefix)){
                return 0;
            }
            return map.get(prefix);
        }
    }
}
