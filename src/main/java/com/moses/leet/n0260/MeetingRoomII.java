package com.moses.leet.n0260;

import java.util.Arrays;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，
 * 同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 */
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        //上下车
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int rooms = 0;
        int i=0, j = 0;
        while(i<starts.length && j < ends.length){
            if(starts[i] < ends[j]){
                rooms++;
                i++;
            }else{      //start >=end.
                rooms--;
                j++;
            }
            res = Math.max(res, rooms);
        }
        return res;
    }
}
