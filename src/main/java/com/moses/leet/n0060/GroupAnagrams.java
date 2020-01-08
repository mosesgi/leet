package com.moses.leet.n0060;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(result.get(key) == null){
                List<String> l = new ArrayList<>();
                l.add(s);
                result.put(key, l);
            } else {
                result.get(key).add(s);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:result.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new GroupAnagrams().groupAnagrams(strs);
        for(List<String> row:list){
            System.out.println(Arrays.toString(row.toArray()));
        }
        System.out.println();
    }
}
