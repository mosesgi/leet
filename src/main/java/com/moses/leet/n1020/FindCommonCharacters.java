package com.moses.leet.n1020;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[] cnt = new int[26];
        boolean first = true;
        for(String s : A){
            int[] sCnt = new int[26];
            for(char c : s.toCharArray()){
                sCnt[c-'a']++;
            }

            for(int i=0; i<26; i++){
                if(first){
                    cnt[i] = sCnt[i];
                }else {
                    cnt[i] = Math.min(cnt[i], sCnt[i]);
                }
            }
            first = false;
        }

        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(cnt[i] > 0){
                for(int j=0; j<cnt[i]; j++){
                    res.add((char)(i+'a') +"");
                }
            }
        }
        return res;
    }
}
