package com.moses.leet.n0600;

import java.util.Arrays;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] lens = new double[6];
        lens[0] = getPow(p1, p2);
        lens[1] = getPow(p2, p3);
        lens[2] = getPow(p4, p3);
        lens[3] = getPow(p4, p1);
        lens[4] = getPow(p1, p3);
        lens[5] = getPow(p2, p4);
        Arrays.sort(lens);
        if(lens[0] != lens[1] || lens[0] != lens[2] || lens[0] != lens[3] || lens[4] != lens[5]){
            return false;
        }
        if(lens[0] + lens[0] != lens[4]){
            return false;
        }
        return true;
    }

    private int getPow(int[] p1, int[] p2) {
        return (p2[0]-p1[0])*(p2[0]-p1[0]) + (p2[1]-p1[1])*(p2[1]-p1[1]);
    }
}
