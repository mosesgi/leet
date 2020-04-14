package com.moses.leet.n0760;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                char d = Character.toLowerCase(c);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }

        String str = null;
        outer: for(String s : words){
            Map<Character, Integer> map1 = new HashMap<>();
            for(char c : s.toCharArray()){
                if(Character.isLetter(c)){
                    char d = Character.toLowerCase(c);
                    map1.put(d, map1.getOrDefault(d, 0) + 1);
                }
            }
            for(Character c : map.keySet()){
                if(!map1.containsKey(c) || map1.get(c) < map.get(c)){
                    continue outer;
                }
            }
            if(str ==null){
                str = s;
            }else{
                if(s.length() < str.length()){
                    str = s;
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String p = "1s3 PSt";
        String[] words = new String[]{"step","steps","stripe","stepple"};
        System.out.println(new ShortestCompletingWord().shortestCompletingWord(p, words));
    }
}
