package com.moses.leet.n1320;

public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int p = 0;
        int start = 1;
        if(n%2 != 0){
            res[p++] = 0;

        }
        while(p<n){
            res[p++] = start;
            res[p++] = -start;
            start++;
        }
        return res;
    }
}
