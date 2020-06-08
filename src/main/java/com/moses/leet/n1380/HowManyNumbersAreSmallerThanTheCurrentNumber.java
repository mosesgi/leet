package com.moses.leet.n1380;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] origin = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i=1; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        int[] res = new int[nums.length];
        for(int i=0; i<origin.length; i++){
            res[i] = map.get(origin[i]);
        }
        return res;
    }
}
