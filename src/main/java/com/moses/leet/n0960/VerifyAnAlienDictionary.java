package com.moses.leet.n0960;

public class VerifyAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] pos = new int[26];
        for(int i = 0; i<order.length(); i++){
            pos[order.charAt(i)-'a'] = i;
        }
        for(int i=1; i<words.length; i++){
            if(!compare(words[i-1], words[i], pos)){
                return false;
            }
        }
        return true;
    }

    boolean compare(String a, String b, int[] pos){
        int len = Math.max(a.length(), b.length());
        for(int i=0; i<len; i++){
            if(i==a.length()){
                return true;
            }else if(i==b.length()){
                return false;
            }
            char x = a.charAt(i);
            char y = b.charAt(i);
            if(pos[x-'a'] < pos[y-'a']){
                return true;
            }else if(pos[x-'a'] > pos[y-'a']){
                return false;
            }
        }
        return true;
    }
}
