package com.moses.leet.n0600;

import java.util.*;

public class DeleteOperationForTwoStrings {

    //USE DP!!!!!
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return word1.length()+word2.length()- 2*dp[word1.length()][word2.length()];
    }


    public int minDistanceRecursive(String word1, String word2) {
        //find longest common subsequence.
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        int same = dfs(word1, word2, 0, 0, dp);
        return word1.length()-same + word2.length()-same;
    }

    private int dfs(String word1, String word2, int p1, int p2, Integer[][] dp) {
        if(p1>=word1.length() || p2>=word2.length()){
            return 0;
        }
        if(dp[p1][p2] != null){
            return dp[p1][p2];
        }
        if(word1.charAt(p1) == word2.charAt(p2)){
            int tmp =  1 + dfs(word1, word2, p1+1, p2+1, dp);
            dp[p1][p2] = tmp;
            return tmp;
        }
        int a = 0, b=0;
        a = dfs(word1, word2, p1+1, p2, dp);
        b = dfs(word1, word2, p1, p2+1, dp);
        dp[p1][p2] = Math.max(a, b);
        return dp[p1][p2];
    }

    public static void main(String[] args) {
        String word1, word2;

        word1 = "dinitrophenylhydrazine";
        word2 = "acetylphenylhydrazine";
        System.out.println(new DeleteOperationForTwoStrings().minDistance(word1, word2));

        word1 = "spartan"; word2 = "part";
        System.out.println(new DeleteOperationForTwoStrings().minDistance(word1, word2));

        word1 = "fgasfasea"; word2 = "gtymnnbcxvvvcvcxeat";
        System.out.println(new DeleteOperationForTwoStrings().minDistance(word1, word2));

        word1 = "sea"; word2 = "eat";
        System.out.println(new DeleteOperationForTwoStrings().minDistance(word1, word2));
    }
}
