package com.moses.leet.n0380;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return recursive(nums, target, dp);
    }

    private int recursive(int[] nums, int remain, int[] dp){
        if(remain == 0){
            return 1;
        }
        if(dp[remain] != -1){
            return dp[remain];
        }
        int tmp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <=remain){
                tmp+=recursive(nums, remain-nums[i], dp);
            }
        }
        dp[remain] = tmp;
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums;
        int target;
        nums = new int[]{2,1,3};
        target = 35;
        System.out.println(new CombinationSumIV().combinationSum4(nums, target));

        nums = new int[]{1,2,3};
        target = 4;
        System.out.println(new CombinationSumIV().combinationSum4(nums, target));
    }
}
