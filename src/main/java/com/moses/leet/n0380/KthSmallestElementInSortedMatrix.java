package com.moses.leet.n0380;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return 0;
        }
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {        //o[0] = val, o[1] = x, o[2] = y
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<cols; i++){
            p.offer(new int[]{matrix[0][i], 0, i});
        }
        int cnt = 0;
        int val = -1;
        while(cnt<k){
            int[] curr = p.poll();
            val = curr[0];
            cnt++;
            if(curr[1] == rows-1){
                continue;
            }
            p.offer(new int[]{matrix[curr[1]+1][curr[2]], curr[1]+1, curr[2]});
        }
        return val;
    }

    //O(Kn) n = cols
    public int kthSmallest1st(int[][] matrix, int k) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return 0;
        }
        int[] ind = new int[cols];
        int cnt = 0;

        int min = Integer.MAX_VALUE;
        while(cnt < k) {
            int colToIncr = -1;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < ind.length; i++) {
                if(ind[i] == rows){
                    continue;
                }
                if (matrix[ind[i]][i] < min) {
                    min = matrix[ind[i]][i];
                    colToIncr = i;
                }
            }
            ind[colToIncr]++;
            cnt++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix;
        int k;
        matrix = new int[][]{
                {1,5,9},{10,11,13}, {12,13,15}
        };
        k = 8;
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(matrix, k));
    }
}
