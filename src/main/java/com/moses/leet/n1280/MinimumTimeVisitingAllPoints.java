package com.moses.leet.n1280;

public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        // 1,0 -> 3,3   2+1
        // 1,0 -> 5,3   3+1
        // 3,2 -> -4,-3   5 + 2
        int res = 0;
        for(int i=1; i<points.length; i++){
            int[] p0 = points[i-1];
            int[] p1 = points[i];
            int a = Math.abs(p1[0]-p0[0]);
            int b = Math.abs(p1[1]-p0[1]);
            res += Math.max(a,b);
        }
        return res;
    }
}
