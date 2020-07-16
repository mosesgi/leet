package com.moses.leet.lcci;

public class CoinsLCCI {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] dp = new int[n+1];
        int[] coins = new int[]{1,5,10,25};
        dp[0] = 1;
        for(int c : coins){
            for(int i=c; i<=n; i++){
                dp[i] += dp[i-c];
                dp[i] %= mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CoinsLCCI().waysToChange(10));
    }
}
