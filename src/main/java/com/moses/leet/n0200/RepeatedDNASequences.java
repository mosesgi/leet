package com.moses.leet.n0200;

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<=s.length()-10; i++){
            String si = s.substring(i, i+10);
            if(map.containsKey(si)){
                map.put(si, map.get(si) + 1);
            } else {
                map.put(si, 1);
            }
        }

        Set<String> keys = map.keySet();
        List<String> list = new ArrayList<>();
        for(String key : keys){
            if(map.get(key) > 1){
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s;
        s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> rst = new RepeatedDNASequences().findRepeatedDnaSequences(s);
        System.out.println(Arrays.toString(rst.toArray()));
    }
}
