package com.moses.leet.n0140;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int l=0, r = s.length()-1;
        while(l<r){
            char left = s.charAt(l);
            char right = s.charAt(r);
            if(!Character.isLetterOrDigit(left)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(right)){
                r--;
                continue;
            }
            if(Character.toLowerCase(left) != Character.toLowerCase(right)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome("abccba"));
        System.out.println(new ValidPalindrome().isPalindrome("abcdcba"));
        System.out.println(new ValidPalindrome().isPalindrome("0PP0"));
    }

    public boolean isPalindromeOld(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                if(Character.isAlphabetic(c) && Character.isUpperCase(c)){
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
        }
        s = sb.toString();
        if(s.length()==0 || s.length() == 1){
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l!=r){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
