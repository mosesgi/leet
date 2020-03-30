package com.moses.leet.n0640;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(nums[0] >=0){
            return nums[len-1] * nums[len-2] * nums[len-3];
        }{
            return Math.max(nums[len-1] * nums[len-2] * nums[len-3], nums[0]*nums[1] * nums[len-1]);
        }
    }
}
