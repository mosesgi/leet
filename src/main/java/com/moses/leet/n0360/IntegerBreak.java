package com.moses.leet.n0360;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i/2; j++){
//                dp[i] = Math.max(Math.max(dp[i], dp[i-j] * j), (i-j)*j);
                dp[i] = Math.max(dp[i], Math.max(dp[i-j], i-j) * Math.max(dp[j], j));
            }
        }
        return dp[n];
    }

    public int integerBreakOld(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            recursive(i, dp);
        }
        return dp[n];
    }

    private int recursive(int n, int[] dp) {
        if(dp[n] != 0){
            return dp[n];
        }
        int max = n-1;
        for(int i=1; i<n; i++){
            if(i*(n-i) > max){
                max = i*(n-i);
            }
            int tmp = i * recursive(n-i, dp);
            if(tmp > max){
                max = tmp;
            }
        }
        dp[n] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
        System.out.println(new IntegerBreak().integerBreak(10));
        System.out.println(new IntegerBreak().integerBreak(58));
    }
}
