package com.moses.leet.n0480;

import java.util.Arrays;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        Integer[][][] dp = new Integer[strs.length][m+1][n+1];
        return dfs(strs, m, n, 0, dp);
    }

    int dfs(String[] strs, int m, int n, int idx, Integer[][][] dp){
        int len = strs.length;
        if(idx >= len || (m==0 && n== 0)){
            return 0;
        }
        if(dp[idx][m][n] != null){
            return dp[idx][m][n];
        }
        int notChoose = dfs(strs, m, n, idx+1, dp);
        int[] cur = count(strs[idx]);
        int choose = 0;
        if(m>=cur[0] && n>=cur[1]) {
            choose = 1 + dfs(strs, m - cur[0], n - cur[1], idx + 1, dp);
        }
        dp[idx][m][n] = Math.max(notChoose, choose);
        return dp[idx][m][n];
    }

    int[] count(String s){
        int zs = 0;
        int os = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '0'){
                zs++;
            } else if(c == '1'){
                os++;
            }
        }
        return new int[]{zs, os};
    }

    public static void main(String[] args) {
        String[] strs;
        int m, n;

        strs = new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
        m=90;
        n=66;
        System.out.println(new OnesAndZeroes().findMaxForm(strs, m, n));

        strs = new String[]{"10","0001","111001","1","0"};
        m=5; n=4;
        System.out.println(new OnesAndZeroes().findMaxForm(strs, m, n));

        strs = new String[]{"111","1000","1000","1000"};
        m=9; n=3;
        System.out.println(new OnesAndZeroes().findMaxForm(strs, m, n));
    }
}
