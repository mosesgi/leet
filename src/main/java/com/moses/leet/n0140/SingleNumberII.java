package com.moses.leet.n0140;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number-ii/
 * 位运算： https://leetcode.com/problems/single-number-ii/discuss/43294/Challenge-me-thx
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int k : map.keySet()){
            if(map.get(k) == 1){
                return k;
            }
        }
        return -1;
    }


    public int singleNumberOld(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i==nums.length-1){
                return nums[i];
            }
            if(nums[i] != nums[i+1]){
                return nums[i];
            } else {
                i = i+2;
            }
        }
        return -1;
    }
}
