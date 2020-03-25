package com.moses.leet.n0540;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordInDictThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (o1, o2) -> {return o1.length()!=o2.length()?o2.length()-o1.length():o1.compareTo(o2);});
        for(String str : d){
            if(s.length() < str.length()){
                continue;
            }
            int strPos = 0;
            for(int sPos = 0; sPos<s.length(); sPos++){
                char sChar = s.charAt(sPos);
                char strChar = str.charAt(strPos);
                if(sChar == strChar){
                    strPos++;
                    if(strPos == str.length()){
                        return str;
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s;
        List<String> d;
        s = "abpcplea";
        d = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(new LongestWordInDictThroughDeleting().findLongestWord(s,d));
    }
}
