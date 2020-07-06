package com.moses.leet.n0640;

import java.util.*;

public class CourseScheduleIII {
    //official
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, ((o1, o2) -> {return o1[1] - o2[1];}));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        int end = 0;
        for(int[] c : courses){
            if(c[0] + end <= c[1]){
                queue.offer(c[0]);
            }else if(!queue.isEmpty() && queue.peek() > c[0]){
                int toDelete = queue.poll();
                end += (c[0] - toDelete);
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }

    public int scheduleCourseTLE(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        Integer[][] dp = new Integer[courses.length+1][courses[courses.length-1][1]+1];
        return dfs(courses, 0, 0, dp);
    }

    private int dfs(int[][] courses, int idx, int end, Integer[][] dp) {
        if(idx == courses.length){
            return 0;
        }
        String key = idx+"_"+ end;
        if(dp[idx][end]!=null){
            return dp[idx][end];
        }
        if(end + courses[idx][0] > courses[idx][1]){
            int rst = dfs(courses, idx+1, end ,dp);
            dp[idx][end] = rst;
            return rst;
        }else{
            int next1 = 1+dfs(courses, idx+1, end+courses[idx][0], dp);
            int next0 = dfs(courses, idx+1, end, dp);
            int rst = Math.max(next0, next1);
            dp[idx][end] = rst;
            return rst;
        }
    }

    public static void main(String[] args) {
        int[][] courses;
        courses = new int[][]{
                {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}
        };
        System.out.println(new CourseScheduleIII().scheduleCourse(courses));
    }
}
