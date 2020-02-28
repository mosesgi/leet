package com.moses.leet.n0380;


//better solution
//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83599/Accepted-C%2B%2B-codes-with-explanation-and-references
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return 0;
        }
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = matrix[rows-1][cols-1];
        int max = Integer.MIN_VALUE;

        if(dp[rows-1][cols-1] <= k && dp[rows-1][cols-1] > max){
            max = dp[rows-1][cols-1];
        }
        for(int i=rows-2; i>=0; i--){
            dp[i][cols-1] = matrix[i][cols-1] + dp[i+1][cols-1];
            if(dp[i][cols-1] <= k && dp[i][cols-1] > max){
                max = dp[i][cols-1];
            }
        }
        for(int j=cols-2; j>=0; j--){
            dp[rows-1][j] = matrix[rows-1][j] + dp[rows-1][j+1];
            if(dp[rows-1][j] <= k && dp[rows-1][j] > max){
                max = dp[rows-1][j];
            }
        }

        for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){
                dp[i][j] = matrix[i][j] + dp[i+1][j] + dp[i][j+1] - dp[i+1][j+1];
                if(dp[i][j] <= k && dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        if(max == k){
            return max;
        }

        for(int i=0; i<rows-1; i++){
            for(int j=0; j<cols-1; j++){

                for(int m=i; m<rows; m++){
                    for(int n = j; n<cols; n++){
                        int right = 0;
                        int bottom = 0;
                        int br = 0;
                        if(m<rows-1){
                            bottom = dp[m+1][j];
                        }
                        if(n<cols-1){
                            right = dp[i][n+1];
                        }
                        if(m<rows-1 && n<cols-1){
                            br = dp[m+1][n+1];
                        }
                        int tmp = dp[i][j] - bottom - right + br;
                        if(tmp <= k && tmp > max){
                            max = tmp;
                            if(tmp == k){
                                return tmp;
                            }
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix; int k;
//        matrix = new int[][]{
//                {1,0,1}, {0,-2,3}
//        };
//        k=2;
//        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(matrix, k));

        matrix = new int[][]{
                { 5,-4,-3, 4},
                {-3,-4, 4, 5},
                { 5, 1, 5,-4}
        };
        k=8;
        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(matrix, k));
    }
}
