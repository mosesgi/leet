package com.moses.leet.n0840;

import java.util.Arrays;

public class New21Game {
    public double new21Game(int N, int K, int W) {
        if(K==0){
            return 1;
        }
        double[] dp = new double[K+W+1];
        dp[0] = 1d;
        double base = 1d/W;
        for(int i=0; i<K; i++){
            for(int j=1; j<=W; j++){
                dp[i+j] += dp[i] * base;
            }
        }

        double all = 0, lessN = 0;
        for(int i=1; i<dp.length; i++){
            if(i>=K){
                all+=dp[i];
            }
            if(i>=K && i <= N){
                lessN += dp[i];
            }
        }
        return lessN/all;
    }

    public static void main(String[] args) {
        System.out.println(new New21Game().new21Game(10,1,10));
        System.out.println(new New21Game().new21Game(21,17,10));
    }
}
