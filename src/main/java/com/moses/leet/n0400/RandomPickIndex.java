package com.moses.leet.n0400;

import java.util.*;

public class RandomPickIndex {
    class Solution {
        Map<Integer, List<Integer>> map;
        Random r = new Random();
        public Solution(int[] nums) {
            map = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i])){
                    map.get(nums[i]).add(i);
                }else {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    map.put(nums[i], l);
                }
            }
        }

        public int pick(int target) {
            List<Integer> l = map.get(target);
            int i = r.nextInt(l.size());
            return l.get(i);
        }
    }

}
