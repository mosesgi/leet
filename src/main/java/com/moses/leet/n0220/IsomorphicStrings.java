package com.moses.leet.n0220;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t){
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ca = s.charAt(i);
            char ct = t.charAt(i);
            if(sToT.containsKey(ca)){
                if(sToT.get(ca)!=ct){
                    return false;
                }
            } else {
                sToT.put(ca, ct);
            }

            if(tToS.containsKey(ct)){
                if(tToS.get(ct) != ca){
                    return false;
                }
            } else {
                tToS.put(ct, ca);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
    }
}
