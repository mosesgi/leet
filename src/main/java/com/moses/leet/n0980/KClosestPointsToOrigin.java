package com.moses.leet.n0980;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o2[0]*o2[0] + o2[1]*o2[1] - o1[0]*o1[0] - o1[1]*o1[1]);
        for(int[] ps : points){
            p.offer(ps);
            if(p.size() > K){
                p.poll();
            }
        }
        int[][] rst = new int[p.size()][2];
        int idx = 0;
        while(!p.isEmpty()){
            rst[idx] = p.poll();
        }
        return rst;
    }
}
