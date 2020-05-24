package com.moses.leet.n0260;

import java.util.Arrays;

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        for(int i=1; i<intervals.length; i++){
            int[] prev = intervals[i-1];
            int[] cur = intervals[i];
            if(cur[0] < prev[1]){
                return false;
            }
        }
        return true;
    }
}
