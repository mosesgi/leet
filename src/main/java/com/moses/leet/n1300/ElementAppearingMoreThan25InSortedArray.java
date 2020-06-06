package com.moses.leet.n1300;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int target = n/4;
        for(int k : map.keySet()){
            if(map.get(k) > target){
                return k;
            }
        }
        return -1;
    }
}
