package com.moses.leet.n0800;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int res=0;
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            map.putIfAbsent(c, new TreeSet<>());
            map.get(c).add(i);
        }

        outer: for(String s : words){
            Integer start = -1;
            for(char c : s.toCharArray()){
                if(!map.containsKey(c)){
                    continue outer;
                }
                start = map.get(c).higher(start);
                if(start == null){
                    continue outer;
                }
            }
            res++;
        }
        return res;
    }
}
