package com.moses.leet.n0280;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] ed : edges){
            int x = ed[0];
            int y = ed[1];
            map.putIfAbsent(x, new HashSet<>());
            map.putIfAbsent(y, new HashSet<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]){
                return false;
            }
            visited[cur] = true;
            if(!map.containsKey(cur)){
                continue;
            }
            for(int j : map.get(cur)){
                map.get(j).remove(cur);
                q.offer(j);
            }
            map.remove(cur);
        }

        for(boolean i : visited){
            if(!i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n; int[][] edges;
        n= 5;
        edges = new int[][]{
                {0,1}, {0,2}, {0,3},{1,4}
        };
        System.out.println(new GraphValidTree().validTree(n, edges));


        n= 4;
        edges = new int[][]{
                {2,3}, {1,2}, {1,3}
        };
        System.out.println(new GraphValidTree().validTree(n, edges));
    }

}
