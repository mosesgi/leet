package com.moses.leet.n0920;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bCnt = new int[26];
        for(String s : B){
            int[] cnts = new int[26];
            for(char c : s.toCharArray()){
                cnts[c-'a']++;
            }
            for(int i=0; i<26; i++){
                bCnt[i] = Math.max(bCnt[i], cnts[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for(String s : A){
            int[] cnts = new int[26];
            for(char c : s.toCharArray()){
                cnts[c-'a']++;
            }
            boolean pass = true;
            for(int i=0; i<26; i++){
                if(cnts[i] < bCnt[i]){
                    pass = false;
                    break;
                }
            }
            if(pass){
                res.add(s);
            }
        }
        return res;
    }
}
