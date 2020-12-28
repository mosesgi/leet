package com.moses.leet.n0060;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        List<int[]> list = new ArrayList<>();
        if(intervals.length == 0){
            return new int[0][0];
        }
        list.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] prev = list.get(list.size() -1);
            int[] cur = intervals[i];
            if(prev[1]>=cur[0]){
                prev[0] = Math.min(prev[0], cur[0]);
                prev[1] = Math.max(prev[1], cur[1]);
            }else{
                list.add(cur);
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }


    public int[][] mergeOld(int[][] intervals){
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (i == 0) {
                list.add(curr);
                continue;
            }

            boolean overlap = mergeNew(list, curr);

        }

        int[][] result = list.toArray(new int[0][0]);
        return result;
    }

    private boolean mergeNew(List<int[]> list, int[] curr){
        boolean overlap = false;
        for(int[] prev : list) {
            if (curr[0] >= prev[0] && curr[0] <= prev[1] && curr[1] > prev[1]) {
                overlap = true;
                prev[1] = curr[1];
            } else if (curr[0] < prev[0] && curr[1] <= prev[1] && curr[1] >= prev[0]) {
                overlap = true;
                prev[0] = curr[0];
            } else if (curr[0] >= prev[0] && curr[1] <= prev[1]) {
                overlap = true;
            } else if (curr[0] < prev[0] && curr[1] > prev[1]) {
                overlap = true;
                prev[0] = curr[0];
                prev[1] = curr[1];
            }
        }
        if(overlap){
            mergeSelf(list, 0);
        }else{
            list.add(curr);
        }
        return overlap;
    }

    private void mergeSelf(List<int[]> list, int currPos){
        if(currPos >= list.size()-1){
            return;
        }
        int k=0;
        Iterator<int[]> iter = list.iterator();
        while(iter.hasNext()){
            if(k<=currPos){
                k++;
                iter.next();
                continue;
            }
            int[] prev = list.get(currPos);
            int[] curr = iter.next();
            boolean overlap = false;
            if (curr[0] >= prev[0] && curr[0] <= prev[1] && curr[1] > prev[1]) {
                overlap = true;
                prev[1] = curr[1];
            } else if (curr[0] < prev[0] && curr[1] <= prev[1] && curr[1] >= prev[0]) {
                overlap = true;
                prev[0] = curr[0];
            } else if (curr[0] >= prev[0] && curr[1] <= prev[1]) {
                overlap = true;
            } else if (curr[0] < prev[0] && curr[1] > prev[1]) {
                overlap = true;
                prev[0] = curr[0];
                prev[1] = curr[1];
            }
            if(overlap){
                iter.remove();
            }
            k++;
        }
        mergeSelf(list, currPos+1);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3}, {2,6}, {8,10}, {15,18}
        };
        int[][] rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


        intervals = new int[][]{
                {2,3},{5,5},{2,2},{3,4},{3,4},{2,5}
        };
        rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


        intervals = new int[][]{
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };
        rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


        intervals = new int[][]{
                {1,4}, {0,4}
        };
        rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


        intervals = new int[][]{
                {1,5}, {0,6}
        };
        rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


        intervals = new int[][]{
                {1,4}, {4,5}
        };
        rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


        intervals = new int[][]{
                {1,4}, {2,3}, {3,4}, {4, 6}, {7, 22}
        };
        rst = new MergeIntervals().merge(intervals);
        for(int i=0; i<rst.length; i++){
            System.out.print(Arrays.toString(rst[i]));
            System.out.print(',');
        }
        System.out.println();


    }
}
