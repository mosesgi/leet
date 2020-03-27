package com.moses.leet.n0620;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : paths){
            String[] strs = s.split(" ");
            String path = strs[0] +"/";
            for(int i=1; i<strs.length; i++){
                int first = strs[i].indexOf("(");
                String fileName = strs[i].substring(0, first);
//                int second = strs[i].indexOf(")", first);
                String content = strs[i].substring(first+1);
                if(map.containsKey(content)){
                    map.get(content).add(path+fileName);
                }else{
                    List<String> l = new ArrayList<>();
                    l.add(path+fileName);
                    map.put(content, l);
                }
            }
        }

        List<List<String>> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).size()>=2){
                list.add(map.get(key));
            }
        }
        return list;
    }
}
