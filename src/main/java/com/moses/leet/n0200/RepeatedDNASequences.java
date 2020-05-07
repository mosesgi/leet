package com.moses.leet.n0200;

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10){
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, 10));
        Map<String, Integer> map = new HashMap<>();
        map.put(sb.toString(), 1);
        List<String> res = new ArrayList<>();
        for(int i=1; i<s.length()-9; i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i+9));
            String tmp = sb.toString();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if(map.get(tmp) == 2){
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s;

        s = "AAAAAAAAAAA";
        System.out.println(Arrays.toString(new RepeatedDNASequences().findRepeatedDnaSequences(s).toArray()));

        s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(Arrays.toString(new RepeatedDNASequences().findRepeatedDnaSequences(s).toArray()));
    }


    public List<String> findRepeatedDnaSequencesOld(String s) {
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


}
