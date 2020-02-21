package com.moses.leet.n0300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i])){
                    return false;
                }
            } else {
                map.put(c, words[i]);
            }

            if(sMap.containsKey(words[i])){
                if (!sMap.get(words[i]).equals(c)) {
                    return false;
                }
            }else{
                sMap.put(words[i], c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern, str;
        pattern = "abba";
        str = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));

        pattern = "abba";
        str = "dog cat cat fish";
        System.out.println(new WordPattern().wordPattern(pattern, str));

        pattern = "abba";
        str = "dog dog dog dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}
