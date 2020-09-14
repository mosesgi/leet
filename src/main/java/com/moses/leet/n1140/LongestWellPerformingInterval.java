package com.moses.leet.n1140;

import java.util.Arrays;

public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int[] dp = new int[hours.length+1];
        for(int i=1; i<=hours.length; i++){
            dp[i] = dp[i-1] + (hours[i-1]>8?1:-1);
        }
//        System.out.println(Arrays.toString(dp));
        int max = 0;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(dp[i] > dp[j]){
                    max = Math.max(max, i-j);
                    break;
                }
            }
        }
        return max;
    }
}
