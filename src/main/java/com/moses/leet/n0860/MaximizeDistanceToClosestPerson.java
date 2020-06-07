package com.moses.leet.n0860;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        for(int i=0; i<seats.length; i++){
            if(seats[i] == 0){
                int dis = dfs(seats, i);
                max = Math.max(dis, max);
            }
        }
        return max;
    }

    private int dfs(int[] seats, int i) {
        int l = i-1, r = i+1;
        int d = 1;
        while(l>=0 || r<seats.length){
            if(l>=0 && seats[l] == 1){
                return d;
            }
            if(r<seats.length && seats[r] == 1){
                return d;
            }
            l--;
            r++;
            d++;
        }
        return -1;
    }
}
