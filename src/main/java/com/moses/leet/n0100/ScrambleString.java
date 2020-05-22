package com.moses.leet.n0100;

/**
 * https://leetcode.com/problems/scramble-string/
 *
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int len = s1.length();
        int[] cnt = new int[256];
        for(int i=0; i<len; i++){
            cnt[s1.charAt(i)-'a']++;
            cnt[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<256; i++){
            if(cnt[i]!= 0){
                return false;
            }
        }
        if(s1.equals(s2)){
            return true;
        }
        for(int i=1; i<len; i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            if(isScramble(s1.substring(0, i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0, len-i))){
                return true;
            }
        }
        return false;
    }
}
