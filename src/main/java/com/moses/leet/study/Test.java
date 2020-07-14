package com.moses.leet.study;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class Test {

    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int i: stones){
            total+=i;
        }
        int half = total/2;
        int[][] dp = new int[stones.length+1][half+1];
        for(int i=1; i<=stones.length; i++){
            for(int j=0; j<=half; j++){
                if(j>=stones[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]] + stones[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return total - 2* dp[stones.length][half];
    }

    public static void main(String[] args) {

    }
}
