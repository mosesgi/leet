package com.moses.leet.n0420;

import java.util.Arrays;

public class FrogJump {
    public boolean canCross(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length+1][stones.length+1];
        return dfs(stones, 0, 1, dp);
    }

    private boolean dfs(int[] stones, int currPos, int step, Boolean[][] dp) {
        if(step <=0){
            return false;
        }
        if(dp[currPos][step]!= null){
            return dp[currPos][step];
        }
        int nextPos = Arrays.binarySearch(stones, stones[currPos] + step);
        if(nextPos == stones.length-1){
            dp[currPos][step] = true;
            return true;
        }
        if(nextPos > 0){
            boolean n1 = dfs(stones, nextPos, step-1, dp);
            boolean n2 = dfs(stones, nextPos, step, dp);
            boolean n3 = dfs(stones, nextPos, step+1, dp);
            if(n1 || n2 || n3){
                dp[currPos][step] = true;
                return true;
            }
        }
        dp[currPos][step] = false;
        return false;
    }

    public static void main(String[] args) {
        int[] stones;
        stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(new FrogJump().canCross(stones));

        stones = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(new FrogJump().canCross(stones));
    }
}
