package com.moses.leet.n1240;

import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueChars {
    public int maxLength(List<String> arr) {
        boolean[] exist = new boolean[26];
        return dfs("", 0, arr, exist);
    }

    int dfs(String str, int start, List<String> arr, boolean[] exist){
        if(start == arr.size()){
            return str.length();
        }
        String cur = arr.get(start);
        int add = 0;
        boolean canAdd = true;
        boolean[] check = new boolean[26];
        for(char c : cur.toCharArray()){
            if(check[c-'a']){
                canAdd = false;
                break;
            }else{
                check[c-'a'] = true;
            }
        }
        if(canAdd){
            for(char c : cur.toCharArray()){
                if(exist[c-'a']){
                    canAdd = false;
                    break;
                }
            }
        }
        if(canAdd){
            for(char c : cur.toCharArray()){
                exist[c-'a'] = true;
            }
            add = dfs(str+cur, start+1, arr, exist);
            for(char c : cur.toCharArray()){
                exist[c-'a'] = false;
            }
        }

        int notAdd = dfs(str, start+1, arr, exist);
        return Math.max(add, notAdd);
    }
}
