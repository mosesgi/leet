package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        for(int i=1; i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    int ways = 0;
    public int uniquePathsOld(int m, int n){
//        recursive(0, 0, m, n);

        // dynamic programming. cache, cache, cache!!!!!!
        int[][] board = new int[n][m];

        for(int i=0; i<m; i++){
            board[n-1][i] = 1;
        }
        for(int i=0; i<n; i++){
            board[i][m-1] = 1;
        }
        if(n>=2 && m>=2) {
            for (int i = n - 2; i >= 0; i--) {
                for(int j= m-2; j>=0; j--){
                    board[i][j] = board[i+1][j] + board[i][j+1];
                }
            }
        } else {
            return 1;
        }

        return board[0][0];
    }

    //time limit exceeded
    private void recursive(int currX, int currY, int m, int n){
        if(currX == n-1 && currY == m-1){
            ways++;
            return;
        }

        if(currX < n-1 && currY < m-1){
            for(int i=0; i<2; i++){
                if(i==0){
                    recursive(currX+1, currY, m, n);
                } else {
                    recursive(currX, currY+1, m, n);
                }
            }
        } else if(currX == n-1 && currY < m-1){
            ways++;
            return;
        } else if(currX < n-1 && currY == m-1){
            ways++;
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7,3));
        System.out.println(new UniquePaths().uniquePaths(3,4));
        System.out.println(new UniquePaths().uniquePaths(3,2));

        System.out.println(new UniquePaths().uniquePaths(23,12));
    }
}
