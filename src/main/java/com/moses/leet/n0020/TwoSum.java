package com.moses.leet.n0020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new HashSet<>());
            map.get(nums[i]).add(i);
        }
        for(int i=0; i<nums.length; i++){
            int remain = target - nums[i];
            if(map.containsKey(remain)){
                Set<Integer> set = map.get(remain);
                if(set.contains(i) && set.size() > 1){
                    set.remove(i);
                    int j = set.iterator().next();
                    return new int[]{i,j};
                }else if(!set.contains(i)){
                    int j = set.iterator().next();
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
