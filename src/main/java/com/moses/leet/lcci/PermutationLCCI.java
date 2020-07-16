package com.moses.leet.lcci;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/permutation-i-lcci/
public class PermutationLCCI {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] used = new boolean[chars.length];
        List<String> list = new ArrayList<>();
        dfs("", chars, used, list);
        return list.toArray(new String[0]);
    }

    void dfs(String s, char[] chars, boolean[] used, List<String> list){
        if(s.length()==chars.length){
            list.add(s);
            return;
        }
        for(int i= 0; i<chars.length; i++){
            if(!used[i]){
                used[i] = true;
                dfs(s+chars[i], chars, used, list);
                used[i] = false;
            }
        }
    }
}
