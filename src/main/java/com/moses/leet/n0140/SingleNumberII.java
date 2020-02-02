package com.moses.leet.n0140;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/single-number-ii/
 * 位运算： https://leetcode.com/problems/single-number-ii/discuss/43294/Challenge-me-thx
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
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
