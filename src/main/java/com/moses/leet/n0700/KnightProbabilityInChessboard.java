package com.moses.leet.n0700;

public class KnightProbabilityInChessboard {
    int[][] directions = new int[][]{
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}
    };

    public double knightProbability(int N, int K, int r, int c) {
        Double[][][] dp = new Double[N][N][K+1];
        return rec(N, K, r, c, dp);
    }

    private double rec(int N, int K, int r, int c, Double[][][] dp) {
        if(K==0){
            return 1;
        }
        if(dp[r][c][K] != null){
            return dp[r][c][K];
        }
        double pos = 0;
        for(int[] dir:directions){
            int x = r+dir[0];
            int y = c+dir[1];
            if(x>=0 && x<N && y >=0 && y<N){
                pos += rec(N, K-1, x, y, dp)/8d;
            }
        }
        dp[r][c][K] = pos;
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(new KnightProbabilityInChessboard().knightProbability(3,2,0,0));
        System.out.println(new KnightProbabilityInChessboard().knightProbability(8,30,6,4));
    }
}
