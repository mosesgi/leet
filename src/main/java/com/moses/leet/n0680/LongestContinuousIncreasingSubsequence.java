package com.moses.leet.n0680;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int max = 0;
        int tmp = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                tmp++;
            }else{
                max = Math.max(tmp, max);
                tmp = 1;
            }
        }
        max = Math.max(tmp, max);
        return max;
    }
}
