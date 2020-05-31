package com.moses.leet.n1140;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr1){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int i=0;
        int[] res = new int[arr1.length];
        for(int j : arr2){
            for(int k=0; k<map.get(j); k++){
                res[i++] = j;
            }
            map.remove(j);
        }
        List<Integer> rest = new ArrayList<>();
        if(!map.isEmpty()){
            for(int j : map.keySet()){
                for(int k=0; k<map.get(j); k++){
                    rest.add(j);
                }
            }
            Collections.sort(rest);
            for(int j : rest){
                res[i++] = j;
            }
        }
        return res;
    }
}
