package com.moses.leet.n0600;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for(int key : map.keySet()){
            if(map.containsKey(key-1)) {
                max = Math.max(map.get(key) + map.get(key - 1), max);
            }
            if(map.containsKey(key+1)) {
                max = Math.max(map.get(key) + map.get(key + 1), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,1,1,1};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(nums));
    }
}
