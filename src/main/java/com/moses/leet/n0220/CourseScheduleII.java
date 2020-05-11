package com.moses.leet.n0220;

import java.util.*;

public class CourseScheduleII {

    //The other way is using DFS with Stack to store BLACK nodes.
    //And make sure all nodes are being iterated.

    //Topological Sort of Graph. Reduce Indegree
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDeg = new int[numCourses];
        for(int[] p : prerequisites){
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
            inDeg[p[0]]++;
        }

        int[] res = new int[numCourses];
        int pos = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDeg[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                int from = q.poll();
                res[pos++] = from;

                List<Integer> tos = map.get(from);
                if(tos == null || tos.isEmpty()){
                    continue;
                }
                for(int j : tos){
                    inDeg[j]--;
                    if(inDeg[j] == 0){
                        q.offer(j);
                    }
                }
            }
        }

        if(pos != numCourses){
            return new int[0];
        }
        return res;
    }



    public int[] findOrderOld(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] ints : prerequisites){
            if(map.containsKey(ints[1])){
                map.get(ints[1]).add(ints[0]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(ints[0]);
                map.put(ints[1], l);
            }
            inDegrees[ints[0]]++;
        }

        //Find inCnt = 0 vertex, BFS, remove vertex and edge, and reduce adjacent vertex inCnt.
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegrees.length; i++){
            if(inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        int[] rst = new int[numCourses];
        int k = 0;
        while(!q.isEmpty()){
            Integer curr = q.poll();
            rst[k++] = curr;
            List<Integer> list = map.get(curr);
            if(list != null && !list.isEmpty()){
                for(Integer j : list){
                    inDegrees[j]--;
                    if(inDegrees[j] == 0){
                        q.offer(j);
                    }
                }
            }
        }
        if(k!=numCourses){
            return new int[0];
        }
        return rst;
    }

    public static void main(String[] args) {
        int num;
        int[][] prer;

        num = 2;
        prer = new int[][]{{1,0}};
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(num, prer)));

        num = 4;
        prer = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(num, prer)));

        num = 5;
        prer = new int[][]{
                {1,0}, {2,1}, {3,1}, {4,3}, {4,2}, {1,4}
        };
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(num, prer)));
    }
}
