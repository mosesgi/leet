package com.moses.leet.n0340;

public class SelfCrossing {
    //none of below are coded by myself....
    public boolean isSelfCrossing(int[] x) {
        if(x.length<4){
            return false;
        }
        for(int i=3; i<x.length; i++){
            //fourth line cross first line
            if(x[i] >= x[i-2] && x[i-1] <= x[i-3]){
                return true;
            }
            //fifth line meets first line
            if(i>=4){
                if(x[i] + x[i-4] >= x[i-2] && x[i-1] == x[i-3]){
                    return true;
                }
            }
            //sixth line meets first line
            if(i>=5){
                if(x[i]>=(x[i-2]-x[i-4]) && x[i-1] <=x[i-3] && x[i-1]>= (x[i-3]-x[i-5]) && x[i-2] >= x[i-4]){
                    return true;
                }
            }
        }
        return false;
    }


    //another solution
    public boolean isSelfCrossingAnother(int[] x) {
        if (x.length <= 3) {
            return false;
        }
        int i = 2;
        // keep spiraling outward
        while (i < x.length && x[i] > x[i - 2]) {
            i++;
        }
        if (i >= x.length) {
            return false;
        }
        // transition from spiraling outward to spiraling inward
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) ||
                (i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        i++;
        // keep spiraling inward
        while (i < x.length) {
            if (x[i] >= x[i - 2]) {
                return true;
            }
            i++;
        }
        return false;
    }
}
