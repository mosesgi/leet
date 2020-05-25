package com.moses.leet.n0340;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while(r<s.length() && l <= r){
            cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            r++;
            while(cnt.size() > k){
                cnt.put(s.charAt(l), cnt.get(s.charAt(l)) -1);
                if(cnt.get(s.charAt(l)) == 0){
                    cnt.remove(s.charAt(l));
                }
                l++;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtMostKDistinctChars().lengthOfLongestSubstringKDistinct("aa", 2));
    }
}
