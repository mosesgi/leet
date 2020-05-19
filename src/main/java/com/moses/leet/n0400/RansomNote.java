package com.moses.leet.n0400;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rs = new int[26];
        int[] ms = new int[26];
        for(char c : ransomNote.toCharArray()){
            rs[c-'a']++;
        }
        for(char c : magazine.toCharArray()){
            ms[c-'a']++;
        }

        for(int i=0; i<26; i++){
            if(ms[i] < rs[i]){
                return false;
            }
        }
        return true;
    }

    public boolean canConstructOld(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            if(map.get(c) <=0){
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
