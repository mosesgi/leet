package com.moses.leet.n0520;

public class FibonacciNumber {
    public int fibRec(int N) {
        if(N==0 || N==1){
            return N;
        }
        return fib(N-1)+fib(N-2);
    }

    public int fib(int N) {
        if(N==0 || N==1){
            return N;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[N];
    }
}
