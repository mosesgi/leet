package com.moses.leet.lcci;

public class TranslateNumberToString {
    public int translateNum(int num) {
        String str = num+"";
        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=str.length(); i++){
            if(str.charAt(i-2) == '0'){
                dp[i] += dp[i-1];
            }else {
                if (Integer.parseInt(str.substring(i - 2, i)) < 26) {
                    dp[i] += dp[i - 2];
                }
                dp[i] += dp[i - 1];
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNumberToString().translateNum(506));
        System.out.println(new TranslateNumberToString().translateNum(25));
        System.out.println(new TranslateNumberToString().translateNum(12258));
    }
}
