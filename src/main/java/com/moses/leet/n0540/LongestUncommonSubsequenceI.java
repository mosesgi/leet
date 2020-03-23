package com.moses.leet.n0540;

public class LongestUncommonSubsequenceI {
    //abadefgh
    //defgh
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
