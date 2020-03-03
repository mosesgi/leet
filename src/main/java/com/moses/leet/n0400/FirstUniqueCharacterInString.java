package com.moses.leet.n0400;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        if(s== null || s.length()==0){
            return -1;
        }
        int[] stat = new int[26];
        for(char c : s.toCharArray()){
            int ind = c-'a';
            stat[ind]++;
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int ind = c-'a';
            if(stat[ind] == 1){
                return i;
            }
        }
        return -1;
    }
}
