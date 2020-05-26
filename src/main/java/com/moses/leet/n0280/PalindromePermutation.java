package com.moses.leet.n0280;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for(char c : s.toCharArray()){
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        int odds = 0;
        for(char i : cnt.keySet()){
            if(cnt.get(i)%2 == 1){
                odds++;
            }
        }
        return odds<=1;
    }
}
