package com.moses.leet.n0760;

import java.util.*;

public class NetworkDelayTime {

    //Dijkstra with priority queue. But it's Slow!!!!
    public int networkDelayTime(int[][] times, int N, int K) {
        boolean[] visited = new boolean[N+1];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] t : times){
            map.putIfAbsent(t[0], new HashMap<>());
            map.get(t[0]).put(t[1], t[2]);
        }

        int max = 0;
        int processed = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);        //Distance queue [0] - distance, [1] - Node
        q.offer(new int[]{0, K});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(visited[cur[1]]){
                continue;
            }
            visited[cur[1]] = true;
            max = cur[0];       //the last one will be the longest distance one.
            processed++;
            if(map.containsKey(cur[1])){
                for(int key : map.get(cur[1]).keySet()){
                    q.offer(new int[]{cur[0] + map.get(cur[1]).get(key), key});
                }
            }
        }
        return processed<N?-1:max;
    }

    //Dijkstra 算法. using array. Fastest
    public int networkDelayTimeDijkstra(int[][] times, int N, int K) {
        long[] shortest = new long[N+1];
        Arrays.fill(shortest, -1);
        int[] visited = new int[N+1];

        long[][] ary = new long[N+1][N+1];
        for(long[] a : ary){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        for(int[] t : times){
            ary[t[0]][t[1]] = t[2];
        }

        shortest[K] = 0;
        visited[K] = 1;
        long max = 0;
        for(int i=1; i<N; i++){
            long min = Integer.MAX_VALUE;
            int idx = -1;

            //find minimum distance node
            for(int j=1; j<N+1; j++){
                if(visited[j] == 0 && ary[K][j] < min){
                    min = ary[K][j];
                    idx = j;
                }
            }
            if(idx == -1){
                return -1;
            }

            shortest[idx] = min;
            visited[idx] = 1;

            //update
            for(int j=1; j<N+1; j++){
                if(visited[j] == 0 && ary[K][j] > ary[K][idx] + ary[idx][j]){
                    ary[K][j] = ary[K][idx] + ary[idx][j];
                }
            }

            max = Math.max(max, min);
        }
        return (int)max;
    }


    //佛洛依德算法
    public int networkDelayTimeFloyd(int[][] times, int N, int K) {
        long[][] ary = new long[N+1][N+1];
        for(int i=0; i<ary.length; i++){
            Arrays.fill(ary[i], Integer.MAX_VALUE);
        }
        for(int[] t : times){
            ary[t[0]][t[1]] = t[2];
        }
        for(int k=1; k<N+1; k++){
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    if(ary[i][k] + ary[k][j] < ary[i][j]){
                        ary[i][j] = ary[i][k] + ary[k][j];
                    }
                }
            }
        }

        long steps = 0;
        for(int i=1; i<N+1; i++){
            if(K== i){
                continue;
            }
            if(ary[K][i] == Integer.MAX_VALUE){
                return -1;
            }
            steps = Math.max(steps, ary[K][i]);
        }
        return (int)steps;
    }

    public static void main(String[] args) {
        int[][] times;
        times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new NetworkDelayTime().networkDelayTime(times, 4, 2));
    }
}
