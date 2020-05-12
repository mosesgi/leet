package com.moses.leet.n0260;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] cnts = new int[26];
        for(char c : s.toCharArray()){
            cnts[c-'a']++;
        }

        for(char c : t.toCharArray()){
            cnts[c-'a']--;
            if(cnts[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramOld(String s, String t) {
        if(s.length() != t.length()){
            return false;
        } else if(s.length() == 0){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.compute(c, (k, v) ->{
                return v==null? 1: v+1;
            });
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            map.compute(c, (k, v) ->{
                return v-1==0?null:v-1;
            });
        }

        return map.isEmpty();
    }


}
