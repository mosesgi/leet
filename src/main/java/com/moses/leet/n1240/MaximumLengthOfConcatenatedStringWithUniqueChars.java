package com.moses.leet.n1240;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueChars {
    int result = 0;
    public int maxLength(List<String> arr) {
        arr = filter(arr);
        backtrack(arr, 0, "", new int[26]);
        return result;
    }

    void backtrack(List<String> arr, int start, String str, int[] stat){
        if(start == arr.size()){
            return;
        }
        for(int i=start; i<arr.size(); i++){
            if(!fulfill(stat, arr.get(i))){
                continue;
            }
            String tmp = str + arr.get(i);
            result = Math.max(result, tmp.length());
            backtrack(arr, i+1, tmp, stat);
            for(char c : arr.get(i).toCharArray()){
                stat[c-'a']--;
            }
        }
    }

    boolean fulfill(int[] stat, String str){
        int[] statNew = new int[26];
        for(int i=0; i<stat.length; i++){
            statNew[i] = stat[i];
        }

        for(char c : str.toCharArray()){
            if(++statNew[c-'a'] > 1){
                return false;
            }
        }
        for(int i=0; i<stat.length; i++){
            stat[i] = statNew[i];
        }
        return true;
    }

    List<String> filter(List<String> arr){
        List<String> list = new ArrayList<>();
        outer: for(String str : arr){
            int[] cnt = new int[26];
            for(char c : str.toCharArray()){
                cnt[c-'a']++;
                if(cnt[c-'a'] > 1){
                    continue outer;
                }
            }
            list.add(str);
            result = Math.max(result, str.length());
        }
        return list;
    }


    public int maxLengthOld(List<String> arr) {
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
