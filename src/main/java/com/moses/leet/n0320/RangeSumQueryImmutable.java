package com.moses.leet.n0320;

public class RangeSumQueryImmutable {

    //-2, 0, 3, -5, 2, -1
    //-2, -2, 1, -4, -2, -3
    class NumArray {
        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length];
            for(int i=0; i<nums.length; i++){
                if(i==0){
                    dp[i] = nums[0];
                } else {
                    dp[i] = nums[i] + dp[i-1];
                }
            }
        }

        public int sumRange(int i, int j) {
            if(i==0){
                return dp[j];
            }
            return dp[j] - dp[i-1];
        }
    }


}
