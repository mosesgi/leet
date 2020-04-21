package com.moses.leet.n0820;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : cpdomains){
            String[] parts = s.split(" ");
            int num = Integer.parseInt(parts[0]);
            String[] strs = parts[1].split("\\.");
            String prev="";
            for(int i=strs.length-1; i>=0; i--){
                if(prev.length() == 0){
                    prev = strs[i];
                }else{
                    prev = strs[i] +"." + prev;
                }
                map.put(prev, map.getOrDefault(prev, 0) + num);
            }
        }
        List<String> res = new ArrayList<>();
        for(String k : map.keySet()){
            res.add(map.get(k) + " " + k);
        }
        return res;
    }
}
