package com.moses.leet.n0520;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    //abceiswoustqcba
    //swenoiahtbnslwj
    public int longestPalindromeSubseq(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return recursive(s, 0, s.length()-1, dp);
    }

    private int recursive(String s, int left, int right, Integer[][] dp){
        if(left == right){
            return 1;
        }else if(left>right){
            return 0;
        }
        if(dp[left][right] != null){
            return dp[left][right];
        }
        char lc = s.charAt(left);
        char rc = s.charAt(right);
        if(lc == rc){
            int next = 2+recursive(s, left+1, right-1, dp);
            dp[left][right] = next;
            return next;
        }else {
            int leftCnt = recursive(s, left+1, right, dp);
            int rightCnt = recursive(s, left, right-1, dp);
            dp[left][right] = Math.max(leftCnt, rightCnt);
            return dp[left][right];
        }
    }

    public static void main(String[] args) {
        String s;

        s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(s));

        s = "aabaa";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(s));

        s = "a";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(s));

        s = "bbbab";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(s));

        s = "cbbd";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(s));
    }

}
