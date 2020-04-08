package com.moses.leet.n0700;

import java.util.*;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int big = 0;
        int sum = 0;
        for(int i : nums){
            sum+=i;
            big = Math.max(big, i);
        }

        if(sum%k != 0){
            return false;
        }
        int avg = sum/k;
        if(big > avg){
            return false;
        }
        Map<String, Boolean> dp = new HashMap<>();
        return dfs(nums, avg, k, 0, dp);
    }

    private boolean dfs(int[] nums, int avg, int k, int sum, Map<String, Boolean> dp) {
        if(sum == avg){
            sum=0;
            k--;
            if(k==0){
                return true;
            }
        }
        String key = serialize(nums) +"_" + sum+"_"+k;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] >0 && sum+nums[i] <= avg) {
                int origin = nums[i];
                nums[i] = -1;
                if(dfs(nums, avg, k, sum+origin, dp)){
                    dp.put(key, true);
                    return true;
                }
                nums[i] = origin;
            }
        }
        dp.put(key, false);
        return false;
    }

    private int serialize(int[] nums){
        int tmp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                tmp |= 1<<i;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;

        nums = new int[]{815,625,3889,4471,60,494,944,1118,4623,497,771,679,1240,202,601,883};
        k=3;
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums, k));

        nums = new int[]{4,3,2,3,5,2,1};
        k=4;
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums, k));
    }

}
