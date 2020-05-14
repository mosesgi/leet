package com.moses.leet.n0300;

import java.util.HashMap;
import java.util.Map;

public class NimGame {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean canWinNim(int n) {
        return n%4==0;
    }

    private boolean canWin(int left, int level) {
        if(left <=3){
            if(level%2==1) {
                return true;
            }else {
                return false;
            }
        }
        String key = left + "_" + level;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        boolean w1 = canWin(left-1, level+1);
        if(level%2==1 && w1){
            cache.put(key, true);
            return true;
        }
        boolean w2 = canWin(left-2, level+1);
        if(level%2==1 && w2){
            cache.put(key, true);
            return true;
        }
        boolean w3 = canWin(left-3, level+1);
        if(level%2==1 && w3){
            cache.put(key, true);
            return true;
        }
        if(level%2==0){
            if(w1&&w2&&w3){
                cache.put(key, true);
                return true;
            }else {
                cache.put(key, false);
                return false;
            }
        }else {
            cache.put(key, false);
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NimGame().canWinNim(35));
        System.out.println(new NimGame().canWinNim(9));
        System.out.println(new NimGame().canWinNim(8));
        System.out.println(new NimGame().canWinNim(5));
        System.out.println(new NimGame().canWinNim(4));
    }
}
