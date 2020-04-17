package com.moses.leet.n0800;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        //5,5,5,5,5,5,5,5,6,6,7,7,12
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : answers){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int total = 0;
        for(int i : map.keySet()){
            if(i==0){
                total+=map.get(i);
                continue;
            }
            if(map.get(i) <= i+1){
                total += i+1;
                continue;
            }
            if(map.get(i) % (i+1) == 0){
                total += map.get(i);
            }else{
                total += (i+1) * (map.get(i) / (i+1) + 1);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] ans;
        ans = new int[]{1,0,1,0,0};
        System.out.println(new RabbitsInForest().numRabbits(ans));
    }
}
