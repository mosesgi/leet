package com.moses.leet.n0320;

public class RangeSumQuery2DImmutable {
    class NumMatrix {
        int[][] dp;
        int rows, cols;
        public NumMatrix(int[][] matrix) {
            rows = matrix.length;
            if(rows == 0){
                return;
            }
            cols = matrix[0].length;
            if(cols == 0){
                return;
            }
            dp = new int[rows][cols];
            for(int i=0; i<rows; i++){
                for(int j= 0; j<cols; j++){
                    dp[i][j] = matrix[i][j];
                    if(i>0){
                        dp[i][j] += dp[i-1][j];
                    }
                    if(j>0){
                        dp[i][j] += dp[i][j-1];
                    }
                    if(i>0 && j>0){
                        dp[i][j] -= dp[i-1][j-1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int big = dp[row2][col2];
            int top = 0;
            if(row1>0){
                top = dp[row1-1][col2];
            }
            int left = 0;
            if(col1 > 0){
                left = dp[row2][col1-1];
            }
            int topLeft = 0;
            if(row1 > 0 && col1 > 0){
                topLeft = dp[row1-1][col1-1];
            }
            return big-top-left+topLeft;
        }
    }


}
