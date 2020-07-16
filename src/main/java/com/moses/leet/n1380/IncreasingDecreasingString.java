package com.moses.leet.n1380;


public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            cnt[c-'a']++;
        }
        char[] res = new char[s.length()];
        int p = 0;
        while(p<res.length){
            for(int i=0; i<cnt.length && p<res.length; i++){
                if(cnt[i]>0){
                    res[p++] = (char)(i+'a');
                    cnt[i]--;
                }
            }

            for(int i=cnt.length-1; i>=0 && p<res.length; i--){
                if(cnt[i]>0){
                    res[p++] = (char)(i+'a');
                    cnt[i]--;
                }
            }
        }
        return new String(res);
    }
}
