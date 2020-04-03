package com.moses.leet.n0700;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Integer[] dp = new Integer[ops.length];
        int sum = 0;
        for(int i=0; i<ops.length; i++){
            if(ops[i].equals("C")){
                int prev = findPrevValid(i, dp);
                sum-=dp[prev];
                dp[prev] = null;
            }else if(ops[i].equals("D")){
                int prev = findPrevValid(i, dp);
                dp[i] = 2*dp[prev];
                sum+=dp[i];
            }else if(ops[i].equals("+")){
                int p1 = findPrevValid(i, dp);
                int p2 = findPrevValid(p1, dp);
                dp[i] = dp[p1] + dp[p2];
                sum+=dp[i];
            }else{
                dp[i] = Integer.parseInt(ops[i]);
                sum += dp[i];
            }
        }
        return sum;
    }

    public int findPrevValid(int i, Integer[] dp){
        while(i>0){
            if(dp[i-1] == null){
                i--;
                continue;
            }
            return i-1;
        }
        return -1;
    }
}
