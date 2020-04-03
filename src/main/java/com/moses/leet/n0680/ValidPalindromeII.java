package com.moses.leet.n0680;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(isPalindrome(s)){
            return true;
        }
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindrome(s.substring(l+1, r+1)) || isPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }
        return false;
    }

    private boolean isPalindrome(String sb) {
        int l = 0, r = sb.length()-1;
        boolean flag = true;
        while(l<r){
            if(sb.charAt(l) != sb.charAt(r)){
                flag = false;
                break;
            }
            l++;
            r--;
        }
        return flag;
    }
}
