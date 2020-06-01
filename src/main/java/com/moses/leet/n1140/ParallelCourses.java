package com.moses.leet.n1140;

import java.util.*;

public class ParallelCourses {
    public int minimumSemesters(int N, int[][] relations) {
        int[] ind = new int[N+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] r : relations){
            ind[r[1]]++;
            map.computeIfAbsent(r[0], z-> new HashSet<>()).add(r[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        for(int i=1; i<N; i++){
            if(ind[i] == 0){
                q.offer(i);
                visited[i] = true;
            }
        }

        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
                for(int j : map.getOrDefault(cur, new HashSet<>())){
                    if(visited[j]){
                        continue;
                    }
                    ind[j]--;
                    if(ind[j] == 0){
                        visited[j] = true;
                        q.offer(j);
                    }
                }
            }
            res++;
        }
        for(int i=1; i<visited.length; i++){
            if(!visited[i]){
                return -1;
            }
        }
        return res;
    }
}
