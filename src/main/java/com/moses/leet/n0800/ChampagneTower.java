package com.moses.leet.n0800;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //    0
        //   0,1
        //  0,1,2
        // 0,1,2,3
        //0,1,2,3,4
        double[][] dp = new double[query_row+1][query_row+1];
        dp[0][0] = poured;
        for(int i=0; i<query_row; i++){
            for(int j=0; j<=i; j++){
                dp[i+1][j] += (dp[i][j]-1>0?dp[i][j]-1:0)/2;
                dp[i+1][j+1] += (dp[i][j]-1>0?dp[i][j]-1:0)/2;
            }
        }
        return dp[query_row][query_glass]>1?1:dp[query_row][query_glass];
    }
}
