package com.moses.leet.n0600;

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0){
            return m*n;
        }
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        for(int[] o : ops){
            minA = Math.min(o[0], minA);
            minB = Math.min(o[1], minB);
        }

        return minA * minB;
    }
}
