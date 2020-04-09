package com.moses.leet.n0720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        Arrays.sort(words, (o1, o2) -> {return o1.length() == o2.length()?o1.compareTo(o2):o2.length()-o1.length();});
        String rst = "";
        outer: for(String s : words){
            for(int i=1; i<=s.length(); i++){
                if(!set.contains(s.substring(0, i))){
                    continue outer;
                }
            }
            return s;
        }
        return rst;
    }
}
