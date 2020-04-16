package com.moses.leet.n0780;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for(char c : J.toCharArray()){
            jewels.add(c);
        }
        int cnt = 0;
        for(char c : S.toCharArray()){
            if(jewels.contains(c)){
                cnt++;
            }
        }
        return cnt;
    }
}
