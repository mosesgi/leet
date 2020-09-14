package com.moses.leet.lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationIILCCI {
    public String[] permutation(String S) {
        List<String> res= new ArrayList<>();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        back(chars,  new boolean[S.length()], "", res);
        return res.toArray(new String[0]);
    }

    void back(char[] chars, boolean[] used, String cur, List<String> res){
        if(cur.length() == chars.length){
            res.add(cur);
            return;
        }
        for(int i=0; i<chars.length; i++){
            if(used[i] || i>0 && chars[i] == chars[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            back(chars, used, cur+chars[i], res);
            used[i] = false;
        }
    }


}
