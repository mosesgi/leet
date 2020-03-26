package com.moses.leet.n0580;

public class OutOfBoundaryPaths {
    int mod = 1000000007;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int findPaths(int m, int n, int N, int i, int j) {
        Integer[][][] dp = new Integer[m][n][N+1];
        return dfs(m,n,N,i,j, dp);
    }

    private int dfs(int m, int n, int steps, int i, int j, Integer[][][] dp) {
        if(i<0 || i>=m || j<0 || j>=n){
            return 1;
        }
        if(steps == 0){
            return 0;
        }
        if(dp[i][j][steps] != null){
            return dp[i][j][steps];
        }
        int sum = 0;
        for(int[] direc : directions){
            sum+= dfs(m,n,steps-1, i+direc[0], j+direc[1], dp);
            sum%=mod;
        }
        sum%=mod;
        dp[i][j][steps] = sum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().findPaths(2,2,2,0,0));
        System.out.println(new OutOfBoundaryPaths().findPaths(1,3,3,0,1));
    }
}
