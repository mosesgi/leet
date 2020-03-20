package com.moses.leet.n0500;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";

        List<String> list = new ArrayList<>();
        outer: for(String s : words){
            char fc = s.charAt(0);
            String toUse;
            if(first.indexOf(fc) >= 0){
                toUse = first;
            }else if(second.indexOf(fc) >= 0){
                toUse = second;
            }else{
                toUse = third;
            }
            char[] ary = s.toCharArray();
            for(int i=1; i<ary.length; i++){
                if(toUse.indexOf(ary[i]) == -1){
                    continue outer;
                }
            }
            list.add(s);
        }
        return list.toArray(new String[0]);
    }
}
