package com.moses.leet.n0880;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> B[o1]-B[o2]);
        for(int i=0; i<B.length; i++){
            p.offer(i);
        }
        TreeMap<Integer, Integer> as = new TreeMap<>();
        for(int i : A){
            as.put(i, as.getOrDefault(i, 0) + 1);
        }
        while(!p.isEmpty()){
            int pos = p.poll();
            Integer a = as.higherKey(B[pos]);
            if(a != null){
                A[pos] = a;
                as.put(a, as.get(a) - 1);
                if(as.get(a) == 0){
                    as.remove(a);
                }
            }else{
                int k = as.keySet().iterator().next();
                A[pos] = k;
                as.put(k, as.get(k)-1);
                if(as.get(k) == 0){
                    as.remove(k);
                }
            }
        }
        return A;
    }
}
