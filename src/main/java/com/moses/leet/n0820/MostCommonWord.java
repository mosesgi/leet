package com.moses.leet.n0820;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for(String s : banned){
            ban.add(s.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<paragraph.length(); i++){
            char ch = paragraph.charAt(i);
            if(ch == ' ' || ch == '!' || ch == '?' || ch == '\'' || ch == ',' || ch == ';' || ch == '.'){
                if(sb.length() > 0){
                    String tmp = sb.toString();
                    if(!ban.contains(tmp)){
                        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                    }
                    sb.setLength(0);
                }
            }else{
                sb.append(Character.toLowerCase(ch));
            }
        }
        if(sb.length() > 0){
            String tmp = sb.toString();
            if(!ban.contains(tmp)){
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            sb.setLength(0);
        }

        int max = 0;
        String res = "";
        for(String key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}
