package com.moses.leet.n0920;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int max = 0;
        int l=0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int r=0; r<tree.length; r++){
            cnt.put(tree[r], cnt.getOrDefault(tree[r], 0) + 1);
            if(cnt.size()<=2){
                max = Math.max(max, r-l+1);
            }
            while(cnt.size() > 2){
                cnt.put(tree[l], cnt.get(tree[l])-1);
                if(cnt.get(tree[l]) == 0){
                    cnt.remove(tree[l]);
                }
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
