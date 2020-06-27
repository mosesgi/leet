package com.moses.leet.n0760;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2){
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<cost.length; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[cost.length-2], dp[cost.length-1]);
    }
}
