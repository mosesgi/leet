package com.moses.leet.n1360;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int res = 0;
        int day = events[0][0];
        int i=0;
        while(i<events.length || !p.isEmpty()){
            while(i<events.length && events[i][0]<=day && events[i][1] >= day){
                p.offer(events[i++]);
            }

            if(!p.isEmpty() && p.peek()[0] <= day && p.peek()[1] >=day){
                p.poll();
                res++;
            }
            day++;
            while(!p.isEmpty() && p.peek()[1] < day){
                p.poll();
            }
        }
        return res;
    }




    public int maxEvents1(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        int i=1, res = 0;
        int day = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        p.offer(events[0]);
        day = events[0][0];
        while(i<events.length || !p.isEmpty()){
            //add all qualified meetings
            while(i<events.length && events[i][0] <= day && events[i][1] >=day){
                p.offer(events[i++]);
            }

            //attend the one with endDate closest to today.
            p.poll();

            res++;
            day++;
            //remove all meetings has passed.
            while(!p.isEmpty() && p.peek()[1] < day){
                p.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] events;
        events = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}};
        System.out.println(new MaximumNumberOfEventsThatCanBeAttended().maxEvents(events));
    }

    public int maxEventsTLE(int[][] events) {
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        for(int[] e : events){
            p.offer(e);
        }
        int res = 0;
        while(!p.isEmpty()){
            int[] cur = p.poll();
            int beginDay = cur[0];
            res++;

            while(!p.isEmpty() && p.peek()[0] == beginDay){
                int[] n = p.poll();
                n[0] = beginDay + 1;
                if(n[0] <= n[1]){
                    p.offer(n);
                }
            }
        }
        return res;
    }
}
