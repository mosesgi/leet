package com.moses.leet.n0500;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                max = Math.max(max, tmp);
                tmp = 0;
            }else {
                tmp++;
            }
        }
        if(tmp != 0){
            max = Math.max(max, tmp);
        }
        return max;
    }
}
