package com.moses.leet.n0680;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return valid1(s.toCharArray());
    }

    boolean valid1(char[] chars){
        int left = 0, right = chars.length-1;
        while(left < right){
            if(chars[left] == chars[right]){
                left++;
                right--;
            }else{
                return valid2(chars, left+1, right) || valid2(chars, left, right-1);
            }
        }
        return true;
    }

    boolean valid2(char[] chars, int left, int right){
        while(left<right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public boolean validPalindrome1(String s) {
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
