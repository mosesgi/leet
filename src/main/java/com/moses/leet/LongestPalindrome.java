package com.moses.leet;

import java.util.*;

/**
 * 回文字符串, 中心对称
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String substr = "";

        outer: for(int j=s.length(); j>0; j--){
            for(int i=0; i<s.length()-j+1; i++){
                String tmpStr = s.substring(i, i+j);
                int count = 0;
                for(int k = 0; k<=tmpStr.length()/2; k++){
                    if(tmpStr.charAt(k) == tmpStr.charAt(tmpStr.length()-k-1)){
                        count++;
                    } else {
                        break;
                    }
                    if(count == tmpStr.length()/2){
                        substr = tmpStr;
                        break outer;
                    }
                }
            }
        }
        if(substr.equals("")){
            substr = s.substring(0,1);
        }
        return substr;
    }

    public static void main(String[] args) {
        String test = "abadd";
        System.out.println(new LongestPalindrome().longestPalindrome(test));

        test="abacab";
        System.out.println(new LongestPalindrome().longestPalindrome(test));

        test = "babad";
        System.out.println(new LongestPalindrome().longestPalindrome(test));

        test = "abbc";
        System.out.println(new LongestPalindrome().longestPalindrome(test));

        test = "ac";
        System.out.println(new LongestPalindrome().longestPalindrome(test));

        test = "ccc";
        System.out.println(new LongestPalindrome().longestPalindrome(test));
    }
}
