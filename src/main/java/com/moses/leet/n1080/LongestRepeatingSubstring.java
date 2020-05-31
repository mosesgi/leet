package com.moses.leet.n1080;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        int len = S.length()-1;
        while(len >0){
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<S.length()-len+1; i++){
                String sub = S.substring(i, i+len);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if(map.get(sub) > 1){
                    return len;
                }
            }
            len--;
        }
        return 0;
    }
}
