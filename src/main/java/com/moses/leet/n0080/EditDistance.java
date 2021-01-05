package com.moses.leet.n0080;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/edit-distance/
 * 完全没头绪
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=n; j++){
            dp[0][j] = j;
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    //from solution. DP
    public int minDistance1(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1; i<=word1.length(); i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=word2.length(); j++){
            dp[0][j] =j;
        }
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


}
