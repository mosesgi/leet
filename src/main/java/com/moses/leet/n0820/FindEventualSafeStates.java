package com.moses.leet.n0820;

import java.util.*;

public class FindEventualSafeStates {

    //Color to find cycle
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] color = new int[graph.length];
        List<Integer> res = new ArrayList<>();
        //0 - unvisited, 1 - visiting, 2 - visited
        for(int i=0; i<graph.length; i++){
            if(dfs(i, graph, color)){
                res.add(i);
            }
        }
        return res;
    }

    boolean dfs(int i, int[][] graph, int[] color){
        if(color[i] > 0){
            return color[i] == 2;   //if visiting, it's cycle.
        }
        color[i] = 1;
        for(int j : graph[i]){
            if(!dfs(j, graph, color)){
                return false;
            }
        }
        color[i] = 2;
        return true;
    }



    public List<Integer> eventualSafeNodesTLE(int[][] graph) {
        Boolean[] safe = new Boolean[graph.length];
        boolean[] visited = new boolean[graph.length];

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            if((safe[i]!= null && safe[i]) || dfsTLE(graph, i, safe, visited)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfsTLE(int[][] graph, int start, Boolean[] safe, boolean[] visited) {
        if(graph[start].length == 0){
            safe[start]= true;
            return true;
        }

        if(safe[start] != null && !safe[start]){
            return false;
        }

        visited[start]= true;
        for(int s : graph[start]){
            if(visited[s] || (safe[start] != null && !safe[start])){
                safe[start] = false;
                visited[start]= false;
                return false;
            }
        }
        for(int s : graph[start]){
            if(!dfsTLE(graph, s,safe, visited)){
                safe[start] = false;
                visited[start] = false;
                return false;
            }
        }
        visited[start]= false;
        safe[start] = true;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph;
        graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(Arrays.toString(new FindEventualSafeStates().eventualSafeNodes(graph).toArray()));
    }
}
