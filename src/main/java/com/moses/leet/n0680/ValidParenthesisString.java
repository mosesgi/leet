package com.moses.leet.n0680;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()+1][s.length()+1];
        return dfs(s, 0, 0, dp);
    }

    private boolean dfs(String s, int i, int sum, Boolean[][] dp) {
        if(sum < 0){
            return false;
        }
        if(i==s.length()){
            return sum==0;
        }
        if(dp[i][sum] != null){
            return dp[i][sum];
        }
        char c = s.charAt(i);
        if(c == '('){
            dp[i][sum] = dfs(s, i+1, sum+1, dp);
        }else if(c == ')'){
            dp[i][sum] = dfs(s, i+1, sum-1, dp);
        }else {
            dp[i][sum] = dfs(s, i+1, sum, dp) || dfs(s, i+1, sum+1, dp) || dfs(s, i+1, sum-1, dp);
        }
        return dp[i][sum];
    }
}
