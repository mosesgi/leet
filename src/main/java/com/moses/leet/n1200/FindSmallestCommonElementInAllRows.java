package com.moses.leet.n1200;

import java.util.PriorityQueue;

public class FindSmallestCommonElementInAllRows {
    public int smallestCommonElement(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i=0; i<rows; i++){
            p.offer(new int[]{mat[i][0], i, 0});
        }

        Integer num = null;
        int size = 0;
        while(!p.isEmpty()){
            int[] cur = p.poll();
            if(num == null){
                num = cur[0];
                size = 1;
            }else{
                if(cur[0] == num){
                    size++;
                    if(size == rows){
                        return num;
                    }
                }else{
                    size = 1;
                    num = cur[0];
                }
            }
            int col = cur[2];
            if(col + 1 < cols){
                p.offer(new int[]{mat[cur[1]][col+1], cur[1], col+1});
            }
        }
        return -1;
    }
}
