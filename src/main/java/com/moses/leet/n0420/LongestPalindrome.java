package com.moses.leet.n0420;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s== null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean left = false;
        int sum = 0;
        for(char c : map.keySet()){
            int curr = map.get(c);
            if(curr>1){
                if(curr%2== 0) {
                    sum += curr;
                }else{
                    sum += (curr-1);
                    if(!left){
                        left = true;
                    }
                }
            } else{
                if(!left){
                    left = true;
                }
            }
        }
        return left?sum+1:sum;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
}
