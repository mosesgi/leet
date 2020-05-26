package com.moses.leet.n1160;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        if(text1.charAt(0) == text2.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i=1; i<text1.length(); i++){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int j=1; j<text2.length(); j++){
            if(text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<text1.length(); i++){
            for(int j=1; j<text2.length(); j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];

    }

    public static void main(String[] args) {
        String t1, t2;
        t1 = "abcde";
        t2 = "ace";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(t1, t2));
    }

    public int longestCommonSubsequenceBacktrack(String text1, String text2) {
        Integer[][] mem = new Integer[text1.length()][text2.length()];
        return backtrack(text1, text2, 0, 0, mem);
    }

    int backtrack(String t1, String t2, int p1, int p2, Integer[][] mem){
        if(p1 == t1.length() || p2 == t2.length()){
            return 0;
        }
        if(mem[p1][p2] != null){
            return mem[p1][p2];
        }
        char c1 = t1.charAt(p1);
        char c2 = t2.charAt(p2);
        if(c1 == c2){
            mem[p1][p2] =  1+backtrack(t1, t2, p1+1, p2+1, mem);
        }else{
            int a = backtrack(t1, t2, p1+1, p2, mem);
            int b = backtrack(t1, t2, p1, p2+1, mem);
            int c = backtrack(t1, t2, p1+1, p2+1, mem);
            mem[p1][p2] = Math.max(Math.max(a, b), c);
        }
        return mem[p1][p2];
    }
}
