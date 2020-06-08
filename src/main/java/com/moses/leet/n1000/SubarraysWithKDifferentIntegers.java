package com.moses.leet.n1000;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int l =0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for(int r = 0; r<A.length; r++){
            if(cnt.size()==K && !cnt.containsKey(A[r])) {
                while (l <= r && cnt.size() == K) {
                    cnt.put(A[l], cnt.get(A[l]) - 1);
                    if (cnt.get(A[l]) == 0) {
                        cnt.remove(A[l]);
                    }
                    if (cnt.size() == K) {
                        res++;
                    }
                    l++;
                }
            }
            cnt.put(A[r], cnt.getOrDefault(A[r], 0) + 1);
            if(cnt.size() <= K){
                if(cnt.size()==K){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A;int k;
        A = new int[]{1,2,1,2,3};
        k = 2;
        System.out.println(new SubarraysWithKDifferentIntegers().subarraysWithKDistinct(A, k));
    }
}
