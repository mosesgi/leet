package com.moses.leet.n0900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] as = A.split(" ");
        String[] bs = B.split(" ");
        for(String s : as){
            if(s.length() > 0){
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        for(String s : bs){
            if(s.length() > 0){
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<String> l = new ArrayList<>();
        for(String a : map.keySet()){
            if(map.get(a) == 1){
                l.add(a);
            }
        }
        return l.toArray(new String[0]);
    }
}
