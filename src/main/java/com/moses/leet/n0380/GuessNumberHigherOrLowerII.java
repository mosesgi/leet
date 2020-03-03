package com.moses.leet.n0380;

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return sum(1, n, dp);
    }

    private int sum(int left, int right, int[][] dp){
        if(right<=left){
            return 0;
        }
        if(dp[left][right] != 0){
            return dp[left][right];
        }
        int min = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            int l = sum(left, i-1, dp);
            int r = sum(i+1, right, dp);
            int tmp = Math.max(l+i, r+i);
            if(tmp < min){
                min = tmp;
            }
        }
        dp[left][right] = min;
        return min;
    }

    public static void main(String[] args) {
//        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(10));
//        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(11));
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(12));        //21
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(13));        //24
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(14));        //27
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(15));        //30
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(16));        //34
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(17));        //34
        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(20));        //49
//        System.out.println(new GuessNumberHigherOrLowerII().getMoneyAmount(23));
    }
}
