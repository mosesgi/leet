package com.moses.leet.n0920;

import java.util.HashMap;
import java.util.Map;

public class XofAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : deck){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int key = 0;
        for(int k : map.keySet()){
            if(map.get(k) < min){
                min = map.get(k);
                key = k;
            }
        }

        if(min <2 ){
            return false;
        }

        for(int i=2; i<=min; i++) {
            boolean found = true;
            for (int k : map.keySet()) {
                if (map.get(k) % i != 0) {
                    found = false;
                }
            }
            if(found){
                return true;
            }
        }
        return false;
    }
}
