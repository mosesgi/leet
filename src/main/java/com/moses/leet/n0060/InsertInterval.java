package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length==0){
            result.add(newInterval);
            return result.toArray(new int[0][0]);
        }
        int i=0;
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i++]);
        }
        while(i<intervals.length && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while(i < intervals.length){
            result.add(intervals[i++]);
        }
        return result.toArray(new int[0][0]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        List<int[]> result = new ArrayList<>();
        result.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            int[] prev = result.get(result.size()-1);
            int[] cur = list.get(i);
            if(prev[1] < cur[0]) {
                result.add(cur);
            }else{
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }
        return result.toArray(new int[0][0]);
    }


    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length==0){
            result.add(newInterval);
        }
        for(int i=0; i<intervals.length; i++){
            int[] ints = intervals[i];

            if(i==0){
                if(newInterval[1] < ints[0]) {
                    result.add(newInterval);
                    result.add(ints);
                    continue;
                } else if(newInterval[0] > ints[1]){
                    result.add(ints);
                    result.add(newInterval);
                    continue;
                } else {
                    int left = newInterval[0]<ints[0]?newInterval[0]:ints[0];
                    int right = newInterval[1]>=ints[1]?newInterval[1]:ints[1];
                    result.add(new int[]{left, right});
                    continue;
                }
            }

            int[] listEnd = result.get(result.size()-1);
            if(listEnd[0] > ints[1]){
                result.add(result.size()-1, ints);
            } else if(listEnd[1] < ints[0]){
                result.add(ints);
            } else if(listEnd[0] <=ints[0] && listEnd[1] >= ints[1]){
                continue;
            } else {
                int left = listEnd[0] < ints[0]?listEnd[0]:ints[0];
                int right = listEnd[1] > ints[1]?listEnd[1]:ints[1];
                listEnd[0] = left;
                listEnd[1] = right;
            }
        }


        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3}, {6,9}};
        int[] newInterval = new int[]{2,5};
        int[][] rst = new InsertInterval().insert(intervals, newInterval);
        for(int[] r:rst){
            System.out.print(Arrays.toString(r));
            System.out.print(",");
        }
        System.out.println();

        intervals = new int[][]{{1,5}};
        newInterval = new int[]{0,3};
        rst = new InsertInterval().insert(intervals, newInterval);
        for(int[] r:rst){
            System.out.print(Arrays.toString(r));
            System.out.print(",");
        }
        System.out.println();

        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        newInterval = new int[]{4,8};
        rst = new InsertInterval().insert(intervals, newInterval);
        for(int[] r:rst){
            System.out.print(Arrays.toString(r));
            System.out.print(",");
        }
        System.out.println();
    }
}
