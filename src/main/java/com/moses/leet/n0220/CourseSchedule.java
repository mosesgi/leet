package com.moses.leet.n0220;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> inMap = new HashMap<>();
        Map<Integer, Set<Integer>> outMap = new HashMap<>();
        for(int[] p : prerequisites){
            inMap.putIfAbsent(p[0], new HashSet<>());
            inMap.get(p[0]).add(p[1]);
            outMap.putIfAbsent(p[1], new HashSet<>());
            outMap.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(!inMap.containsKey(i) || inMap.get(i).isEmpty()){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                int source = q.poll();
                Set<Integer> targets = outMap.get(source);
                if(targets == null){
                    continue;
                }
                for(int j : targets){
                    inMap.get(j).remove(source);
                    if(inMap.get(j).isEmpty()){
                        inMap.remove(j);
                        q.offer(j);
                    }
                }
            }
        }

        for(int i=0; i<numCourses; i++){
            if(inMap.containsKey(i)){
                return false;
            }
        }
        return true;
    }






    public boolean canFinishOld(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Integer min = null;
        for(int[] ints : prerequisites){
            if(min == null || ints[1] < min){
                min = ints[1];
            }
            if(map.containsKey(ints[1])){
                List<Integer> list = map.get(ints[1]);
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(ints[0]);
                map.put(ints[1], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[0]);
                map.put(ints[1], list);
            }
        }

        // 0- not visited, 1 - visiting, 2 - finished visiting
        int[] visited = new int[numCourses];        //已遍历过的课程(2)无需再次遍历
        for(int i=0; i<numCourses; i++) {
            boolean rst = dfs(map, visited, i);
            if(!rst){
                return rst;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int curr){
        visited[curr] = 1;
        List<Integer> list = map.get(curr);
        if(list != null && !list.isEmpty()) {
            for (Integer i : list) {
                if(visited[i] == 0){
                    boolean tmpRst = dfs(map, visited, i);
                    if(!tmpRst){
                        return tmpRst;
                    }
                } else if (visited[i] == 1) {
                    return false;
                }
            }
        }
        visited[curr] = 2;
        return true;
    }

    public static void main(String[] args) {
        int nums;
        int[][] pre;

        nums = 2;
        pre = new int[][]{
                {1,0}
        };
        System.out.println(new CourseSchedule().canFinish(nums, pre));

        nums = 5;
        pre = new int[][]{
                {1,0}, {2,1}, {3,1}, {4,3}, {2,3}
        };
        System.out.println(new CourseSchedule().canFinish(nums, pre));

        nums = 5;
        pre = new int[][]{
                {1,0}, {2,1}, {3,1}, {4,3}, {1,2}
        };
        System.out.println(new CourseSchedule().canFinish(nums, pre));

        nums = 5;
        pre = new int[][]{
                {1,0}, {2,1}, {3,1}, {4,3}, {4,2}, {1,4}
        };
        System.out.println(new CourseSchedule().canFinish(nums, pre));

        nums = 5;
        pre = new int[][]{
                {1,0}, {2,1}, {3,1}, {0,4}
        };
        System.out.println(new CourseSchedule().canFinish(nums, pre));
    }


}
