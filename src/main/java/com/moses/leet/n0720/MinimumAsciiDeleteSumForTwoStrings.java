package com.moses.leet.n0720;

public class MinimumAsciiDeleteSumForTwoStrings {
    //Bottom-up DP
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1; i<=len2; i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        for(int i=1; i<=len1; i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j], s2.charAt(j-1)+dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }



    public int minimumDeleteSumTopBottom(String s1, String s2) {
        Integer[][] mem = new Integer[s1.length()+1][s2.length()+1];
        return rec(s1, s2, 0, 0, mem);
    }

    int rec(String s1, String s2, int i1, int i2, Integer[][] mem){
        if(i1==s1.length() && i2 == s2.length()){
            return 0;
        }else if(i1==s1.length()){
            int tmp=0;
            for(int i=i2; i<s2.length(); i++){
                tmp+=s2.charAt(i);
            }
            return tmp;
        }else if(i2==s2.length()){
            int tmp=0;
            for(int i=i1; i<s1.length(); i++){
                tmp+=s1.charAt(i);
            }
            return tmp;
        }
        if(mem[i1][i2] != null){
            return mem[i1][i2];
        }
        if(s1.charAt(i1) == s2.charAt(i2)){
            return rec(s1, s2, i1+1, i2+1, mem);
        }
        int a = s1.charAt(i1) + rec(s1, s2, i1+1, i2, mem);
        int b = s2.charAt(i2) + rec(s1, s2, i1, i2+1, mem);
        mem[i1][i2] = Math.min(a, b);
        return mem[i1][i2];
    }

    public static void main(String[] args) {
        String s1, s2;
        s1 = "sea";
        s2 = "eat";
        System.out.println(new MinimumAsciiDeleteSumForTwoStrings().minimumDeleteSum(s1, s2));

        s1 = "delete";
        s2 = "leet";
        System.out.println(new MinimumAsciiDeleteSumForTwoStrings().minimumDeleteSum(s1, s2));
    }
}
