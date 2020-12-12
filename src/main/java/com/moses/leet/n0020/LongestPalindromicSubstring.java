package com.moses.leet.n0020;

/**
 * 回文字符串, 中心对称
 */
public class LongestPalindromicSubstring {

    int resL = 0, resR = 0;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            expand(s, i, i);
            expand(s,i,i+1);
        }
        return s.substring(resL, resR+1);
    }

    void expand(String s, int left, int right){
        if(left < 0 || right >= s.length()){
            return;
        }
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(right - left - 1 > resR - resL + 1){
            resR = right-1;
            resL = left+1;
        }
    }

    //expand from center.
    public String longestPalindrome1(String s) {
        int resLeft=0, resRight = 0;
        for(int i=0; i<s.length(); i++){
            int len = resRight - resLeft;
            if(len==0){
                resLeft = 0;
                resRight = i+1;
            }
            int left = i-1;
            int right = i+1;
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > len){
                    resLeft = left;
                    resRight = right+1;
                }
                left--;
                right++;
            }
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                if(len < 2){
                    resLeft = i;
                    resRight = i+2;
                }
                left = i-1;
                right = i+2;
                while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    if(right-left+1 > len){
                        resLeft = left;
                        resRight = right+1;
                    }
                    left--;
                    right++;
                }
            }
        }
        return s.substring(resLeft, resRight);
    }


    public String longestPalindromeInitial(String s) {
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
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));

        test="abacab";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));

        test = "babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));

        test = "abbc";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));

        test = "a";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));

        test = "ccc";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(test));
    }
}
