package com.moses.leet.n0900;

import java.util.Arrays;

//https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
public class DicePossibilities {
    public double[] twoSum(int n) {
        double base = 1 / 6d;
        double[][] dp = new double[n+1][6*n+1];
        Arrays.fill(dp[1], base);
        for(int i=2; i<=n; i++){
            double[] prev = dp[i-1];
            int start = i-1;
            int end = 6*(i-1);
            for(int j=1; j<=6; j++){
                for(int k = start; k<=end; k++){
                    dp[i][k+j] += base * prev[k];
                }
            }
        }
        return Arrays.copyOfRange(dp[n], n, dp[n].length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DicePossibilities().twoSum(2)));
    }
}
