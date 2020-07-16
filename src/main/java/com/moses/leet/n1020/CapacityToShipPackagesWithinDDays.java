package com.moses.leet.n1020;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int l=0, r = 0;
        for(int i : weights){
            l = Math.max(l, i);
            r += i;
        }

        while(l<r){
            int m = l+(r-l)/2;
            if(!check(weights, m, D)){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }

    private boolean check(int[] weights, int m, int d) {
        int tmp = 0;
        int days = 0;
        for(int i=0; i<weights.length; i++){
            if(tmp + weights[i] > m){
                days++;
                tmp = weights[i];
                if(days > d){
                    return false;
                }
            }else{
                tmp += weights[i];
            }
        }
        return days+1 <=d;
    }
}
