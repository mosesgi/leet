package com.moses.leet.n0420;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0; i<nums.length+1; i++){
            dp[i][0] = true;
        }
        for(int i=0; i<sum+1; i++){
            dp[0][i] = false;
        }

        for(int i=1; i<nums.length+1; i++){
            for(int j = 1; j<sum+1; j++){
                dp[i][j] = dp[i-1][j];      //not choosing current number.
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];        //choose current number and check if it can add up to j.
                }
            }
        }
        return dp[nums.length][sum];
    }

    //mine. Got lucky it passed. It shouldn't.
    public boolean canPartitionMine(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int half = sum/2;

        return dfs(nums, nums.length-1, half);
    }

    private boolean dfs(int[] nums, int start, int dec){
        if(dec ==0){
            return true;
        }
        if(dec < 0){
            return false;
        }
        for(int i=start; i>=0; i--){
            if(nums[i] > dec){
                return false;
            } else if(nums[i] == dec){
                return true;
            }
            if(dfs(nums, i-1, dec-nums[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{91,4,44,50,6,63,63,92,33,68,92,27,16,96,65,51,71,90,25,56,42,49,68,4,59,29,90,6,47,83,44,32,2,51,36,80,50,12,14,13,41,66,93,83,3,58,65,96,18,4,78,100,72,66,7,49,43,67,80,87,83,35,65,47,40,28,51,45,31,73,22,23,15,70,56,77,77,93,84,71,83,16,80,56,5,49,94,50,36,98,89,17,56,52,24,88,14,48,41,61};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));

        nums = new int[]{17,58,41,75,61,70,52,7,38,11,40,58,44,45,4,81,67,54,79,80,15,3,14,16,9,66,69,41,72,37,28,3,33,90,56,12,72,49,35,22,49,27,49,82,41,77,100,82,18,95,24,51,37,2,34,82,70,53,73,32,90,98,81,22,73,76,79,40,27,62,45,96,36,15,63,28,54,88,63,37,58,9,62,98,93,72,99,53,91,29,61,31,11,42,20,35,50,68,10,86};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));


        nums = new int[]{1,2,5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));

        nums = new int[]{1,5,11,5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));

        nums = new int[]{1,2,3,5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));

        nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
