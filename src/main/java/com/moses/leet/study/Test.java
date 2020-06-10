package com.moses.leet.study;

import java.util.*;

public class Test {

    Map<Integer, Boolean> mem = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger * (maxChoosableInteger+1)/2 < desiredTotal){
            return false;
        }
        boolean[] used = new boolean[maxChoosableInteger+1];
        return back(maxChoosableInteger, used, 0, desiredTotal);
    }

    private boolean back(int maxChoosableInteger, boolean[] used, int sum, int desiredTotal) {
        int key = compress(used);
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        for(int i=maxChoosableInteger; i>=1; i--){
            if(used[i]){
                continue;
            }
            if(sum+i >= desiredTotal){
                mem.put(key, true);
                return true;
            }else{
                break;
            }
        }

        for(int i=1; i<=maxChoosableInteger; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            if(!back(maxChoosableInteger, used, sum+i, desiredTotal)){
                used[i] = false;
                mem.put(key, true);
                return true;
            }
            used[i] = false;
        }
        mem.put(key, false);
        return false;
    }

    int compress(boolean[] used){
        int res = 0;
        int mask = 1;
        for(int i=used.length-1; i>=0; i--){
            if(used[i]) {
                res |= (mask << used.length - 1 - i);
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
