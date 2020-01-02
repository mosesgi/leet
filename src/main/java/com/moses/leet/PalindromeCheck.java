package com.moses.leet;

import java.util.Stack;

public class PalindromeCheck {

    public boolean isPalindrome(int x){
        String s = String.valueOf(x);
        int count = 0;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)== s.charAt(s.length()-i-1)){
                count++;
            } else {
                return false;
            }
        }
        return count == s.length()/2;
    }

    public boolean isPalindromeWithoutString(int x){
        if(x<0 || x%10 == 0 && x!=0){
            return false;
        }

        //reverse right half of the digits and compare with the left side.
        int reversedNum = 0;
        while(x>reversedNum){
            reversedNum = reversedNum*10 + x%10;
            x = x/10;
        }

        //in case of odd numbers, simply git rid of the middle number.
        return x == reversedNum || x==reversedNum/10;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeCheck().isPalindrome(121));
        System.out.println(new PalindromeCheck().isPalindrome(-121));
        System.out.println(new PalindromeCheck().isPalindrome(10));
        System.out.println(new PalindromeCheck().isPalindrome(53235));

    }
}
