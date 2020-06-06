package com.moses.leet.lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestSupersequenceLCCI {
    public int[] shortestSeq(int[] big, int[] small) {
        int l=0, r =0;
        Map<Integer, Integer> sMap = new HashMap<>();
        for(int i : small){
            sMap.put(i, sMap.getOrDefault(i, 0) +1);
        }
        int start = -1, end = -1;
        Map<Integer, Integer> bMap = new HashMap<>();
        boolean qualifyFound = false;
        int matchSize = 0;
        while(r<big.length){
            bMap.put(big[r], bMap.getOrDefault(big[r], 0) + 1);
            r++;
            if(sMap.containsKey(big[r-1]) && bMap.get(big[r-1]) == sMap.get(big[r-1])) {
                matchSize++;
                if(matchSize == sMap.size()) {
                    qualifyFound = true;
                    break;
                }
            }
        }
        if(r==big.length && !qualifyFound){
            return new int[0];
        }
        start = 0;
        end = r-1;
        while(l<r){
            //shrink
            Integer shrink = null;
            while(l<r){
                bMap.put(big[l], bMap.get(big[l]) - 1);
                l++;
                if(sMap.containsKey(big[l-1]) && bMap.get(big[l-1]) < sMap.get(big[l-1])){
                    if(r-l < end-start){
                        start = l-1;
                        end = r-1;
                    }
                    shrink = big[l-1];
                    break;
                }
            }
            //expand
            boolean found = false;
            while(r<big.length){
                bMap.put(big[r], bMap.getOrDefault(big[r], 0) + 1);
                r++;
                if(big[r-1] == shrink){
                    found = true;
                    break;
                }
            }
            if(r == big.length && !found){
                break;
            }
        }
        return new int[]{start, end};
    }

//    boolean qualify(Map<Integer, Integer> sMap, Map<Integer, Integer> bMap){
//        for(int k : sMap.keySet()){
//            if(!bMap.containsKey(k) || bMap.get(k) < sMap.get(k)){
//                return false;
//            }
//        }
//        return true;
//    }


    public static void main(String[] args) {
        int[] big, small;
        big = new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        small = new int[]{1, 5, 9};
        System.out.println(Arrays.toString(new ShortestSupersequenceLCCI().shortestSeq(big, small)));
    }
}
