package com.moses.leet.n0300;

import java.util.*;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        List<Character> sList = new LinkedList<>();
        Map<Character, Integer> gMap = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            } else {
                sList.add(s);
                if(gMap.containsKey(g)){
                    gMap.put(g, gMap.get(g)+1);
                }else{
                    gMap.put(g, 1);
                }
            }
        }

        int cows = 0;
        for(Character c : sList){
            if(gMap.containsKey(c) && gMap.get(c) >=1){
                cows++;
                gMap.put(c, gMap.get(c)-1);
            }
        }

        return bulls+"A" + cows +"B";
    }
}
