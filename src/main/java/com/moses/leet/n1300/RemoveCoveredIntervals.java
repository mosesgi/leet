package com.moses.leet.n1300;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]!=o2[0]?o1[0]-o2[0]:o2[1]-o1[1]);
        int x = intervals[0][0], y = intervals[0][1];
        int res = 1;
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            if(x<= cur[0] && y >= cur[1]){

            }else{
                x = cur[0];
                y = cur[1];
                res++;
            }
        }
        return res;
    }
}
