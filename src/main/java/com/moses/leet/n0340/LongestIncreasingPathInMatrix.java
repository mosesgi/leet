package com.moses.leet.n0340;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return 0;
        }
        int[][] dp = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i][j] = -1;
            }
        }

        int max = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int tmp = recursive(matrix, dp, i, j, rows, cols);
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        return max;
    }

    private int recursive(int[][] matrix, int[][] dp, int i, int j, int rows, int cols) {
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int r1=0, r2=0, r3=0, r4=0;
        if(i>0 && matrix[i-1][j] > matrix[i][j]) {
            r1 = recursive(matrix, dp, i - 1, j, rows, cols);
        }
        if(i<rows-1 && matrix[i+1][j] > matrix[i][j]) {
            r2 = recursive(matrix, dp, i+1, j, rows, cols);
        }
        if(j>0 && matrix[i][j-1] > matrix[i][j]) {
            r3 = recursive(matrix, dp, i, j - 1, rows, cols);
        }
        if(j<cols-1 && matrix[i][j+1] > matrix[i][j]) {
            r4 = recursive(matrix, dp, i, j + 1, rows, cols);
        }
        int max = Math.max(Math.max(Math.max(r1, r2), r3), r4) + 1;
        dp[i][j] = max;
        return max;
    }
}
