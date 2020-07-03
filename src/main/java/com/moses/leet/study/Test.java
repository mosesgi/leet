package com.moses.leet.study;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class Test {

    Map<Integer, Boolean> mem = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger * (maxChoosableInteger + 1) / 2) < desiredTotal) {
            return false;
        }
        return back(maxChoosableInteger, desiredTotal, 0, new boolean[maxChoosableInteger+1]);
    }

    boolean back(int maxChoosableInteger, int desiredTotal, int total, boolean[] used){
        int key = 0;
        for(int i=0; i<used.length; i++){
            if(used[i]) {
                key |= (1 << i);
            }
        }
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        for(int i=maxChoosableInteger; i>=1; i--){
            if(used[i]){
                continue;
            }
            if(total + i >= desiredTotal){
                mem.put(key, true);
                return true;
            }
        }

        for(int i=1; i<=maxChoosableInteger; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            if(!back(maxChoosableInteger, desiredTotal, total + i, used)){
                used[i] = false;
                mem.put(key, true);
                return true;
            }
            used[i] = false;
        }
        mem.put(key, false);
        return false;
    }




    public static void main(String[] args) {
        System.out.println(new Test().canIWin(4, 6));
        System.out.println(new Test().canIWin(10, 11));
        System.out.println(new Test().canIWin(15, 30));
    }
}
