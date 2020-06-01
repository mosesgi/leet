package com.moses.leet.n1060;

import java.util.*;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : barcodes){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        p.addAll(map.entrySet());
        int[] res = new int[barcodes.length];
        int idx = 0;
        while(!p.isEmpty()){
            Map.Entry<Integer, Integer> o1 = p.poll();
            res[idx++] = o1.getKey();
            o1.setValue(o1.getValue()-1);
            Map.Entry<Integer, Integer> o2 = null;
            if(!p.isEmpty()){
                o2 = p.poll();
                res[idx++] = o2.getKey();
                o2.setValue(o2.getValue()-1);
            }
            if(o1.getValue() > 0){
                p.offer(o1);
            }
            if(o2 != null && o2.getValue() > 0){
                p.offer(o2);
            }
        }
        return res;
    }
}
