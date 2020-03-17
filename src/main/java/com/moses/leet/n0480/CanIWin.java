package com.moses.leet.n0480;

import java.util.*;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal){
        if(desiredTotal <=maxChoosableInteger){
            return true;
        }
        if((1+maxChoosableInteger) * maxChoosableInteger /2 < desiredTotal){
            return false;
        }
        int visited = 0;
        Map<Integer, Boolean> dp = new HashMap<>();
        return canWin(visited, maxChoosableInteger, desiredTotal, dp);
    }

    private boolean canWin(int visited, int maxChooseableInteger, int desiredTotal, Map<Integer, Boolean> dp) {
        int key = visited;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        for(int i=maxChooseableInteger; i>=1; i--){
            int curr = 1<<(i-1);
            if((visited | curr) == visited){
                continue;
            }
            if(i>=desiredTotal){
                dp.put(key, true);
                return true;
            }
            visited |= curr;
            boolean next = canWin(visited, maxChooseableInteger, desiredTotal-i, dp);
            if(!next){
                visited ^= curr;
                dp.put(key, true);
                return true;
            }
            visited ^= curr;
        }
        dp.put(key, false);
        return false;
    }


    //TLE
    public boolean canIWinBruteForce(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <=maxChoosableInteger){
            return true;
        }
        if((1+maxChoosableInteger) * maxChoosableInteger /2 < desiredTotal){
            return false;
        }
        Set<Integer> used = new HashSet<>();
        return recursive(maxChoosableInteger, desiredTotal, used);
    }

    private boolean recursive(int maxChoosableInteger, int desiredTotal, Set<Integer> used) {
        for(int i=maxChoosableInteger; i>=1; i--){
            if(used.contains(i)){
                continue;
            }
            if(i>=desiredTotal){
                return true;
            }
            used.add(i);
            boolean rst = recursive(maxChoosableInteger, desiredTotal-i, used);
            if(!rst){
                used.remove(i);         //NEVER FORGET TO REMOVE!!!!!! EVEN YOU THINK IT'S UNNECESSARY!!!!
                return true;
            }
            used.remove(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanIWin().canIWin(5,50));
        System.out.println(new CanIWin().canIWin(4,6));
        System.out.println(new CanIWin().canIWin(10,40));
        System.out.println(new CanIWin().canIWin(10,11));
    }
}
