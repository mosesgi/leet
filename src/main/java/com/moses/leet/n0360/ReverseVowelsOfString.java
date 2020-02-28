package com.moses.leet.n0360;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        if(s.length() == 0){
            return s;
        }
        char[] ary = s.toCharArray();
        int left = 0;
        int right = ary.length-1;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        while(left < right){
            while(left < s.length() && !vowels.contains(ary[left])){
                left++;
            }
            while(right >=0 && !vowels.contains(ary[right])){
                right--;
            }
            if(left >=right){
                break;
            } else {
                char tmp = ary[left];
                ary[left] = ary[right];
                ary[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(ary);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
    }
}
