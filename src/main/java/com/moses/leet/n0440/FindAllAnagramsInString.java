package com.moses.leet.n0440;

import java.util.*;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s==null || s.length() == 0 || s.length()<p.length()){
            return list;
        }
        int[] cnts = new int[26];
        for(char c : p.toCharArray()){
            cnts[c-'a']++;
        }
        int pLen = p.length();


        int[] match = new int[26];
        for(int i=0; i<p.length(); i++){
            char c = s.charAt(i);
            match[c-'a']++;
        }
        boolean prevMatch = false;
        if(match(cnts, match)){
            list.add(0);
            prevMatch = true;
        }
        for(int i=0; i<s.length()-pLen; i++){
            char remove = s.charAt(i);
            char add = s.charAt(pLen + i);
            if(prevMatch && add == remove){
                list.add(i+1);
                continue;
            }
            match[remove-'a']--;
            match[add-'a']++;
            if(match(cnts, match)){
                list.add(i+1);
                prevMatch = true;
            }else{
                prevMatch = false;
            }
        }
        return list;
    }

    private boolean match(int[] origin, int[] match){
        for(int i=0; i<origin.length; i++){
            if(origin[i] != match[i]){
                return false;
            }
        }
        return true;
    }
}
