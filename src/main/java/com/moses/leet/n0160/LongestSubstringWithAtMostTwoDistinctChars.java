package com.moses.leet.n0160;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int slow = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while(cnt.size() > 2){
                char remove = s.charAt(slow++);
                cnt.put(remove, cnt.get(remove) - 1);
                if(cnt.get(remove) == 0){
                    cnt.remove(remove);
                }
            }
            res = Math.max(res, i-slow+1);
        }
        return res;
    }
}
