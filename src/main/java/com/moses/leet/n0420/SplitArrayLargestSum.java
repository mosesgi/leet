package com.moses.leet.n0420;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        Integer[][] dp = new Integer[nums.length+1][m+1];
        return recursive(nums, m, 0, dp);
    }

    private int recursive(int[] nums, int m, int start, Integer[][] dp){
        if(dp[start][m] != null){
            return dp[start][m];
        }
        if(m==1){
            int sum = 0;
            for(int i=start; i<nums.length; i++){
                sum+=nums[i];
            }
            dp[start][m] = sum;
            return sum;
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        for(int i = start; i<=nums.length-m; i++){
            left+=nums[i];
            int right = recursive(nums, m-1, i+1, dp);
            int currLargest = Math.max(left, right);
            if(currLargest < min){
                min = currLargest;
            }
        }
        dp[start][m] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] nums;
        int m;
        nums = new int[]{7,2,5,10,8};
        m = 2;
        System.out.println(new SplitArrayLargestSum().splitArray(nums, m));
    }
}
