package com.moses.leet.n0540;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        if(k==0){
            int cnt = 0;
            for(int key: map.keySet()){
                if(map.get(key) >=2){
                    cnt++;
                }
            }
            return cnt;
        }
        int cnt = 0;
        for(int key : map.keySet()){
            if(map.containsKey(key+k)){
                cnt++;
            }
        }
        return cnt;
    }
}
